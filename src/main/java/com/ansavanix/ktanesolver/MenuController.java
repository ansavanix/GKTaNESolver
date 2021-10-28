package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


public class MenuController {
    public static String serial;
    public static int batCount;
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
    protected void onSimonSaysClick() {
        onModuleClick("simon-says");
    }
    @FXML
    protected void onWhosOnFirstClick() {
        onModuleClick("whos-on-first");
    }
    @FXML
    protected void onMemoryClick() {
        onModuleClick("memory");
    }
    @FXML
    protected void onStrikeButton() {
        strikes++;
        strikeLabel.setText("Strike Count: " + strikes);
    }

    @FXML
    protected void onSetInfo() {
        serial = serialField.getText().toLowerCase();
        batCount = Integer.parseInt(batField.getText());
        snIsEven = Integer.parseInt(serial.substring(serial.length() - 1)) % 2 == 0;
        snHasVowel = serial.contains("a") || serial.contains("e") || serial.contains("i") || serial.contains("o") || serial.contains("u");
        hasParallel = paraBox.isSelected();
        car = carBox.isSelected();
        frk = frkBox.isSelected();
        System.out.println("Info Set!");
        wiresButton.setVisible(true);
    }

    @FXML
    CheckBox frkBox;
    @FXML
    CheckBox carBox;
    @FXML
    CheckBox paraBox;
    @FXML
    TextField serialField;
    @FXML
    TextField batField;
    @FXML
    Button strikeButton;
    @FXML
    Label strikeLabel;
    @FXML
    Button wiresButton;

}