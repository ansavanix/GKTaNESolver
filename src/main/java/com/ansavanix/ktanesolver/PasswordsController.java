package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordsController {
    private String passwordsPoss[] = {"about","after","again","below","could","every","first","found","great","house","large","learn","never","other","place","plant","point","right","small","sound", "spell", "still","study","their","there","these","thing","think", "three", "water", "where", "which", "world", "would", "write"};
    @FXML
    private void solve() {
        String available = input.getText().trim() + " ";
        String availableArr[] = new String[5];
        int i = 0;
        while (available.contains(" ")) {
            int end = available.indexOf(" ");
            availableArr[i] = available.substring(0,end);
            available = available.substring(end + 1);
            i++;
        }
        boolean solved = false;
        int j = 0;
        while (!solved && j < 35) {
            if (availableArr[0].contains(passwordsPoss[j].substring(0,1)) && availableArr[1].contains(passwordsPoss[j].substring(1,2)) && availableArr[2].contains(passwordsPoss[j].substring(2,3)) && availableArr[3].contains(passwordsPoss[j].substring(3,4)) && availableArr[4].contains(passwordsPoss[j].substring(4,5))) {
                output.setText("The password is: " + passwordsPoss[j]);
                solved = true;
            }
            j++;
        }
        if (!solved) {
            output.setText("You have made an error in inputting available characters.");
        }
    }

    @FXML
    TextField input;
    @FXML
    Label output;
}
