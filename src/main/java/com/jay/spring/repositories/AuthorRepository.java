package com.jay.spring.repositories;

import com.jay.spring.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author,Long> {

}