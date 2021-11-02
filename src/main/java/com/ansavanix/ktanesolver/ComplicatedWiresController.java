package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ComplicatedWiresController {
    @FXML
    private void onEnter() {
        String wireStr = input.getText().toLowerCase().trim();
        String instruction;
        switch (wireStr)
        {
            case "bs":
            case "l":
            case "rbsl":
            {
                instruction = "Do not cut the wire";
                break;
            }
            case "":
            case "s":
            case "rs":
            {
                instruction = "Cut the wire";
                break;
            }
            case "b":
            case "r":
            case "rb":
            case "rbl":

            {
                if (MenuController.snIsEven)
                {
                    instruction = "Cut the wire";
                }
                else
                {
                    instruction = "Do not cut the wire";
                }
                break;
            }
            case "bl":
            case "bsl":
            case "rbs":
            {
                if (MenuController.hasParallel)
                {
                    instruction = "Cut the wire";
                }
                else
                {
                    instruction = "Do not cut the wire";
                }
                break;
            }
            case "sl":
            case "rsl":
            case "rl":
            {
                if (MenuController.batCount >= 2)
                {
                    instruction = "Cut the wire";
                }
                else
                {
                    instruction = "Do not cut the wire";
                }
                break;
            }
            default:
            {
                instruction = "Invalid input!";
                break;
            }
        }
        output.setText(instruction);
        input.setText("");
    }
    @FXML
    TextField input;
    @FXML
    Label output;
}
