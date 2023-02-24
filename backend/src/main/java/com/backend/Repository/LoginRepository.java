package com.backend.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.backend.Models.LoginModels;


public interface LoginRepository extends CrudRepository<LoginModels, Long>{

    /**
     * @param username
     * @return
     */
    //@Query("FROM users where username = :username")
    LoginModels findByUsername(@Param("username") String username);

}
