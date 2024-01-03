package Arnoldas.Battleships_Game.service;

import Arnoldas.Battleships_Game.repository.model.GameBoard;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class BattleShipsService {

    @Autowired
    GameBoard gameBoard;
    Random random = new Random();
    boolean spaceFree = false;
    int count = 0;

    public char[][] paintShips(char[][] field) {

        boolean isHorizontal = random.nextBoolean();

        //start position
        int row = random.nextInt(5); //imu 5 nes nesvarbi laivo kryptis ir nereiketu tikrinti lentos dydzio
        int column = random.nextInt(5); //imu 5 nes nesvarbi laivo kryptis ir nereiketu tikrinti lentos dydzio

        //Piesiu 5 langeliu laiva
        if (isHorizontal) {
            for (int i = row; i < row + 5; i++) {
                field[i][column] = '0';
            }
        } else {
            for (int i = column; i < column + 5; i++) {
                field[row][i] = '0';
            }
        }

        //Piesiu 4 langeliu laiva
        isHorizontal = random.nextBoolean();
        row = random.nextInt(6);
        column = random.nextInt(6);

        if (isHorizontal) {
            spaceFree = false;
            while (!spaceFree) {
                row = random.nextInt(6);
                column = random.nextInt(6);

                for (int i = column; i < column + 4; i++) {
                    if (field[row][i] == '0') {
                        spaceFree = false;
                        break;
                    } else if (row + 1 < field.length && field[row + 1][i] == '0') {
                        spaceFree = false;
                        break;
                    } else if (row - 1 >= 0 && field[row - 1][i] == '0') {
                        spaceFree = false;
                        break;
                    } else if (i + 1 < field[0].length && field[row][i + 1] == '0') {
                        spaceFree = false;
                        break;
                    } else if (i - 1 >= 0 && field[row][i - 1] == '0') {
                        spaceFree = false;
                        break;
                    } else {
                        spaceFree = true;
                    }
                }
            }

            for (int i = column; i < column + 4; i++) {
                field[row][i] = '0';
            }
        } else {
            spaceFree = false;
            while(!spaceFree){
                row = random.nextInt(6);
                column = random.nextInt(6);
                for (int i = row; i < row + 4; i++) {
                    if (field[i][column] == '0') {
                        spaceFree = false;
                        break;
                    } else if (column + 1 < field[0].length && field[i][column + 1] == '0') {
                        spaceFree = false;
                        break;
                    } else if (column - 1 >= 0 && field[i][column - 1] == '0') {
                        spaceFree = false;
                        break;
                    } else if (i + 1 < field.length && field[i + 1][column] == '0') {
                        spaceFree = false;
                        break;
                    } else if (i - 1 >= 0 && field[i - 1][column] == '0') {
                        spaceFree = false;
                        break;
                    } else {
                        spaceFree = true;
                    }
                }
            }

            for (int i = row; i < row + 4; i++) {
                field[i][column] = '0';
            }
        }

//        //piesiu 2 laivus po 3 langelius
        isHorizontal = random.nextBoolean();
        row = random.nextInt(7);
        column = random.nextInt(7);

        for(int threeStarShip = 0; threeStarShip < 2; threeStarShip++) {
            if (isHorizontal) {
                spaceFree = false;
                while (!spaceFree) {
                    row = random.nextInt(7);
                    column = random.nextInt(7);

                    for (int i = column; i < column + 3; i++) {
                        if (field[row][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (row + 1 < field.length && field[row + 1][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (row - 1 >= 0 && field[row - 1][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i + 1 < field[0].length && field[row][i + 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i - 1 >= 0 && field[row][i - 1] == '0') {
                            spaceFree = false;
                            break;
                        } else {
                            spaceFree = true;
                        }
                    }
                }

                for (int i = column; i < column + 3; i++) {
                    field[row][i] = '0';
                }
            } else {
                spaceFree = false;
                while (!spaceFree) {
                    row = random.nextInt(7);
                    column = random.nextInt(7);
                    for (int i = row; i < row + 3; i++) {
                        if (field[i][column] == '0') {
                            spaceFree = false;
                            break;
                        } else if (column + 1 < field[0].length && field[i][column + 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (column - 1 >= 0 && field[i][column - 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i + 1 < field.length && field[i + 1][column] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i - 1 >= 0 && field[i - 1][column] == '0') {
                            spaceFree = false;
                            break;
                        } else {
                            spaceFree = true;
                        }
                    }
                }

                for (int i = row; i < row + 3; i++) {
                    field[i][column] = '0';
                }
            }
        }

//        //piesiu 3 laivus po 2 langelius
        isHorizontal = random.nextBoolean();
        row = random.nextInt(8);
        column = random.nextInt(8);

        for(int twoStarShip = 0; twoStarShip < 3; twoStarShip++) {
            if (isHorizontal) {
                spaceFree = false;
                while (!spaceFree) {
                    row = random.nextInt(8);
                    column = random.nextInt(8);

                    for (int i = column; i < column + 2; i++) {
                        if (field[row][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (row + 1 < field.length && field[row + 1][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (row - 1 >= 0 && field[row - 1][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i + 1 < field[0].length && field[row][i + 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i - 1 >= 0 && field[row][i - 1] == '0') {
                            spaceFree = false;
                            break;
                        } else {
                            spaceFree = true;
                        }
                    }
                }

                for (int i = column; i < column + 2; i++) {
                    field[row][i] = '0';
                }
            } else {
                spaceFree = false;
                while (!spaceFree) {
                    row = random.nextInt(8);
                    column = random.nextInt(8);
                    for (int i = row; i < row + 2; i++) {
                        if (field[i][column] == '0') {
                            spaceFree = false;
                            break;
                        } else if (column + 1 < field[0].length && field[i][column + 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (column - 1 >= 0 && field[i][column - 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i + 1 < field.length && field[i + 1][column] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i - 1 >= 0 && field[i - 1][column] == '0') {
                            spaceFree = false;
                            break;
                        } else {
                            spaceFree = true;
                        }
                    }
                }

                for (int i = row; i < row + 2; i++) {
                    field[i][column] = '0';
                }
            }
        }

//      piesiu 4 laivus po 1 langeli
        isHorizontal = random.nextBoolean();
        row = random.nextInt(8);
        column = random.nextInt(8);

        for(int oneStarShip = 0; oneStarShip < 3; oneStarShip++) {
            if (isHorizontal) {
                spaceFree = false;
                while (!spaceFree) {
                    row = random.nextInt(9);
                    column = random.nextInt(9);

                    for (int i = column; i < column + 1; i++) {
                        if (field[row][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (row + 1 < field.length && field[row + 1][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (row - 1 >= 0 && field[row - 1][i] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i + 1 < field[0].length && field[row][i + 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i - 1 >= 0 && field[row][i - 1] == '0') {
                            spaceFree = false;
                            break;
                        } else {
                            spaceFree = true;
                        }
                    }
                }

                for (int i = column; i < column + 1; i++) {
                    field[row][i] = '0';
                }
            } else {
                spaceFree = false;
                while (!spaceFree) {
                    row = random.nextInt(9);
                    column = random.nextInt(9);
                    for (int i = row; i < row + 1; i++) {
                        if (field[i][column] == '0') {
                            spaceFree = false;
                            break;
                        } else if (column + 1 < field[0].length && field[i][column + 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (column - 1 >= 0 && field[i][column - 1] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i + 1 < field.length && field[i + 1][column] == '0') {
                            spaceFree = false;
                            break;
                        } else if (i - 1 >= 0 && field[i - 1][column] == '0') {
                            spaceFree = false;
                            break;
                        } else {
                            spaceFree = true;
                        }
                    }
                }

                for (int i = row; i < row + 1; i++) {
                    field[i][column] = '0';
                }
            }
        }
        return field;
//      Šią dalį užkomentuoju, kad prireikus būtų galima matyti sugeneruotą žaidimo lenta.
//        for (int p = 0; p < field.length; p++) {
//            for (int l = 0; l < field[p].length; l++) {
//                System.out.print(field[p][l] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------------");
    }

    public void makeAMove(char[][] field, JsonNode jsonResponse) {
        int row = extractRow(jsonResponse);
        int column = extractColumn(jsonResponse);
        int shipsRemaining = gameProgress(field);


        if (field != null && field[row][column] == '0') {
            field[row][column] = '1';
            gameBoard.setField(field);
            count++;
            shipsRemaining--;
            gameBoard.setShipsRemaining(shipsRemaining);
        } else if (field != null && field[row][column] == '.') {
            field[row][column] = 'x';
            gameBoard.setField(field);
            count++;
        }
        gameBoard.setMoves(count);
    }

    public int gameProgress(char[][] field){
        int shipsRemaining = 0;

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == '0') {
                        shipsRemaining++;
                    }
                }
            }
            gameBoard.setShipsRemaining(shipsRemaining);
        return shipsRemaining;
    }

    public int returnMoves(){
        return gameBoard.getMoves();
    }
    public int returnShips(){
        return gameBoard.getShipsRemaining();
    }
    public int extractRow(JsonNode jsonResponse){
    JsonNode rowConvert = jsonResponse.at("/row");

    int row = rowConvert.asInt();
        return row;
    }
    public int extractColumn(JsonNode jsonResponse){
        JsonNode columnConvert = jsonResponse.at("/column");
        int column = columnConvert.asInt();
        return column;
    }

    public void resetCount() {
        count = 0;
    }

}