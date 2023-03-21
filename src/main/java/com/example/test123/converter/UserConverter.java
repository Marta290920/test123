package com.example.test123.converter;

import com.example.test123.dto.UserInfoDTO;
import com.example.test123.dto.UserViewDTO;
import com.example.test123.entity.UserEntity;

public final class UserConverter {

    public static UserEntity convert(UserInfoDTO userInfoDTO) {
        return UserEntity.builder()
                .id(userInfoDTO.getId())
                .body(userInfoDTO.getBody())
                .postId(userInfoDTO.getPostId())
                .username(userInfoDTO.getUser().getUsername())
                .updatedAt(userInfoDTO.getUpdatedAt())
                .build();
    }

    public static UserViewDTO convert(UserEntity userEntity) {
        return UserViewDTO.builder()
                .id(userEntity.getId())
                .body(userEntity.getBody())
                .postId(userEntity.getPostId())
                .username(userEntity.getUsername())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }
}
