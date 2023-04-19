package com.example.lab4.Repository;

import com.example.lab4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true, value="select * from user where correo = ?1 and password= ?2")
    User buscarUserLogin(String correo, String Password);

}
