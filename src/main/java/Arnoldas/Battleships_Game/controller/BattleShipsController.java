package Arnoldas.Battleships_Game.controller;

import Arnoldas.Battleships_Game.repository.model.GameBoard;
import Arnoldas.Battleships_Game.service.BattleShipsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/battleShips")
public class BattleShipsController {

@Autowired
BattleShipsService battleShipsService;
    GameBoard gameBoard;

    //    http://localhost:8080/battleShips/home
@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
    gameBoard = new GameBoard();
    gameBoard.setField(battleShipsService.paintShips(gameBoard.getField()));
    return "home";
}

    @RequestMapping(value = "/getMoveCords", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void getMoveCoordinates(@RequestBody ObjectNode cordsResponse) {

    char[][] generatedBoard = gameBoard.getField();
        System.out.println(cordsResponse);

        battleShipsService.makeAMove(generatedBoard, cordsResponse);
        //cia ikelti modifikatiota metoda, ir is cia imesti i html
    }

}
