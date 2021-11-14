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
    //Mazes listed starting from the top left.
    private final String[][] maze1 = {
            {"rd", "lr", "ld", "rd", "lr", "l"},
            {"ud", "rd", "ul", "ur", "lr", "ld"},
            {"ud", "ur", "ld", "ur", "lr", "udl"},
            {"ud", "r", "ulr", "ul", "r", "udl"},
            {"udl", "lr", "ld", "rd", "l", "ud"},
            {"ur", "l", "ur", "ul", "r", "ul"}
    };
    private final String[][] maze2 = {
            {"r", "lrd", "l", "rd", "lrd", "l"},
            {"rd", "ul", "rd", "ul", "ur", "ld"},
            {"ud", "rd", "ul", "rd", "lr", "uld"},
            {"urd", "ul", "rd", "ul", "d", "ud"},
            {"ud", "d", "ud", "rd", "ul", "ud"},
            {"u", "ur", "ul", "ur", "lr", "lu"}
    };
    private final String[][] maze3 = {
            {"dr", "lr", "ld", "d", "dr", "dl"},
            {"u", "d", "ud", "ur", "lu", "ud"},
            {"dr", "uld", "ud", "rd", "ld", "ud"},
            {"ud", "ud", "ud", "ud", "ud", "ud"},
            {"ud", "ur", "ul", "ud", "ud", "ud"},
            {"ur", "lr", "lr", "ul", "ur", "ul"}
    };
    private final String[][] maze4 = {
            {"rd", "ld", "r", "lr", "lr", "ld"},
            {"ud", "ud", "dr", "lr", "lr", "uld"},
            {"ud", "ur", "lu", "rd", "l", "ud"},
            {"ud", "r", "lr", "lru", "lr", "lud"},
            {"udr", "lr", "lr", "lr", "ld", "ud"},
            {"ur", "lr", "l", "r", "ul", "u"}
    };
    private final String[][] maze5 = {
            {"r", "lr", "lr", "lr", "lrd", "ld"},
            {"rd", "lr", "lr", "lrd", "lu", "u"},
            {"udr", "ld", "r", "ul", "rd", "ld"},
            {"ud", "ur", "lr", "ld", "u", "ud"},
            {"ud", "rd", "lr", "ulr", "l", "ud"},
            {"u", "ur", "lr", "lr", "lr", "lu"}
    };
    private final String[][] maze6 = {
            {"d", "dr", "ld", "r", "ldr", "ld"},
            {"ud", "ud", "ud", "rd", "ul", "ud"},
            {"udr", "ul", "u", "ud", "rd", "ul"},
            {"ur", "ld", "dr", "udl", "ud", "d"},
            {"rd", "ul", "u", "ud", "ur", "uld"},
            {"ur", "lr", "lr", "ul", "r", "ul"}
    };
    private final String[][] maze7 = {
            {"dr", "lr", "lr", "ld", "dr", "ld"},
            {"ud", "rd", "l", "ur", "lu", "ud"},
            {"ur", "ul", "rd", "l", "rd", "ul"},
            {"dr", "ld", "udr", "lr", "ul", "d"},
            {"ud", "u", "ur", "lr", "ld", "ud"},
            {"ur", "lr", "lr", "lr", "ulr", "ul"}
    };
    private final String[][] maze8 = {
            {"d", "dr", "lr", "ld", "dr", "ld"},
            {"udr", "ulr", "l", "ur", "ul", "ud"},
            {"ud", "dr", "lr", "lr", "ld", "ud"},
            {"ud", "ur", "ld", "r", "ulr", "ul"},
            {"ud", "d", "ur", "lr", "lr", "l"},
            {"ur", "ulr", "lr", "lr", "lr", "l"}
    };
    private final String[][] maze9 = {
            {"d", "dr", "lr", "lr", "ldr", "ld"},
            {"ud", "ud", "rd", "l", "ud", "ud"},
            {"udr", "ulr", "ul", "rd", "ul", "ud"},
            {"ud", "d", "dr", "ul", "r", "uld"},
            {"ud", "ud", "ud", "dr", "dl", "u"},
            {"ur", "ul", "ur", "ul", "ur", "l"}
    };

    //Array of Circular Mark coordinates to quickly find which maze we are solving.
    private final String[] mazeCMarks = {"0,1 5,2", "4,1 1,3", "3,3 5,3", "0,0 0,3", "4,2 3,5", "4,0 2,4", "1,0 1,5", "3,0 2,3", "1,2 0,4"};


    @FXML
    TextField whiteLight;
    @FXML
    TextField redTriangle;
    @FXML
    TextField cmark;
    @FXML
    Label output;

    private String opposite(String direction) {
        switch (direction) {
            case "u":
                return "d";
            case "d":
                return "u";
            case "l":
                return "r";
            default:
                return "l";
        }
    }

    private String[][] identifyMaze(String identifier) {
        String[][][] mazes = {maze1, maze2, maze3, maze4, maze5, maze6, maze7, maze8, maze9};
        int mazeIndex = 0;
        for (int i = 0; i < mazeCMarks.length; i++) {
            if (mazeCMarks[i].contains(identifier)) {
                mazeIndex = i;
                break;
            }
        }
        return (mazes[mazeIndex]);
    }

    /*
    A maze is simple when you only have the option to go in one direction. However, most mazes have several points where
    there are multiple directions you can go in. These points of the maze are critical to know as they are points where
    you cannot go through all directions available at the same time.
     */
    private String solveMaze(String[][] mazeArray, int sX, int sY, int eX, int eY) {
        String tempDirections = "";
        int[] checkpointX = new int[36];
        int[] checkpointY = new int[36];
        String[] checkpointOptions = new String[36];
        int checkpoints = 0;
        String[] checkpointDirections = new String[36];

        while (!(sX == eX && sY == eY)) {
            //Create a string containing the directions available.
            String options = mazeArray[sY][sX];
            //Remove the direction that would take us back to a position we were already in. (Remove the opposite direction of the last direction taken.)
            if (tempDirections.length() > 0) {
                String reverse = opposite(tempDirections.substring(tempDirections.length() - 1));
                int toRemove = options.indexOf(reverse);
                options = options.substring(0, toRemove) + options.substring(toRemove + 1);
            }
            //Check if we are at a dead end/ have 0 options available to us. If so, revert to a previous checkpoint.
            //Go back 1 in the checkpoint counter to remove it from the list. This forces the checkpoint only to be readded if it still is a checkpoint.
            if (options.length() == 0) {
                int toRevert = checkpoints - 1;
                sX = checkpointX[toRevert];
                sY = checkpointY[toRevert];
                options = checkpointOptions[toRevert];
                tempDirections = checkpointDirections[toRevert];
                checkpoints--;
            }
            String move;
            //If we have multiple directions available to us in options, mark the coordinate as a critical point/ checkpoint.
            //Remove the direction we are currently adding.
            if (options.length() > 1) {
                move = options.substring(0, 1);
                checkpointX[checkpoints] = sX;
                checkpointY[checkpoints] = sY;
                checkpointOptions[checkpoints] = options.substring(1);
                checkpointDirections[checkpoints] = tempDirections;
                checkpoints++;
            } else {
                //Precondition: there is only one direction available to us in options.
                move = options;
            }
            //Modify coordinates based on move;
            switch (move) {
                case "u":
                    sY -= 1;
                    break;
                case "d":
                    sY += 1;
                    break;
                case "r":
                    sX += 1;
                    break;
                default:
                    sX -= 1;
                    break;
            }
            tempDirections += move;


        }
        return tempDirections;

    }


    @FXML
    private void onEnter() {

        String startingPoint = whiteLight.getText();
        String endPoint = redTriangle.getText();
        String identifier = cmark.getText();
        int startX = Integer.parseInt(startingPoint.substring(0, 1));
        int startY = Integer.parseInt(startingPoint.substring(2, 3));
        int endX = Integer.parseInt(endPoint.substring(0, 1));
        int endY = Integer.parseInt(endPoint.substring(2, 3));
        output.setText(solveMaze(identifyMaze(identifier), startX, startY, endX, endY));


    }
}
