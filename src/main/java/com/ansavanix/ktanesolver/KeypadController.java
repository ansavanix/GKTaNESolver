package com.ansavanix.ktanesolver;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class KeypadController {
    final private String[][] cols = {
            {"q","at","lambda","squiggly","squidKnife","hook","leftC"}, //Column 1
            {"euro","q","leftC","cursive","hollowStar","hook","questionMark"}, //Column 2
            {"copyright","pumpkin","cursive","doubleK", "meltedThree", "lambda", "hollowStar"}, //Column 3
            {"six","paragraph","bt","squidKnife","doubleK","questionMark","smileyFace"}, //Column 4
            {"trident","smileyFace","bt","rightC","paragraph","dragon","filledStar"}, //Column 5
            {"six","euro","puzzle","ae","trident","hWithHat","omega"} //Column 6
    };
    private int selectedCount = 0;
    private String[] selected = new String[4];

    private void onImageClick(String imageName) {
        ArrayList<String> possible = new ArrayList<>();
        selected[selectedCount] = imageName;
        selectedCount++;
        for (String[] col : cols) {
            boolean matches = true;
            for (int i = 0; i < selectedCount; i++) {
                if (!Arrays.asList(col).contains(selected[i])) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                Collections.addAll(possible, col);
            }
        }
        if (selectedCount == 1) {
            order1.setImage(stringToImage(selected[0]));
        }
        else {
            setOrder(possible);
        }

        hideAllNot(possible);
    }
    private void setOrder(ArrayList<String> order) {
        int[] indexes = new int[selectedCount];
        for (int i = 0; i < selectedCount; i++) {
            indexes[i] = order.indexOf(selected[i]);
        }
        String[] selectedInOrder = new String[selectedCount];
        int lowestIndexValue;
        int lowestIndex;
        for (int i = 0; i < selectedCount; i++) {
            lowestIndexValue = 7;
            lowestIndex = -1;
            for (int j = 0; j < selectedCount; j++) {
                if (indexes[j] < lowestIndexValue && indexes[j] != -1) {
                    lowestIndexValue = indexes[j];
                    lowestIndex = j;
                }
            }
            selectedInOrder[i] = selected[lowestIndex];
            indexes[lowestIndex] = -1;
            }
        switch(selectedCount) {
            case 4: {
                order4.setImage(stringToImage(selectedInOrder[3]));
            }
            case 3: {
                order3.setImage(stringToImage(selectedInOrder[2]));
            }
            case 2: {
                order2.setImage(stringToImage(selectedInOrder[1]));
                order1.setImage(stringToImage(selectedInOrder[0]));
            }
        }


    }
    private Image stringToImage(String imageName) {
        switch(imageName) {
            case "ae":
                return ae.getImage();
            case "at":
                return at.getImage();
            case "bt":
                return bt.getImage();
            case "copyright":
                return copyright.getImage();
            case "cursive":
                return cursive.getImage();
            case "doubleK":
                return doubleK.getImage();
            case "dragon":
                return dragon.getImage();
            case "euro":
                return euro.getImage();
            case "filledStar":
                return filledStar.getImage();
            case "hollowStar":
                return hollowStar.getImage();
            case "hook":
                return hook.getImage();
            case "hWithHat":
                return hWithHat.getImage();
            case "leftC":
                return leftC.getImage();
            case "meltedThree":
                return meltedThree.getImage();
            case "omega":
                return omega.getImage();
            case "paragraph":
                return paragraph.getImage();
            case "pumpkin":
                return pumpkin.getImage();
            case "puzzle":
                return puzzle.getImage();
            case "q":
                return q.getImage();
            case "questionMark":
                return questionMark.getImage();
            case "rightC":
                return rightC.getImage();
            case "six":
                return six.getImage();
            case "smileyFace":
                return smileyFace.getImage();
            case "squidKnife":
                return squidKnife.getImage();
            case "squiggly":
                return squiggly.getImage();
            case "trident":
                return trident.getImage();
        }
        return lambda.getImage();
    }
    @FXML
    private void onAeClick() {
        onImageClick("ae");
    }
    @FXML
    private void onAtClick() {
        onImageClick("at");
    }
    @FXML
    private void onBtClick() {
        onImageClick("bt");
    }
    @FXML
    private void onCopyrightClick() {
        onImageClick("copyright");
    }
    @FXML
    private void onCursiveClick() {
        onImageClick("cursive");
    }
    @FXML
    private void onDoubleKClick() {
        onImageClick("doubleK");
    }
    @FXML
    private void onDragonClick() {
        onImageClick("dragon");
    }
    @FXML
    private void onEuroClick() {
        onImageClick("euro");
    }
    @FXML
    private void onFilledStarClick() {
        onImageClick("filledStar");
    }
    @FXML
    private void onHollowStarClick() {
        onImageClick("hollowStar");
    }
    @FXML
    private void onHookClick() {
        onImageClick("hook");
    }
    @FXML
    private void onHWithHatClick() {
        onImageClick("hWithHat");
    }
    @FXML
    private void onLeftCClick() {
        onImageClick("leftC");
    }
    @FXML
    private void onMeltedThreeClick() {
        onImageClick("meltedThree");
    }
    @FXML
    private void onOmegaClick() {
        onImageClick("omega");
    }
    @FXML
    private void onParagraphClick() {
        onImageClick("paragraph");
    }
    @FXML
    private void onPumpkinClick() {
        onImageClick("pumpkin");
    }
    @FXML
    private void onPuzzleClick() {
        onImageClick("puzzle");
    }
    @FXML
    private void onQClick() {
        onImageClick("q");
    }
    @FXML
    private void onQuestionMarkClick() {
        onImageClick("questionMark");
    }
    @FXML
    private void onRightCClick() {
        onImageClick("rightC");
    }
    @FXML
    private void onSixClick() {
        onImageClick("six");
    }
    @FXML
    private void onSmileyFaceClick() {
        onImageClick("smileyFace");
    }
    @FXML
    private void onSquidKnifeClick() {
        onImageClick("squidKnife");
    }
    @FXML
    private void onSquigglyClick() {
        onImageClick("squiggly");
    }
    @FXML
    private void onTridentClick() {
        onImageClick("trident");
    }
    @FXML
    private void onLambdaClick() {
        onImageClick("lambda");
    }
    private void hideAllNot(ArrayList<String> not) {
        if  (!not.contains("ae")) ae.setVisible(false);
        if  (!not.contains("at")) at.setVisible(false);
        if  (!not.contains("bt")) bt.setVisible(false);
        if  (!not.contains("copyright")) copyright.setVisible(false);
        if  (!not.contains("cursive")) cursive.setVisible(false);
        if  (!not.contains("doubleK")) doubleK.setVisible(false);
        if  (!not.contains("dragon")) dragon.setVisible(false);
        if  (!not.contains("euro")) euro.setVisible(false);
        if  (!not.contains("filledStar")) filledStar.setVisible(false);
        if  (!not.contains("hollowStar")) hollowStar.setVisible(false);
        if  (!not.contains("hook")) hook.setVisible(false);
        if  (!not.contains("hWithHat")) hWithHat.setVisible(false);
        if  (!not.contains("leftC")) leftC.setVisible(false);
        if  (!not.contains("meltedThree")) meltedThree.setVisible(false);
        if  (!not.contains("omega")) omega.setVisible(false);
        if  (!not.contains("paragraph")) paragraph.setVisible(false);
        if  (!not.contains("pumpkin")) pumpkin.setVisible(false);
        if  (!not.contains("puzzle")) puzzle.setVisible(false);
        if  (!not.contains("q")) q.setVisible(false);
        if  (!not.contains("questionMark")) questionMark.setVisible(false);
        if  (!not.contains("rightC")) rightC.setVisible(false);
        if  (!not.contains("six")) six.setVisible(false);
        if  (!not.contains("smileyFace")) smileyFace.setVisible(false);
        if  (!not.contains("squidKnife")) squidKnife.setVisible(false);
        if  (!not.contains("squiggly")) squiggly.setVisible(false);
        if  (!not.contains("trident")) trident.setVisible(false);
        if  (!not.contains("lambda")) lambda.setVisible(false);


    }

    @FXML
    ImageView ae;
    @FXML
    ImageView at;
    @FXML
    ImageView bt;
    @FXML
    ImageView copyright;
    @FXML
    ImageView cursive;
    @FXML
    ImageView doubleK;
    @FXML
    ImageView dragon;
    @FXML
    ImageView euro;
    @FXML
    ImageView filledStar;
    @FXML
    ImageView hollowStar;
    @FXML
    ImageView hook;
    @FXML
    ImageView hWithHat;
    @FXML
    ImageView leftC;
    @FXML
    ImageView meltedThree;
    @FXML
    ImageView omega;
    @FXML
    ImageView paragraph;
    @FXML
    ImageView pumpkin;
    @FXML
    ImageView puzzle;
    @FXML
    ImageView q;
    @FXML
    ImageView questionMark;
    @FXML
    ImageView rightC;
    @FXML
    ImageView six;
    @FXML
    ImageView smileyFace;
    @FXML
    ImageView squidKnife;
    @FXML
    ImageView squiggly;
    @FXML
    ImageView trident;
    @FXML
    ImageView lambda;
    @FXML
    ImageView order1;
    @FXML
    ImageView order2;
    @FXML
    ImageView order3;
    @FXML
    ImageView order4;

}
