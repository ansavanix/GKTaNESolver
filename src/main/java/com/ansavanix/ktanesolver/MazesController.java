package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
    //Array of all mazes
    private final String[][][] mazes = {maze1, maze2, maze3, maze4, maze5, maze6, maze7, maze8, maze9};
    private final String[] toChoose = {"cmark", "whitelight", "redtriangle"};
    int toChooseIndex = 0;
    @FXML
    TextField whiteLight;
    @FXML
    TextField redTriangle;
    @FXML
    TextField cmark;
    @FXML
    Label output;
    @FXML
    Label instructions;
    @FXML
    ImageView zeroZero;
    @FXML
    ImageView zeroOne;
    @FXML
    ImageView zeroTwo;
    @FXML
    ImageView zeroThree;
    @FXML
    ImageView zeroFour;
    @FXML
    ImageView zeroFive;
    @FXML
    ImageView oneZero;
    @FXML
    ImageView oneOne;
    @FXML
    ImageView oneTwo;
    @FXML
    ImageView oneThree;
    @FXML
    ImageView oneFour;
    @FXML
    ImageView oneFive;
    @FXML
    ImageView twoZero;
    @FXML
    ImageView twoOne;
    @FXML
    ImageView twoTwo;
    @FXML
    ImageView twoThree;
    @FXML
    ImageView twoFour;
    @FXML
    ImageView twoFive;
    @FXML
    ImageView threeZero;
    @FXML
    ImageView threeOne;
    @FXML
    ImageView threeTwo;
    @FXML
    ImageView threeThree;
    @FXML
    ImageView threeFour;
    @FXML
    ImageView threeFive;
    @FXML
    ImageView fourZero;
    @FXML
    ImageView fourOne;
    @FXML
    ImageView fourTwo;
    @FXML
    ImageView fourThree;
    @FXML
    ImageView fourFour;
    @FXML
    ImageView fourFive;
    @FXML
    ImageView fiveZero;
    @FXML
    ImageView fiveOne;
    @FXML
    ImageView fiveTwo;
    @FXML
    ImageView fiveThree;
    @FXML
    ImageView fiveFour;
    @FXML
    ImageView fiveFive;
    @FXML
    ImageView cmarkImage;
    @FXML
    ImageView whiteLightImage;
    @FXML
    ImageView redTriangleImage;
    private String cmarkCoord;
    private String redTriangleCoord;
    private String whiteLightCoord;


    private String readableDirections(String directions) {
        String readableDirections = "";
        for (int i = 0; i < directions.length(); i++) {
            String singularDirection = directions.substring(i,i+1);

            switch(singularDirection) {
                case "r":
                    readableDirections += "Right ";
                    break;
                case "l":
                    readableDirections += "Left ";
                    break;
                case "u":
                    readableDirections += "Up ";
                    break;
                case "d":
                    readableDirections += "Down ";
                    break;
            }
        }
        return readableDirections;
    }
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
    //TODO: Fix error when solving maze9. Occurs when going from coordinate 0,0 to coordinate 5,5/
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
        return readableDirections(tempDirections);

    }
    private void coordinateClick(String coordinate) {
        switch(toChooseIndex) {
            case 0:
                instructions.setText("Select the point with the white light.");
                cmarkCoord = coordinate;
                coordinateToImageView(coordinate).setImage(cmarkImage.getImage());
                break;
            case 1:
                instructions.setText("Select the point with the red triangle.");
                whiteLightCoord = coordinate;
                coordinateToImageView(coordinate).setImage(whiteLightImage.getImage());
                break;
            default:
                instructions.setText("Look at the directions below.");
                redTriangleCoord = coordinate;
                coordinateToImageView(coordinate).setImage(redTriangleImage.getImage());
                int startX = Integer.parseInt(whiteLightCoord.substring(0, 1));
                int startY = Integer.parseInt(whiteLightCoord.substring(2, 3));
                int endX = Integer.parseInt(redTriangleCoord.substring(0, 1));
                int endY = Integer.parseInt(redTriangleCoord.substring(2, 3));
                output.setText(solveMaze(identifyMaze(cmarkCoord), startX, startY, endX, endY));
                break;
        }
        toChooseIndex++;
    }
    private ImageView coordinateToImageView(String coordinate) {
        switch(coordinate) {
            case "0,0":
                return zeroZero;
            case "0,1":
                return zeroOne;
            case "0,2":
                return zeroTwo;
            case "0,3":
                return zeroThree;
            case "0,4":
                return zeroFour;
            case "0,5":
                return zeroFive;
            case "1,0":
                return oneZero;
            case "1,1":
                return oneOne;
            case "1,2":
                return oneTwo;
            case "1,3":
                return oneThree;
            case "1,4":
                return oneFour;
            case "1,5":
                return oneFive;
            case "2,0":
                return twoZero;
            case "2,1":
                return twoOne;
            case "2,2":
                return twoTwo;
            case "2,3":
                return twoThree;
            case "2,4":
                return twoFour;
            case "2,5":
                return twoFive;
            case "3,0":
                return threeZero;
            case "3,1":
                return threeOne;
            case "3,2":
                return threeTwo;
            case "3,3":
                return threeThree;
            case "3,4":
                return threeFour;
            case "3,5":
                return threeFive;
            case "4,0":
                return fourZero;
            case "4,1":
                return fourOne;
            case "4,2":
                return fourTwo;
            case "4,3":
                return fourThree;
            case "4,4":
                return fourFour;
            case "4,5":
                return fourFive;
            case "5,0":
                return fiveZero;
            case "5,1":
                return fiveOne;
            case "5,2":
                return fiveTwo;
            case "5,3":
                return fiveThree;
            case "5,4":
                return fiveFour;
            default:
                return fiveFive;
        }
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
    @FXML
    private void clickZeroZero() {
        coordinateClick("0,0");
    }
    @FXML
    private void clickZeroOne() {
        coordinateClick("0,1");
    }
    @FXML
    private void clickZeroTwo() {
        coordinateClick("0,2");
    }
    @FXML
    private void clickZeroThree() {
        coordinateClick("0,3");
    }
    @FXML
    private void clickZeroFour() {
        coordinateClick("0,4");
    }
    @FXML
    private void clickZeroFive() {
        coordinateClick("0,5");
    }
    @FXML
    private void clickOneZero() {
        coordinateClick("1,0");
    }
    @FXML
    private void clickOneOne() {
        coordinateClick("1,1");
    }
    @FXML
    private void clickOneTwo() {
        coordinateClick("1,2");
    }
    @FXML
    private void clickOneThree() {
        coordinateClick("1,3");
    }
    @FXML
    private void clickOneFour() {
        coordinateClick("1,4");
    }
    @FXML
    private void clickOneFive() {
        coordinateClick("1,5");
    }
    @FXML
    private void clickTwoZero() {
        coordinateClick("2,0");
    }
    @FXML
    private void clickTwoOne() {
        coordinateClick("2,1");
    }
    @FXML
    private void clickTwoTwo() {
        coordinateClick("2,2");
    }
    @FXML
    private void clickTwoThree() {
        coordinateClick("2,3");
    }
    @FXML
    private void clickTwoFour() {
        coordinateClick("2,4");
    }
    @FXML
    private void clickTwoFive() {
        coordinateClick("2,5");
    }
    @FXML
    private void clickThreeZero() {
        coordinateClick("3,0");
    }
    @FXML
    private void clickThreeOne() {
        coordinateClick("3,1");
    }
    @FXML
    private void clickThreeTwo() {
        coordinateClick("3,2");
    }
    @FXML
    private void clickThreeThree() {
        coordinateClick("3,3");
    }
    @FXML
    private void clickThreeFour() {
        coordinateClick("3,4");
    }
    @FXML
    private void clickThreeFive() {
        coordinateClick("3,5");
    }
    @FXML
    private void clickFourZero() {
        coordinateClick("4,0");
    }
    @FXML
    private void clickFourOne() {
        coordinateClick("4,1");
    }
    @FXML
    private void clickFourTwo() {
        coordinateClick("4,2");
    }
    @FXML
    private void clickFourThree() {
        coordinateClick("4,3");
    }
    @FXML
    private void clickFourFour() {
        coordinateClick("4,4");
    }
    @FXML
    private void clickFourFive() {
        coordinateClick("4,5");
    }
    @FXML
    private void clickFiveZero() {
        coordinateClick("5,0");
    }
    @FXML
    private void clickFiveOne() {
        coordinateClick("5,1");
    }
    @FXML
    private void clickFiveTwo() {
        coordinateClick("5,2");
    }
    @FXML
    private void clickFiveThree() {
        coordinateClick("5,3");
    }
    @FXML
    private void clickFiveFour() {
        coordinateClick("5,4");
    }
    @FXML
    private void clickFiveFive() {
        coordinateClick("5,5");
    }

}
