package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class MorseCodeController {
    final private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //A short flash is represented by a period. (".")
    //A long flash is represented by a dash. ("-")
    final private String[] inMorseCode = {
            ".-", //A
            "-...", //B
            "-.-.", //C
            "-..", //D
            ".", //E
            "..-.", //F
            "--.", //G
            "....", //H
            "..", //I
            ".---", //J
            "-.-", //K
            ".-..", //L
            "--", //M
            "-.", //N
            "---", //O
            ".--.", //P
            "--.-", //Q
            ".-.", //R
            "...", //S
            "-", //T
            "..-", //U
            "...-", //V
            ".--", //W
            "-..-", //X
            "-.--", //Y
            "--.." //Z
    };
    @FXML
    TextField input;
    @FXML
    Label output;

    @FXML
    private void onEnter() {
        String humanForm = "";
        String morseForm = input.getText().trim() + " ";
        while (morseForm.contains(" ")) {
            int end = morseForm.indexOf(" ");
            String morseCharacter = morseForm.substring(0, end);
            int index = Arrays.asList(inMorseCode).indexOf(morseCharacter);
            humanForm += characters.substring(index, index + 1);
            morseForm = morseForm.substring(end + 1);
        }
        output.setText(humanForm);

    }
}
