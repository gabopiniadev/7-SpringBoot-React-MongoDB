package com.backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Models.PostModels;
import com.backend.Repository.PostRepository;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;

	/*public PostModels loadUserByUsername(String username) {
       
        return postRepository.findByUser(username);

    }*/

    public List<PostModels> findAll() {
		return (List<PostModels>) postRepository.findAll();
	}

	public void save(PostModels post) {
		postRepository.save(post);
	}

	public PostModels findById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	public void delete(PostModels post) {
		postRepository.delete(post);
	}
    
}
