package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.ItemDTO;
import com.example.helloshoepvtltdspringboot.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class ItemAPI {
    @Autowired
    private final ItemService itemService;
    @PostMapping
    public void saveItem(@RequestBody ItemDTO itemDTO){
        itemService.saveItem(itemDTO);
    }

    @GetMapping
    public List<ItemDTO> getAllItem(){
        return itemService.getAllItem();
    }

    @DeleteMapping("/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteItem(@PathVariable("code") String code){
        itemService.deleteItem(code);
    }

}
