package Arnoldas.Battleships_Game.controller;

import Arnoldas.Battleships_Game.repository.model.GameBoard;
import Arnoldas.Battleships_Game.service.BattleShipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/battleShips")
public class BattleShipsController {

@Autowired
BattleShipsService battleShipsService;


// http://localhost:8080/battleShips/home
@RequestMapping(value = "/home", method = RequestMethod.GET)
public String getNewBoard(Model model){

    GameBoard gameBoard = new GameBoard();
    char[][] field = gameBoard.getField();
    battleShipsService.paintShips(field);
    return "home";
}
}
