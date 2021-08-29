package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


public class MenuController {
    public static String serial;
    public static int batcount;
    public static boolean hasParallel = false;
    public static boolean frk = false;
    public static boolean car = false;
    public static int strikes;
    public static boolean snIsEven;
    public static boolean snHasVowel;


    @FXML
    protected void onWiresClick() {
        System.out.println("Simple Wires");
        try {
            KTaNESolver.showSimpleWires();
        }
        catch (IOException e) {
            System.out.println(e);
        }


    }
    @FXML
    protected void onFrkSet() {
        frk = frkbox.isSelected();
    }
    @FXML
    protected void onCarSet() {
        car = carbox.isSelected();
    }
    @FXML
    protected void onParaSet() {
        hasParallel = parabox.isSelected();
    }
    @FXML
    protected void onStrikeButton() {
        strikes++;
        strikelabel.setText("Strike Count: " + strikes);
    }
    @FXML
    protected void onSetInfo() {
        serial = serialfield.getText().toLowerCase();
        batcount = Integer.parseInt(batfield.getText());
        snIsEven = Integer.parseInt(serial.substring(serial.length() - 1)) % 2 == 0;
        snHasVowel = serial.contains("a") && serial.contains("e") && serial.contains("i") && serial.contains("o") && serial.contains("u");
    }

    @FXML
    CheckBox frkbox;
    @FXML
    CheckBox carbox;
    @FXML
    CheckBox parabox;
    @FXML
    TextField serialfield;
    @FXML
    TextField batfield;
    @FXML
    Button strikebutton;
    @FXML
    Label strikelabel;

}