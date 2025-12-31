package com.shashwathsh.Library.Management.System.repository;

import com.shashwathsh.Library.Management.System.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    BookEntity findByNameContainingIgnoreCase(String name);

    List<BookEntity> findByPublishDateAfter(LocalDate date);

    List<BookEntity> findByAuthorAuthorId(Long authorId);

}