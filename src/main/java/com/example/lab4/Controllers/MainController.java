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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {


    UserRepository userRepository;


    VueloRepository vueloRepository;

    public MainController(UserRepository userRepository, VueloRepository vueloRepository) {
        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
    }

    @GetMapping("/inicio")
    public String login () {

        return "inicio";
    }



    @PostMapping("/credenciales")
    public String verifyInicio(@RequestParam("correo") String correo,
                                @RequestParam ("contrasena") String contrasena,
                                RedirectAttributes attr){



        User user = userRepository.buscarUserLogin(correo,contrasena);

        if(user!=null){
            attr.addFlashAttribute("correo",correo);

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


    @PostMapping("/reservar")
    public String reservarVueloUser(@RequestParam("correo") String correo,
                                    @RequestParam("idvuelo") Integer idvuelo,
                                    @RequestParam("precio") Integer precio,
                                    RedirectAttributes attr ) {

        //List<Shipper> lista = shipperRepository.findByCompanyNameOrPhone(textoBuscar, textoBuscar);
        Integer id =  userRepository.obtenerUserByCorreo(correo);
        userRepository.reservarVuelo(precio,id,idvuelo);
        attr.addFlashAttribute("correo",correo);
        attr.addFlashAttribute("msg","Se realizo con exito su reserva.");

        return "redirect:/homepage";
    }


    @PostMapping("/home")
    public String volverFromModal(@RequestParam("correo") String correo,RedirectAttributes attr){
        attr.addFlashAttribute("correo",correo);
        return "redirect:/homepage";
    }















}
