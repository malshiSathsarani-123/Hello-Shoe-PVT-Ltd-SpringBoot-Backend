package com.example.helloshoepvtltdspringboot.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class InventoryApi {

}
