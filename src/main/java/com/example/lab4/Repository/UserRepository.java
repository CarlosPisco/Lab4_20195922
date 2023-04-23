package com.example.lab4.Repository;

import com.example.lab4.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(nativeQuery = true, value="select * from user where email = ?1 and password= ?2")
    User buscarUserLogin(String correo, String Password);

    @Query(nativeQuery = true, value="select iduser from user where email=?1")
    Integer obtenerUserByCorreo(String correo);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value="Insert into reserva \n" +
            "(fecha_reserva,precio_total,estado_pago,user_iduser,vuelo_idvuelo)\n" +
            "values ( now(),  ?1,  \"reservado\", ?2, ?3);")
    void reservarVuelo(Integer precio,Integer idUser, Integer idVuelo);



}
