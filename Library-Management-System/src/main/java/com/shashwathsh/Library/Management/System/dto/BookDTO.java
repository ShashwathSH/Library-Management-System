package com.shashwathsh.Library.Management.System.dto;


import com.shashwathsh.Library.Management.System.entity.AuthorEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BookDTO {

    private Long bookId;
    private String name;
    private AuthorEntity author;
    private BigInteger price;
    private LocalDate publishDate;
    private LocalDateTime createdAt;
}