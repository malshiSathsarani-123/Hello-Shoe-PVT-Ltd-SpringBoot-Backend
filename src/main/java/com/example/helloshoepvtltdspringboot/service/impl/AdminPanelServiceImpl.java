package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.AdminPanelDTO;
import com.example.helloshoepvtltdspringboot.repositary.OrderDao;
import com.example.helloshoepvtltdspringboot.repositary.OrderItemDao;
import com.example.helloshoepvtltdspringboot.service.AdminPanelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminPanelServiceImpl implements AdminPanelService {

    @Autowired
    private final OrderDao orderDao;

    @Autowired
    private final OrderItemDao orderItemDao;
    @Override
    public AdminPanelDTO getAdminPanelData(LocalDate date) {
        Double totalAmountByDate = orderDao.findTotalAmountByDate(date);
        Double totalProfitByDate = orderDao.findTotalProfitByDate(date);
        String bestSellingShoeCodeByDate = orderItemDao.findBestSellingShoeCodeByDate(date);
        String bestSellingShoeCodeImageByDate = orderItemDao.findBestSellingShoeCodeImageByDate(date);
        Integer bestSellingShoeCodeQtyByDate = orderItemDao.findBestSellingShoeCodeQtyByDate(date);
        return new AdminPanelDTO(totalAmountByDate,totalProfitByDate,bestSellingShoeCodeByDate,bestSellingShoeCodeImageByDate,bestSellingShoeCodeQtyByDate);
    }
}
