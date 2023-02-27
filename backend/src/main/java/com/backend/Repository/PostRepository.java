package com.backend.Repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.Models.PostModels;

public interface PostRepository extends CrudRepository<PostModels, Long> {
    
}
