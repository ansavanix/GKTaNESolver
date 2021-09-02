package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;


public class TheButtonController {
    private String buttonText;
    private String buttonColor;
    private String stripColor;

    @FXML
    protected void getSolution() {
        buttonText = buttonTF.getText().toLowerCase();
        buttonColor = (String) buttonCombo.getValue();
        stripColor = (String) stripCombo.getValue();
        if (buttonText.equals("Abort")) refer();
        else if (MenuController.batcount > 1 && buttonText.equals("detonate")) output.setText("Press and release immediately");
        else if (buttonColor.equals("White") && MenuController.car) refer();
        else if (MenuController.batcount > 2 && MenuController.frk) output.setText("Press and release immediately");
        else if (buttonColor.equals("Yellow")) refer();
        else if (buttonColor.equals("Red") && buttonText.equals("hold")) output.setText("Press and release immediately");
        else refer();
    }
    void refer() {
        String position;
        if (stripColor.equals("Blue")) position = "4";
        else if (stripColor.equals("Yellow")) position = "5";
        else position = "1";
        output.setText("Press and release when the countdown timer has a " + position + " in any position");
    }
    @FXML
    TextField buttonTF;
    @FXML
    ComboBox buttonCombo;
    @FXML
    ComboBox stripCombo;
    @FXML
    Label output;

}
