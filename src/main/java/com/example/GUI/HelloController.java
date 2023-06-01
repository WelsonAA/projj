package com.example.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button showbalance;
    @FXML
    private Button transaction;
    @FXML
    private Button bills;
    @FXML
    private Button purchaseitem;
    @FXML
    private Button notifications;
    @FXML
    private Button bankstatement;
    @FXML
    private Button logout;
    @FXML
    private Button homebalance;
    @FXML
    private Button hometransaction;
    @FXML
    private Button withdraw;
    @FXML
    private Button transfer;
    @FXML
    private Button deposit;
    @FXML
    private Button login;
    @FXML
    private Label loginmessage;
    @FXML
    private TextField passwd;
    @FXML
    private TextField email;
    @FXML
    private Button transactionmenu;

    @FXML
    void goshowbalance(ActionEvent event) throws Exception {
        Stage stage = (Stage) showbalance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showBalance.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void gohome(ActionEvent event) throws Exception {
        String tmpU = email.getText();
        String tmpP = passwd.getText();

//        for (int i = 0; i < Program.getTourists().size(); i++) {
//            if ((Program.getUserName().get(i).getUsername().equals(tmpU)) && (Program.getTourists().get(i).getPassword().equals(tmpP))) {
//                try {
//                    usernow.setText(tmpU);
//                } catch (Exception e) {
//
//                }
                Stage stage = (Stage) login.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                stage.setScene(new Scene(root));
                stage.show();
        loginmessage.setText("Wrong Password or User does not exist");


            }






    @FXML
    void gotransaction(ActionEvent event) throws Exception {
        Stage stage = (Stage) transaction.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("transaction.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gobills(ActionEvent event) throws Exception {
        Stage stage = (Stage) bills.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("bills.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gopurchaseitems(ActionEvent event) throws Exception {
        Stage stage = (Stage) purchaseitem.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("purchaseitem.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void gonotifications(ActionEvent event) throws Exception {
        Stage stage = (Stage) notifications.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("notifications.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void gobankstatement(ActionEvent event) throws Exception {
        Stage stage = (Stage) bankstatement.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BankStatement.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void gologout(ActionEvent event) throws Exception {
        Stage stage = (Stage) logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gohomefrombalance(ActionEvent event) throws Exception {
        Stage stage = (Stage) homebalance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gowithdraw(ActionEvent event) throws Exception {
        Stage stage = (Stage) withdraw.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("withdraw.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gotransfer(ActionEvent event) throws Exception {
        Stage stage = (Stage) transfer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("TransferScene.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gohomefromtransaction(ActionEvent event) throws Exception {
        Stage stage = (Stage) hometransaction.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void godeposit(ActionEvent event) throws Exception {
        Stage stage = (Stage) deposit.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("deposit.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gotransactionhome(ActionEvent event) throws Exception {
        Stage stage = (Stage) transactionmenu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("transaction.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
    }




}