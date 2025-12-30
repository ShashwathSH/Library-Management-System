package com.shashwathsh.Library.Management.System.repository;

import com.shashwathsh.Library.Management.System.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.event.RecordApplicationEvents;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
}
