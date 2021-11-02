package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MazesController {
    //TODO: Find a way to store maze data in a way to make solving them easy.
    //Perhaps use a 2D array for each maze and for each position store what direction the white light can go from there.
    //From the starting position, create a branch going in every possible direction and tell the user the path of the shortest successful branch.
    //u = can go up.
    //d = can go down.
    //r = can go right.
    //l = can go left.


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

    @FXML
    private void onEnter() {

    }
}
