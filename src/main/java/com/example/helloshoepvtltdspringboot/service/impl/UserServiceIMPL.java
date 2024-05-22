package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.dto.UserDTO;
import com.example.helloshoepvtltdspringboot.repositary.EmployeeDao;
import com.example.helloshoepvtltdspringboot.repositary.UserDao;
import com.example.helloshoepvtltdspringboot.service.UserService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    @Autowired
    private final UserDao userDao;
    @Autowired
    private final Mapping map;
    @Autowired
    private final EmployeeDao employeeDao;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDao.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void save(UserDTO user) {
        map.toUserDTO(userDao.save(map.toUserEntity(user)));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return map.toEmployeeDTOList(employeeDao.findAll());
    }

    @Override
    public List<UserDTO> getAllUser() {
        return map.toUserDTOList(userDao.findAll());
    }
}
