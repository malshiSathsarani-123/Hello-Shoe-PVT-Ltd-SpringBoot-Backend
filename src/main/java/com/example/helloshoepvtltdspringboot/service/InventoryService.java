package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO inventoryDTO);

    void saveInventory(List<InventoryDTO> inventoryDTOList);
}
