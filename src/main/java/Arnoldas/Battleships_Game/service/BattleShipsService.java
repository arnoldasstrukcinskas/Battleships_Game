package Arnoldas.Battleships_Game.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BattleShipsService {

    Random random = new Random();
    boolean spaceFree = false;

    public void paintShips() {
        char[][] field = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

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
        // Printing the modified field directly from the service
        for (int p = 0; p < field.length; p++) {
            for (int l = 0; l < field[p].length; l++) {
                System.out.print(field[p][l] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}