package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class WhosOnFirstController {
    final private String[] responses = {"ready", "first", "no", "blank", "nothing", "yes", "what", "uhhh", "left", "right", "middle",
            "okay", "wait", "press", "you", "you are", "you're", "your", "ur", "u", "uh huh", "uh uh", "what", "done", "next",
            "hold", "sure", "like"};
    @FXML
    private void onComplete() {
        System.out.println("complete");
    }
    @FXML
    TextField display;

    @FXML
    TextField response;

    @FXML
    Label why;
}
