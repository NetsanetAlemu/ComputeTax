package com.example.computeincometax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ComputeTax extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane root = new GridPane();

        Scene scene = new Scene(root, 400, 400);

        Label lblIncome = new Label("Taxable Income:");
        Label lblStatus = new Label("Select filler status:");

        TextField txtFldIncome = new TextField();

        RadioButton rdBtnSingle = new RadioButton("single filler");
        RadioButton rdBtnMJW = new RadioButton("married jointly or qualified widower");
        RadioButton rdBtnMSep = new RadioButton("married separately");
        RadioButton rdBtnHead = new RadioButton("head of household");

        TextArea txtArTax = new TextArea();

        root.add(lblIncome, 0, 0);
        root.add(txtFldIncome, 0, 1);
        root.add(lblStatus, 0, 2);
        root.add(rdBtnSingle, 0, 3);
        root.add(rdBtnMJW, 0,4);
        root.add(rdBtnMSep, 0, 5);
        root.add(rdBtnHead, 0, 6);
        root.add(txtArTax, 0, 7);

        root.setHgap(20);
        root.setVgap(20);
        root.setPadding(new Insets(10,10,10,10));

        ToggleGroup group = new ToggleGroup();

        rdBtnHead.setToggleGroup(group);
        rdBtnMJW.setToggleGroup(group);
        rdBtnMSep.setToggleGroup(group);
        rdBtnSingle.setToggleGroup(group);

        rdBtnSingle.setOnAction(e -> {
            double income = Double.parseDouble(txtFldIncome.getText());
            double tax = 0;
            if(rdBtnSingle.isSelected()){
                if( income <= 8_350)
                    tax = income * 0.1;
                else if(income <= 33_950)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15;
                else if(income <= 82250)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (income - 33_950) * 0.25;
                else if(income <= 171550)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (82_250 - 33_950) * 0.25 + (income - 82_250) * 0.28;
                else if(income <= 372950)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (82_250 - 33_950) * 0.25 + (171_550 - 82_250) * 0.28 + (income - 372_950) * 0.33;
                else
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (82_250 - 33_950) * 0.25 + (171_550 - 82_250) * 0.28 + (372950 - 171_550) * 0.33 + (income - 372_950) * 0.35;
                txtArTax.setText("Tax = " + Double.toString(tax));
            }

        });

        rdBtnMJW.setOnAction(e -> {
            double income = Double.parseDouble(txtFldIncome.getText());
            double tax = 0;
            if(rdBtnMJW.isSelected()){

                if(income <= 16_700)
                    tax = income * 0.1;
                else if(income <= 67_900)
                    tax = 16_700 * 0.1 + (67_900 - 16_700) * 0.15;
                else if(income <= 137_050)
                    tax = 16_700 * 0.1 + (67_900 - 16_700) * 0.15 + (income - 67_900) * 0.25;
                else if(income <= 208_850)
                    tax = 16_700 * 0.1 + (67_900 - 16_700) * 0.15 + (137_050 - 67_900) * 0.25 + (income - 137_050) * 0.28;
                else if(income <= 372_950)
                    tax = 16_700 * 0.1 + (67_900 - 16_700) * 0.15 + (137_050 - 67_900) * 0.25 + (208_850 - 137_050) * 0.28 + (income - 208_850) * 0.33;
                else
                    tax = 16_700 * 0.1 + (67_900 - 16_700) * 0.15 + (137_050 - 67_900) * 0.25 + (208_850 - 137_050) * 0.28 + (372_950 - 208_850) * 0.33 + (income - 372_950) * 0.35;

                txtArTax.setText("Tax = " + Double.toString(tax));
            }
        });

        rdBtnMSep.setOnAction(e -> {
            double income = Double.parseDouble(txtFldIncome.getText());
            double tax = 0;
            if(rdBtnMSep.isSelected()){
                if(income <= 8_350)
                    tax = income * 0.1;
                else if(income <= 33_950)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15;
                else if(income <= 68_525)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (income - 68_525) * 0.25;
                else if(income <= 104_425)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 + (68_525 - 33_950) * 0.25 + (income - 104_425) * 0.28;
                else if(income <= 186_475)
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 +  (68_525 - 33_950) * 0.25 + (104_425 - 68_525) * 0.28 + (income - 186_475) * 0.33;
                else
                    tax = 8_350 * 0.1 + (33_950 - 8_350) * 0.15 +  (68_525 - 33_950) * 0.25 + (104_425 - 68_525) * 0.28 + (186_475 - 104_425) * 0.33 + (income - 186_475) * 0.35;

                txtArTax.setText("Tax = " + Double.toString(tax));
            }
             });

        rdBtnHead.setOnAction(e -> {
            double income = Double.parseDouble(txtFldIncome.getText());
            double tax = 0;
            if(rdBtnHead.isSelected()){
                if(income <= 11_950)
                    tax = income * 0.1;
                else if(income <= 45_500)
                    tax = 11_950 * 0.1 + (45_500 - 11_950) * 0.15;
                else if(income <= 117_450)
                    tax = 11_950 * 0.1 + (45_500 - 11_950) * 0.15 + (income - 45_500) * 0.25;
                else if(income <= 190_200)
                    tax = 11_950 * 0.1 + (45_500 - 11_950) * 0.15 + (117_450 - 45_500) * 0.25 + (income - 117_450) * 0.28;
                else if(income <= 372_950)
                    tax = 11_950 * 0.1 + (45_500 - 11_950) * 0.15 + (117_450 - 45_500) * 0.25 + (190_200 - 117_450) * 0.28 + (income - 190_200) * 0.33;
                else
                    tax = 11_950 * 0.1 + (45_500 - 11_950) * 0.15 + (117_450 - 45_500) * 0.25 + (190_200 - 117_450) * 0.28 + (372_950 - 190_200) * 0.33 + (income - 372_950) * 0.35;

                txtArTax.setText("Tax = " + Double.toString(tax));
            }
        });


        stage.setTitle("Calculate Tax");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}