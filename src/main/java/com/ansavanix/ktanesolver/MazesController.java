package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MazesController {
    //w represents a wall.
    //p represents a point on the maze.
    //f represents absence of a wall
    private String maze1[] = {
            "wwwwww",
            "pfpfpwpfpfp",
            "fwffww",

    }
    @FXML
    private void onEnter() {

    }
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
}
