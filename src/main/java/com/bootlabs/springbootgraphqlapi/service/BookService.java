package com.bootlabs.springbootgraphqlapi.service;

import com.bootlabs.springbootgraphqlapi.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing {@link Book}.
*  @author aek
 */
public interface BookService {
   
    /**
     * create new item for domain
     *
     * @param book entity to save.
     * @return persisted entity Book
     */
    Book create(Book book);

    /**
     * Update entity. Check before if existing data. If data is empty throw Exception
     *
     * @param book domain
     * @return Book
     */
    Book update(Book book);

    /**
     * get Book by id. Can be return empty
     *
     * @param id the id of the entity.
     * @return Book
     */
    Book getOne(Long id) ;

    /**
     * Get all entities
     *
     * @return list of entities List<Book>
     */
    List<Book> getAll();

    /**
     * Count item in entity
     *
     * @return long 
     */
    long getTotal();

    /**
     * Delete record by id
     *  
     */
    void delete(Long id);

    /**
     * Find all with pagination
     *
     * @return Page<Book>  
     */
    Page<Book> findAllPaginate(Pageable pageable);


}
