package com.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.Models.PostModels;
@Repository
public interface PostRepository extends CrudRepository<PostModels, Long> {
    
}
