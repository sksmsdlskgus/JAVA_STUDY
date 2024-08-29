package com.ohgiraffers.userservice.service;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registUser(UserDTO userDTO) {

        /* 설명. 회원 가입 할 인원에게 고유 아이디 생성 */
        userDTO.setUserId(UUID.randomUUID().toString());

    }
}
