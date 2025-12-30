package com.shashwathsh.Library.Management.System.repository;

import com.shashwathsh.Library.Management.System.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
