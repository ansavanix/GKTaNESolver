package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MazesController {
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
    private String globalDirections = "";


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
    //TODO: Solve maze based of starting and end coordinates.
    private String solveMaze(String[][] mazeArray, int sX, int sY, int eX,int eY) {
        String directions = "";
        String options = mazeArray[sX][sY];
        boolean solved = false;
        //Branch off from each of the initial options.
        for(int i = 0; i < options.length(); i++) {
            String opt = options.substring(i,i+1);

        }


        return directions;
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
