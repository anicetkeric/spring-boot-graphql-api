package com.bootlabs.springbootgraphqlapi.service;

import com.bootlabs.springbootgraphqlapi.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing {@link Author}.
*  @author aek
 */
public interface AuthorService  {
   
    /**
     * create new item for domain
     *
     * @param author entity to save.
     * @return persisted entity Author
     */
    Author create(Author author);

    /**
     * Update entity. Check before if existing data. If data is empty throw Exception
     *
     * @param author domain
     * @return Author
     */
    Author update(Author author);

    /**
     * get Author by id. Can be return empty
     *
     * @param id the id of the entity.
     * @return Author
     */
    Author getOne(Long id) ;

    /**
     * Get all entities
     *
     * @return list of entities List<Author>
     */
    List<Author> getAll();

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
     * @return Page<Author>  
     */
    Page<Author> findAllPaginate(Pageable pageable);


}
