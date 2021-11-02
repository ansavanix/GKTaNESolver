package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WireSequencesController {
    private int blueCount = 0;
    private int blackCount = 0;
    private int redCount = 0;
    private String toCut;
    private void sequencesCut(String position, String whenCut) {
        if (whenCut.contains(position))
        {
            toCut = "CUT THE WIRE";
        }
        else
        {
            toCut = "DO NOT CUT THE WIRE";
        }
    }
    @FXML
    private void onEnter() {
        String color = colorInput.getText().toLowerCase().trim();
        if (color.equals("red")) {
            color = "r";
        }
        else if (color.equals("blue")) {
            color = "b";
        }
        else if (color.equals("black")) {
            color = "k";
        }
        String pos = posInput.getText().toLowerCase().trim();
        if (color.equals("b"))
        {
            blueCount++;
            switch(blueCount)
            {
                case 1:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 2:
                {
                    sequencesCut(pos,"a or c");
                    break;
                }
                case 3:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 4:
                {
                    sequencesCut(pos,"a");
                    break;
                }
                case 5:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 6:
                {
                    sequencesCut(pos,"b or c");
                    break;
                }
                case 7:
                {
                    sequencesCut(pos,"c");
                    break;
                }
                case 8:
                {
                    sequencesCut(pos,"a or c");
                    break;
                }
                case 9:
                {
                    sequencesCut(pos,"a");
                    break;
                }
            }


        }
        else if (color.equals("r"))
        {
            redCount++;
            switch(redCount)
            {
                case 1:
                {
                    sequencesCut(pos,"c");
                    break;
                }
                case 2:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 3:
                {
                    sequencesCut(pos,"a");
                    break;
                }
                case 4:
                {
                    sequencesCut(pos,"a or c");
                    break;
                }
                case 5:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 6:
                {
                    sequencesCut(pos,"a or c");
                    break;
                }
                case 7:
                {
                    sequencesCut(pos,"a b or c");
                    break;
                }
                case 8:
                {
                    sequencesCut(pos,"a or b");
                    break;
                }
                case 9:
                {
                    sequencesCut(pos,"b");
                    break;
                }
            }
        }
        else if (color.equals("k"))
        {
            blackCount++;
            switch(blackCount)
            {
                case 1:
                {
                    sequencesCut(pos,"a b or c");
                    break;
                }
                case 2:
                {
                    sequencesCut(pos,"a or c");
                    break;
                }
                case 3:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 4:
                {
                    sequencesCut(pos,"a or c");
                    break;
                }
                case 5:
                {
                    sequencesCut(pos,"b");
                    break;
                }
                case 6:
                {
                    sequencesCut(pos,"b or c");
                    break;
                }
                case 7:
                {
                    sequencesCut(pos,"a or b");
                    break;
                }
                case 8:
                {
                    sequencesCut(pos,"c");
                    break;
                }
                case 9:
                {
                    sequencesCut(pos,"c");
                    break;
                }
            }
        }
        output.setText(toCut);
        colorInput.setText("");
        posInput.setText("");


}
    @FXML
    TextField colorInput;
    @FXML
    TextField posInput;
    @FXML
    Label output;

}
