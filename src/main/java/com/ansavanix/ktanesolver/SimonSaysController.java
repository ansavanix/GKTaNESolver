package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;


public class SimonSaysController {
    @FXML
    Label output;
    private List<String> responses = new ArrayList<>();

    private void onColorClick(String color) {
        String response = "";
        if (MenuController.snHasVowel) {
            switch (MenuController.strikes) {
                case 0:
                    switch (color) {
                        case "red":
                            response = "blue";
                            break;
                        case "blue":
                            response = "red";
                            break;
                        case "green":
                            response = "yellow";
                            break;
                        case "yellow":
                            response = "green";
                            break;
                    }
                    break;
                case 1:
                    switch (color) {
                        case "red":
                            response = "yellow";
                            break;
                        case "blue":
                            response = "green";
                            break;
                        case "green":
                            response = "blue";
                            break;
                        case "yellow":
                            response = "red";
                            break;
                    }
                    break;

                case 2:
                    switch (color) {
                        case "red":
                            response = "green";
                            break;
                        case "blue":
                            response = "red";
                            break;
                        case "green":
                            response = "yellow";
                            break;
                        case "yellow":
                            response = "blue";
                            break;
                    }
                    break;
            }
        } else {
            switch (MenuController.strikes) {
                case 0:
                    switch (color) {
                        case "red":
                            response = "blue";
                            break;
                        case "blue":
                            response = "yellow";
                            break;
                        case "green":
                            response = "green";
                            break;
                        case "yellow":
                            response = "red";
                            break;
                    }
                    break;
                case 1:
                    switch (color) {
                        case "red":
                            response = "red";
                            break;
                        case "blue":
                            response = "blue";
                            break;
                        case "green":
                            response = "yellow";
                            break;
                        case "yellow":
                            response = "green";
                            break;
                    }
                    break;

                case 2:
                    switch (color) {
                        case "red":
                            response = "yellow";
                            break;
                        case "blue":
                            response = "green";
                            break;
                        case "green":
                            response = "blue";
                            break;
                        case "yellow":
                            response = "red";
                            break;
                    }
                    break;
            }


        }
        responses.add(response);
        String labelString = "";
        for (String val : responses) {
            labelString += val + " ";
        }
        output.setText(labelString);
    }

    @FXML
    private void onRedClick() {
        onColorClick("red");
    }

    @FXML
    private void onBlueClick() {
        onColorClick("blue");
    }

    @FXML
    private void onGreenClick() {
        onColorClick("green");
    }

    @FXML
    private void onYellowClick() {
        onColorClick("yellow");
    }

}
