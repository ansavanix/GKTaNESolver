package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class SimpleWiresController {
    @FXML
    ComboBox wireComboBox;
    @FXML
    ComboBox color1;
    @FXML
    ComboBox color2;
    @FXML
    ComboBox color3;
    @FXML
    ComboBox color4;
    @FXML
    ComboBox color5;
    @FXML
    ComboBox color6;
    @FXML
    Label output;
    @FXML
    Button solvebutton;
    private int wireCount;
    private List<String> colors;

    public void getWireCount() {

        wireCount = Integer.parseInt((String) wireComboBox.getValue());
        System.out.println(wireCount);
        showColors();
    }

    public void showColors() {

        switch (wireCount) {
            case 6: {
                color6.setVisible(true);
            }
            case 5: {
                color5.setVisible(true);
            }
            case 4: {
                color4.setVisible(true);
            }
            case 3: {
                color3.setVisible(true);
                color2.setVisible(true);
                color1.setVisible(true);
                solvebutton.setVisible(true);
                break;
            }

        }
        switch (wireCount) {
            case 3: {
                color4.setVisible(false);
            }
            case 4: {
                color5.setVisible(false);
            }
            case 5: {
                color6.setVisible(false);
                break;
            }
        }
    }

    public void getSolution() {
        String toCut = "";
        getColors();
        switch (wireCount) {
            case 3: {
                if (!colors.contains("red")) toCut = "Second";
                else if (colors.get(2).equals("white")) toCut = "Last";
                else if (colors.indexOf("blue") != colors.lastIndexOf("blue")) toCut = "Last Blue";
                else toCut = "Last";
                break;
            }
            case 4: {
                if ((colors.indexOf("red") != colors.lastIndexOf("red")) && !MenuController.snIsEven)
                    toCut = "Last Red";
                else if (colors.get(3).equals("yellow") && !colors.contains("red")) toCut = "First";
                else if (colors.indexOf("blue") == colors.lastIndexOf("blue") && colors.contains("blue"))
                    toCut = "First";
                else if (colors.indexOf("yellow") != colors.lastIndexOf("yellow")) toCut = "Last";
                else toCut = "Second";
                break;
            }
            case 5: {
                if (colors.get(4).equals("black") && !MenuController.snIsEven) toCut = "Fourth";
                else if ((colors.indexOf("yellow") != colors.lastIndexOf("yellow")) && (colors.indexOf("red") == colors.lastIndexOf("red") && colors.contains("red")))
                    toCut = "First";
                else if (!colors.contains("black")) toCut = "Second";
                else toCut = "First";
                break;
            }
            case 6: {
                if (!colors.contains("yellow") && !MenuController.snIsEven) toCut = "Third";
                else if ((colors.indexOf("yellow") == colors.lastIndexOf("yellow") && colors.contains("yellow") && (colors.indexOf("yellow") != colors.lastIndexOf("yellow"))))
                    toCut = "Fourth";
                else if (!colors.contains("red")) toCut = "Last";
                else toCut = "Fourth";
            }
        }
        output.setText("Cut the " + toCut + " wire");

    }

    public void getColors() {
        colors = new ArrayList<String>(wireCount);
        for (int i = 0; i < wireCount; i++) {
            colors.add("");
        }

        switch (wireCount) {
            case 6: {
                colors.set(5, (String) color6.getValue());
            }
            case 5: {
                colors.set(4, (String) color5.getValue());
            }
            case 4: {
                colors.set(3, (String) color4.getValue());
            }
            case 3: {
                colors.set(2, (String) color3.getValue());
                colors.set(1, (String) color2.getValue());
                colors.set(0, (String) color1.getValue());
                break;
            }

        }

    }
}
