package com.bootlabs.springbootgraphqlapi.repositories;

import com.bootlabs.springbootgraphqlapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}


