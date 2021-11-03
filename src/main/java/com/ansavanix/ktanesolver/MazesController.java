package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MazesController {
    //TODO: Find a way to store maze data in a way to make solving them easy.
    //Perhaps use a 2D array for each maze and for each position store what direction the white light can go from there.
    //From the starting position, create a branch going in every possible direction and tell the user the path of the shortest successful branch.
    //Use a character to represent where the white light can go from each position of the maze.
    //u = can go up.
    //d = can go down.
    //r = can go right.
    //l = can go left.
    private final String maze1[][] = {
            {"rd", "lr", "ld", "rd", "lr", "l"}, //Row 1
            {"ud", "rd", "ul", "ur", "lr", "ld"}, //Row 2
            {"ud", "ur", "ld", "ur", "lr", "udl"}, //Row 3
            {"ud", "r", "ulr", "ul", "r", "udl"}, //Row 4
            {"udl", "lr", "ld", "rd", "l", "ud"}, //Row 5
            {"ur", "l", "ur", "ul", "r", "ul"} //Row 6

    };
    //Array of Circular Mark coordinates to quickly find which maze we are solving.
    private final String mazeCMarks[] = {"1,2 6,3"};



    @FXML
    TextField whiteLight;
    @FXML
    TextField redTriangle;
    @FXML
    TextField cmark1;
    @FXML
    TextField cmark2;
    @FXML
    Label output;
    private String solveMaze(String[][] mazeArray, int startX, int startY, int endX, int endY, String previousMovements) {
        if(startX == endX && startY == endY) {
            return previousMovements;
        }
        String prevMovement = previousMovements;
        String startingMovementOptions = mazeArray[startX][startY];

    }
    @FXML
    private void onEnter() {
        String startingPoint = whiteLight.getText();
        String endPoint = redTriangle.getText();
        int startX = Integer.parseInt(startingPoint.substring(0,1)) - 1;
        int startY = Integer.parseInt(startingPoint.substring(2,3)) - 1;
        int endX = Integer.parseInt(endPoint.substring(0,1)) - 1;
        int endY = Integer.parseInt(endPoint.substring(2,3)) - 1;

    }
}
