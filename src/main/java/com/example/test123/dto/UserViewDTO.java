package com.example.test123.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserViewDTO {
    private Long id;
    private String body;
    private Long postId;
    private String updatedAt;
    private String username;
}
