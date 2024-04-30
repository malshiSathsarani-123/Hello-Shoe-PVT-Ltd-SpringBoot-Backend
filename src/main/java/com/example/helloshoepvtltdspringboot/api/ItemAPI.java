package com.example.helloshoepvtltdspringboot.api;

import com.example.helloshoepvtltdspringboot.dto.ItemDTO;
import com.example.helloshoepvtltdspringboot.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor
public class ItemAPI {
    @Autowired
    private final ItemService itemService;
    @PostMapping
    public void saveItem(@RequestBody ItemDTO itemDTO){
        System.out.println(itemDTO);
        itemService.saveItem(itemDTO);
    }
}
