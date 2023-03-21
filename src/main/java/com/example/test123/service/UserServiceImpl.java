package com.example.test123.service;

import com.example.test123.converter.UserConverter;
import com.example.test123.dto.DataDTO;
import com.example.test123.dto.UserViewDTO;
import com.example.test123.repository.UserRepository;
import com.example.test123.request.DataRequester;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d-M-y H:m:s");

    private final DataRequester dataRequester;

    private final UserRepository userRepository;

    public UserServiceImpl(final DataRequester dataRequester, final UserRepository userRepository) {
        this.dataRequester = dataRequester;
        this.userRepository = userRepository;
    }

    @Override
    public void saveData() {
        DataDTO dataDTO = dataRequester.fetchCommentsData();
        dataDTO.getUsers().forEach(comment -> {
            improveComment(comment);
            userRepository.save(UserConverter.convert(comment));
        });
    }

    @Override
    public List<UserViewDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserConverter::convert).collect(Collectors.toList());
    }

    private void improveComment(com.example.test123.dto.UserInfoDTO comment) {
        comment.setUpdatedAt(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        comment.getUser().setUsername(replaceFirstLetterToUpperCase(comment.getUser().getUsername()));
    }

    private String replaceFirstLetterToUpperCase(String value) {
        return Character.toUpperCase(value.charAt(0)) + value.substring(1);
    }
}
