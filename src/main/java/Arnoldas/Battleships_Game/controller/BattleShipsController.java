package Arnoldas.Battleships_Game.controller;

import Arnoldas.Battleships_Game.service.BattleShipsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/battleShips")
public class BattleShipsController {

@Autowired
BattleShipsService battleShipsService;

// http://localhost:8080/battleShips/home
@GetMapping(value = "/home")
public String home(HttpSession session){

    battleShipsService.paintShips();
    return "home";
}
}
