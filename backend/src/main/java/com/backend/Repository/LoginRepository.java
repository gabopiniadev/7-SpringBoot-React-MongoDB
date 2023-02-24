package com.backend.Repository;

import org.springframework.data.repository.CrudRepository;
import com.backend.Models.LoginModels;

public interface LoginRepository extends CrudRepository<LoginModels, String>{

    LoginModels findByUsernameAndPassword(String username, String password);

}
