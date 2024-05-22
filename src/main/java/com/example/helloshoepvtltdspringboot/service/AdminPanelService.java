package com.example.helloshoepvtltdspringboot.service;

import com.example.helloshoepvtltdspringboot.dto.AdminPanelDTO;

import java.time.LocalDate;

public interface AdminPanelService {
    AdminPanelDTO getAdminPanelData(LocalDate date);
}
