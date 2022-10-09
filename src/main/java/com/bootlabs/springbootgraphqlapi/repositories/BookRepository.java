package com.bootlabs.springbootgraphqlapi.repositories;

import com.bootlabs.springbootgraphqlapi.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}


