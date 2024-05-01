package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.ItemDTO;
import com.example.helloshoepvtltdspringboot.enums.ItemGender;
import com.example.helloshoepvtltdspringboot.enums.Occasion;
import com.example.helloshoepvtltdspringboot.enums.Verities;
import com.example.helloshoepvtltdspringboot.repositary.ItemDao;
import com.example.helloshoepvtltdspringboot.service.ItemService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    @Autowired
    private final ItemDao itemDao;

    @Autowired
    private final Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setShoeCode(selectItemCategory(itemDTO.getOccasion(),itemDTO.getVerities(),itemDTO.getItemGender()));
        itemDao.save(mapping.toItem(itemDTO));
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return mapping.toItemDTOList(itemDao.findAll());
    }

    @Override
    public void deleteItem(String code) {
        itemDao.deleteById(code);
    }

    private String selectItemCategory(Occasion occasion, Verities verities, ItemGender gender) {
        String gender1=null;
        String occasion1=null;
        String verities1=null;
        switch (gender) {
            case WOMEN: gender1 = "W";
                break;
            case MAN:
                gender1 = "M";
                break;
            default:
        }

        switch (occasion) {
            case FORMAL:
                occasion1 = "F";
                break;
            case CASUAL:
                occasion1 = "C";
                break;
            case INDUSTRIAL:
                occasion1 = "I";
                break;
            case SPORT:
                occasion1 = "S";
                break;
        }

        switch (verities) {
            case HEEL:
                verities1 = "H";
                break;
            case FLAT:
                verities1 = "F";
                break;
            case WEDGES:
                verities1 = "W";
                break;
            case FLIP_FLOPS:
                verities1 = "FF";
                break;
            case SANDALS:
                verities1 = "SD";
                break;
            case SHOES:
                verities1 = "S";
                break;
            case SLIPPERS:
                verities1 = "SL";
                break;
        }
        return nextItemId(occasion1 + verities1 + gender1) ;
    }

    public String nextItemId(String concatString) {
        String maxId = itemDao.findMaxId();
        if (maxId != null){
            return generateNextItemId(maxId,concatString);
        }else {
            return concatString+"001";
        }
    }

    private static String generateNextItemId(String lastItemId, String concatString) {
        int nextNumericValue = Integer.parseInt(lastItemId) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return  concatString + nextNumericPart;
    }
}
