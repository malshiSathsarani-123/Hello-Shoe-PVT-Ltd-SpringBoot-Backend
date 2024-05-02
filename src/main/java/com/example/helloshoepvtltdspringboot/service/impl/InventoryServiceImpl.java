package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.InventoryDTO;
import com.example.helloshoepvtltdspringboot.entity.InventoryEntity;
import com.example.helloshoepvtltdspringboot.entity.ItemEntity;
import com.example.helloshoepvtltdspringboot.entity.SupplierEntity;
import com.example.helloshoepvtltdspringboot.repositary.InventoryDao;
import com.example.helloshoepvtltdspringboot.repositary.ItemDao;
import com.example.helloshoepvtltdspringboot.repositary.SupplierDao;
import com.example.helloshoepvtltdspringboot.service.InventoryService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private final InventoryDao inventoryDao;

    @Autowired
    private final ItemDao itemDao;

    @Autowired
    private final SupplierDao supplierDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public void saveInventory(InventoryDTO inventoryDTO) {
        inventoryDTO.setCode(UUID.randomUUID().toString());
        InventoryEntity inventory = mapping.toInventory(inventoryDTO);
        ItemEntity referenceById = itemDao.getReferenceById(inventoryDTO.getShoeCode());
        SupplierEntity referenceById1 = supplierDao.getReferenceById(inventoryDTO.getSupplierId());
        inventory.setItemEntity(referenceById);
        inventory.setSupplierEntity(referenceById1);
        inventoryDao.save(inventory);
    }

    @Override
    public void saveInventory(List<InventoryDTO> inventoryDTOList) {
        for (InventoryDTO inventoryDTO : inventoryDTOList) {
            inventoryDTO.setCode(UUID.randomUUID().toString());
            InventoryEntity inventory = mapping.toInventory(inventoryDTO);
            Optional<ItemEntity> byId = itemDao.findById(inventoryDTO.getShoeCode());
            ItemEntity itemEntity = new ItemEntity(inventoryDTO.getShoeCode(), byId.get().getDescription(), byId.get().getItemGender(), byId.get().getOccasion(), byId.get().getVerities());
            inventory.setItemEntity(itemEntity);
            Optional<SupplierEntity> byId1 = supplierDao.findById(inventoryDTO.getSupplierId());
            SupplierEntity supplierEntity = new SupplierEntity(inventoryDTO.getSupplierId(), byId1.get().getName(), byId1.get().getCategory(), byId1.get().getAddress(), byId1.get().getContact1(), byId1.get().getContact2(), byId1.get().getEmail());
            inventory.setSupplierEntity(supplierEntity);
            inventoryDao.save(inventory);
        }
    }

    @Override
    public Integer getSizeQty(String shoeCode, Integer size) {
        return inventoryDao.getTotalQuantityByShoeCodeAndSize(shoeCode,size);
    }
}
