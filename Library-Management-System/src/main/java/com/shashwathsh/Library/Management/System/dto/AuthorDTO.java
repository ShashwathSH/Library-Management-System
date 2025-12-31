package com.shashwathsh.Library.Management.System.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AuthorDTO {

    private Long authorId;
    private String name;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime createdAt;
}