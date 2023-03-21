package com.example.test123.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDTO {
    @JsonProperty("comments")
    private List<UserInfoDTO> users;
    private Long total;
    private Long skip;
    private Long limit;
}
