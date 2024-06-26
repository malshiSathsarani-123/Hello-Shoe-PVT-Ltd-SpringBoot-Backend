package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.dto.InventoryDTO;
import com.example.helloshoepvtltdspringboot.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class InventoryApi {
    @Autowired
    private final InventoryService inventoryService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void saveInventory(@RequestBody List<InventoryDTO> inventoryDTOList){
        inventoryService.saveInventory(inventoryDTOList);
    }
    @GetMapping("/getSizeQty")
    public Integer getSizeQty(@RequestParam String shoeCode, @RequestParam Integer size ){
        return inventoryService.getSizeQty(shoeCode,size);
    }

    @GetMapping("/getAllSizeQty")
    public InventoryDTO getAllSizeQty(@RequestParam String shoeCode, @RequestParam Integer size ){
        return inventoryService.getAllSizeQty(shoeCode,size);
    }

    @GetMapping("/getAll")
    public List<InventoryDTO> GetAllInventory(){
        return inventoryService.getAllInventory();
    }
//    @PostMapping
//    public void saveInventory(@RequestBody InventoryDTO inventoryDTO){
//        inventoryService.saveInventory(inventoryDTO);
//    }
}
