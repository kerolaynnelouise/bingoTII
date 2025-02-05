package com.senac.bingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Controller
public class JogoController {

    @GetMapping("/jogo")
    public String abrirJogo(Model model){
        Random random = new Random();
        HashSet<Integer> umAQuinze = new HashSet<>();
        HashSet<Integer> dezesseisATrinta = new HashSet<>();
        HashSet<Integer> quarentaESeisASessenta = new HashSet<>();
        HashSet<Integer> sessentaEUmASetentaECinco = new HashSet<>();
        do {
            if(umAQuinze.size() < 5)
                umAQuinze.add(random.nextInt(1,15));
            if(dezesseisATrinta.size() < 5)
                dezesseisATrinta.add(random.nextInt(16,30));
            if(quarentaESeisASessenta.size() < 5)
                quarentaESeisASessenta.add(random.nextInt(46,60));
            if(sessentaEUmASetentaECinco.size() < 5)
                sessentaEUmASetentaECinco.add(random.nextInt(61,75));
        } while (
          umAQuinze.size() < 5 ||
          dezesseisATrinta.size() < 5 ||
          quarentaESeisASessenta.size() < 5 ||
          sessentaEUmASetentaECinco.size() < 5
        );

        HashSet<Integer> trintaEUmAQuarentaECinco = new HashSet<>();
        do {
            trintaEUmAQuarentaECinco.add(random.nextInt(31,45));
        } while (trintaEUmAQuarentaECinco.size() < 4);

        model.addAttribute("B", umAQuinze);
        model.addAttribute("I", dezesseisATrinta);
        model.addAttribute("N", trintaEUmAQuarentaECinco);
        model.addAttribute("G", quarentaESeisASessenta);
        model.addAttribute("O", sessentaEUmASetentaECinco);

        return "jogo";
    }

}
