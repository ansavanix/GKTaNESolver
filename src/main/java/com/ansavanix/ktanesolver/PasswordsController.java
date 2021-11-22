package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordsController {
    @FXML
    TextField column1;
    @FXML
    TextField column2;
    @FXML
    TextField column3;
    @FXML
    TextField column4;
    @FXML
    TextField column5;
    @FXML
    Label output;
    private String[] passwordsPoss = {"about", "after", "again", "below", "could", "every", "first", "found", "great", "house", "large", "learn", "never", "other", "place", "plant", "point", "right", "small", "sound", "spell", "still", "study", "their", "there", "these", "thing", "think", "three", "water", "where", "which", "world", "would", "write"};

    @FXML
    private void solve() {
        String[] availableArr = new String[5];
        availableArr[0] = column1.getText().trim();
        availableArr[1] = column2.getText().trim();
        availableArr[2] = column3.getText().trim();
        availableArr[3] = column4.getText().trim();
        availableArr[4] = column5.getText().trim();
        boolean solved = false;
        int j = 0;
        while (!solved && j < 35) {
            if (availableArr[0].contains(passwordsPoss[j].substring(0, 1)) && availableArr[1].contains(passwordsPoss[j].substring(1, 2)) && availableArr[2].contains(passwordsPoss[j].substring(2, 3)) && availableArr[3].contains(passwordsPoss[j].substring(3, 4)) && availableArr[4].contains(passwordsPoss[j].substring(4, 5))) {
                output.setText("The password is: " + passwordsPoss[j]);
                solved = true;
            }
            j++;
        }
        if (!solved) {
            output.setText("You have made an error in inputting available characters.");
        }
    }
}
