package com.example.test123.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private Long id;
    private String body;
    private Long postId;
    private String updatedAt;
    private UserDataDTO user;
}
