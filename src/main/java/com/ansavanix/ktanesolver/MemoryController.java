package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MemoryController {
    private String[] positions = new String[5];
    private String[] values = new String[5];
    int index = 0;
    @FXML
    private void onComplete(){
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
                        toPress = "Fourth position";

                        break;
                }
                break;
            //Stage 2
            case 1:

                break;
            //Stage 3
            case 2:

                break;
            //Stage 4
            case 3:

                break;
            //Stage 5
            case 4:

                break;


        }
    }
    @FXML
    TextField display;

}
