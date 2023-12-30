package Arnoldas.Battleships_Game.controller;

import Arnoldas.Battleships_Game.repository.model.GameBoard;
import Arnoldas.Battleships_Game.service.BattleShipsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/battleShips")
public class BattleShipsController {

@Autowired
BattleShipsService battleShipsService;

    //    http://localhost:8080/battleShips/home
@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
    return "home";
}

    //    http://localhost:8080/battleShips/generateField
    @RequestMapping(value = "/generateField", method = RequestMethod.POST)
    @ResponseBody
    public char[][] generateField(HttpSession session) {
        GameBoard gameBoard = new GameBoard();
        char[][] generatedBoard = battleShipsService.paintShips(gameBoard.getField());
        session.setAttribute("gameBoard", generatedBoard);
        return generatedBoard;
    }

}
