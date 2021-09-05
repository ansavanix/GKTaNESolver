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
    protected void onModuleClick(String module) {
        System.out.println(module);
        try {
            KTaNESolver.showModule(module);

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    @FXML
    protected void onWiresClick() {
        onModuleClick("simple-wires");
    }
    @FXML
    protected void onTheButtonClick() {
        onModuleClick("the-button");
    }
    @FXML
    protected void onKeypadClick() {
        onModuleClick("keypad");
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
        snHasVowel = serial.contains("a") || serial.contains("e") || serial.contains("i") || serial.contains("o") || serial.contains("u");
        hasParallel = parabox.isSelected();
        car = carbox.isSelected();
        frk = frkbox.isSelected();
        System.out.println("Info Set!");
        wiresButton.setVisible(true);
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
    @FXML
    Button wiresButton;

}