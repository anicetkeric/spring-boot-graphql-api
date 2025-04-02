package com.bootlabs.springbootgraphqlapi.service;


import com.bootlabs.springbootgraphqlapi.entities.Author;
import com.bootlabs.springbootgraphqlapi.exception.DataNotFoundException;
import com.bootlabs.springbootgraphqlapi.repositories.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link Author}.
 * @author aek
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repo) {
         this.repository = repo;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Author create(Author d) {
        return repository.save(d);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author update(Author d) {
        return repository.saveAndFlush(d);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Author getOne(Long id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("id not found"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> getAll() {
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
	public Page<Author> findAllPaginate(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
