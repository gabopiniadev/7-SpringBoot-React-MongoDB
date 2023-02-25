package com.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.backend.Models.LoginModels;


public interface LoginRepository extends JpaRepository<LoginModels, Long>{

    @Query("SELECT username FROM users where username = :username")
    LoginModels findByUsername(@Param("username") String username);

}
