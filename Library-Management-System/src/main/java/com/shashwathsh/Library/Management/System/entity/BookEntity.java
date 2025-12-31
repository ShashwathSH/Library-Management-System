package com.shashwathsh.Library.Management.System.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.yaml.snakeyaml.events.Event;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    private BigInteger price;

    private LocalDate publishDate;

    @CreationTimestamp
    private LocalDateTime createdAt;
}