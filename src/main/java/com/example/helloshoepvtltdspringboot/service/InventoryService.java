package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO inventoryDTO);

    void saveInventory(List<InventoryDTO> inventoryDTOList);

    Integer getSizeQty(String shoeCode, Integer size);

    List<InventoryDTO> getAllInventory();

    InventoryDTO getAllSizeQty(String shoeCode, Integer size);
}
