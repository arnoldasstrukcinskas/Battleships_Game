package Arnoldas.Battleships_Game.controller;

import Arnoldas.Battleships_Game.repository.model.GameBoard;
import Arnoldas.Battleships_Game.service.BattleShipsService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/battleShips")
public class BattleShipsController {

@Autowired
BattleShipsService battleShipsService;
@Autowired
GameBoard gameBoard;

    //    http://localhost:8080/battleShips/home
@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
    gameBoard = new GameBoard();
    battleShipsService.resetCount();
    return "home";
}

    //    http://localhost:8080/battleShips/playGame
@RequestMapping(value = "/playGame", method = RequestMethod.GET)
    public String playGame(){
    gameBoard.setField(battleShipsService.paintShips(gameBoard.getField()));
    return "playGame";
    }



    @RequestMapping(value = "/getMoveCords", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void getMoveCoordinates(@RequestBody ObjectNode cordsResponse) {

    char[][] generatedBoard = gameBoard.getField();
    battleShipsService.makeAMove(generatedBoard, cordsResponse);
    }

    @RequestMapping(value = "/returnMoves", method = RequestMethod.POST)
    @ResponseBody
    public int returnMoves(){
    int moves = battleShipsService.returnMoves();

    return moves;
    }

    @RequestMapping(value = "/sendShips", method = RequestMethod.POST)
    @ResponseBody
    public int returnShips(){
    int ships = battleShipsService.returnShips();
    return ships;
    }

    @RequestMapping(value = "/won", method = RequestMethod.GET)
    public String win(){
        return "win";
    }

    @RequestMapping(value = "/lost", method = RequestMethod.GET)
    public String loose(){
        return "lost";
    }

}
