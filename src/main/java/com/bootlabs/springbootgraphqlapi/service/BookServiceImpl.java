package com.bootlabs.springbootgraphqlapi.service;


import com.bootlabs.springbootgraphqlapi.entities.Book;
import com.bootlabs.springbootgraphqlapi.exception.DataNotFoundException;
import com.bootlabs.springbootgraphqlapi.repositories.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Book}.
 * @author aek
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {


    private final BookRepository repository;

    public BookServiceImpl(BookRepository repo) {
         this.repository = repo;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Book create(Book d) {
        return repository.save(d);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book update(Book d) {
        return repository.saveAndFlush(d);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("book not found!"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTotal() {
        return repository.count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
   	@Override
	public Page<Book> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
