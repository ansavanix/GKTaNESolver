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
    private final String simpleMaze[][] = {
            {"d","d"},
            {"ur", "ul"}
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
    //TODO: Solve maze based of starting and end coordinates.
    private String solveMaze(String[][] mazeArray, int sX, int sY, int eX,int eY, String dir) {
        if (sX == eX && sY == eY) return dir = "SUCC";
        String directions = dir;
        String options = mazeArray[sX][sY];
        String reverseLastDir;
        if (directions.length() > 0) {
            switch(dir.substring(dir.length()-1)) {
                case "l":
                    reverseLastDir = "r";
                    break;
                case "r":
                    reverseLastDir = "l";
                    break;
                case "u":
                    reverseLastDir = "d";
                    break;
                default:
                    reverseLastDir = "u";
                    break;
            }
            options = options.substring(0, options.indexOf(reverseLastDir)) + options.substring(options.indexOf(reverseLastDir) + 1);
        }
        if (options.length() == 0) return "FIN";
        for (int i = 0; i < options.length(); i++) {
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
