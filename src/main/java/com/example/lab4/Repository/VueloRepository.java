package com.example.lab4.Repository;

import com.example.lab4.Entity.User;
import com.example.lab4.Entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VueloRepository extends JpaRepository<Vuelo,Integer> {



}
