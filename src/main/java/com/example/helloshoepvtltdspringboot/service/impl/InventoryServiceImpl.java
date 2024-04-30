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
}
