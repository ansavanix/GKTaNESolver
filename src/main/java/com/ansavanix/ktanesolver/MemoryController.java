package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class MemoryController {
    int index = 0;
    @FXML
    TextField display;
    @FXML
    TextField get;
    @FXML
    Label output;
    private String[] positions = new String[5];
    private String[] labels = new String[5];

    @FXML
    private void onEnterDisplayValue() {
        int displayValue = Integer.parseInt(display.getText());
        String toPress = "";
        switch (index) {
            //Stage 1
            case 0:
                switch (displayValue) {
                    case 1:
                    case 2:
                        toPress = "Second Position";
                        break;
                    case 3:
                        toPress = "Third Position";
                        break;
                    case 4:
                        toPress = "Fourth Position";
                        break;
                }
                break;
            //Stage 2
            case 1:
                switch (displayValue) {
                    case 1:
                        toPress = "Labeled 4";
                        break;
                    case 2:
                    case 4:
                        toPress = positions[0];
                        break;
                    case 3:
                        toPress = "First Position";
                        break;
                }
                break;
            //Stage 3
            case 2:
                switch (displayValue) {
                    case 1:
                        toPress = labels[1];
                        break;
                    case 2:
                        toPress = labels[0];
                        break;
                    case 3:
                        toPress = "Third Position";
                        break;
                    case 4:
                        toPress = "Labeled 4";
                        break;
                }
                break;
            //Stage 4
            case 3:
                switch (displayValue) {
                    case 1:
                        toPress = positions[0];
                        break;
                    case 2:
                        toPress = "First Position";
                        break;
                    case 3:
                    case 4:
                        toPress = positions[1];
                        break;
                }
                break;
            //Stage 5
            case 4:
                switch (displayValue) {
                    case 1:
                        toPress = labels[0];
                        break;
                    case 2:
                        toPress = labels[1];
                        break;
                    case 3:
                        toPress = labels[3];
                        break;
                    case 4:
                        toPress = labels[2];
                        break;
                }
                break;
        }
        if (toPress.contains("Position")) {
            positions[index] = toPress;
            output.setText("Press the button in the " + toPress + ".\nEnter the label of the button pressed in designated text field.");
            get.setPromptText("LABEL of pressed button.");
        } else {
            labels[index] = toPress;
            output.setText("Press the button " + toPress + ".\nEnter the position of the button pressed in designated text field.");
            get.setPromptText("POSITION of pressed button.");
        }
        if (index >= 4) {
            output.setText("You should be done!");
        }
        display.setText("");
        index++;
    }

    @FXML
    private void onEnterAsk() {
        String promptText = get.getPromptText();
        String inputText = get.getText().toLowerCase();
        if (promptText.contains("POSITION")) {
            if (inputText.contains("1") || inputText.contains("first")) {
                positions[index - 1] = "First Position";
            } else if (inputText.contains("2") || inputText.contains("second")) {
                positions[index - 1] = "Second Position";
            } else if (inputText.contains("3") || inputText.contains("third")) {
                positions[index - 1] = "Third Position";
            } else if (inputText.contains("4") || inputText.contains("fourth") || inputText.contains("last")) {

                positions[index - 1] = "Fourth Position";
            }
        } else {
            if (inputText.contains("1") || inputText.contains("one")) {
                labels[index - 1] = "Labeled 1";
            } else if (inputText.contains("2") || inputText.contains("two")) {
                labels[index - 1] = "Labeled 2";
            } else if (inputText.contains("3") || inputText.contains("three")) {
                labels[index - 1] = "Labeled 3";
            } else {
                labels[index - 1] = "Labeled 4";
            }
        }
        get.setText("");
        get.setPromptText("Enter Display Value Above");
        output.setText("");

    }

}
