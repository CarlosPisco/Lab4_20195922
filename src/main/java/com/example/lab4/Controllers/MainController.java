package com.example.lab4.Controllers;


import com.example.lab4.Entity.User;
import com.example.lab4.Entity.Vuelo;
import com.example.lab4.Repository.UserRepository;
import com.example.lab4.Repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VueloRepository vueloRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/inicio")
    public String login () {

        return "inicio";
    }



    @PostMapping("/credenciales")
    public String guardarJuegos(@RequestParam("correo") String correo,
                                @RequestParam ("contrasena") String contrasena){



        User user = userRepository.buscarUserLogin(correo,contrasena);

        if(user!=null){
            return "redirect:/homepage";
        }else {
            return "redirect:/inicio";
        }


    }


    @GetMapping("/homepage")
    public String listarVuelos (Model model) {

        List<Vuelo> listaVuelo = vueloRepository.findAll();
        model.addAttribute("listaVuelo",listaVuelo);

        return "homePage";
    }



















}
