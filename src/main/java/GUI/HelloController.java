package GUI;
import System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
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
    private javafx.scene.control.TextField passwdtf;
    @FXML
    private javafx.scene.control.TextField emailtf;
    @FXML
    private Button transactionmenu;
    @FXML
    private Button signup;
    @FXML
    private Button depositconfirm;
    @FXML
    private javafx.scene.control.TextField depositamount;
    @FXML
    private Button withdrawconfirm;
    @FXML
    private javafx.scene.control.TextField withdrawamount;
    @FXML
    private Label withdrawmesssage;
    @FXML
    private Button transferconfirm;
    @FXML
    private javafx.scene.control.TextField transferamount;
    @FXML
    private javafx.scene.control.TextField  transferreceiver;
    @FXML
    private Label transfermesssage;
    @FXML
    private Button billconfirm;
    @FXML
    private javafx.scene.control.TextField billamount;
    @FXML
    private ComboBox<BillType> billCombo=new ComboBox<>();
    @FXML
    private Button itemconfirm;
    @FXML
    private javafx.scene.control.TextField itemamount;
    @FXML
    private javafx.scene.control.TextField itemstore;
    @FXML
    private javafx.scene.control.TextField itemname;
    @FXML
    private Label itemmessage;
    @FXML
    private javafx.scene.control.TextField balancetf;
    @FXML
    void login(ActionEvent event) throws Exception{
        String tempEmail= emailtf.getText();
        String tempPasswd= passwdtf.getText();
        Account current=Bank.check(tempEmail,tempPasswd);
        if(current==null){
            loginmessage.setText("Wrong Password or User does not exist");
        }else{
            emailtf.clear();
            passwdtf.clear();
            Stage stage = (Stage) login.getScene().getWindow();
            GlobalUser.setUserID(current.getUserName());
            GlobalUser.setUserPASS(current.getPassword());
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
    @FXML
    void goshowbalance(ActionEvent event) throws Exception {
        Stage stage = (Stage) showbalance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showBalance.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println(Bank.check(GlobalUser.getUserID(),GlobalUser.getUserPASS()).getBalance().toString());

        balancetf.setText(Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).getBalance().toString());


    }

    /*@FXML
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
    }*/

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
    void dobills(ActionEvent event) throws Exception {
        if(billCombo.getValue().equals(BillType.PURCHASED_ITEMS)){
            //TODO: set values of purchase items screen
            itemamount.setText(billamount.getText());
            gopurchaseitems(event);
        }
        try {
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).payBill(Double.valueOf(billamount.getText()),billCombo.getValue());
        }catch(InsufficientBalance ib){
            withdrawmesssage.setText("Insufficient Balance");
        }
    }
    @FXML
    void dopurcchaseitems(ActionEvent event){
        try {
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).purchaseItem(Double.valueOf(itemamount.getText()), itemstore.getText(), itemname.getText());
        }catch(InsufficientBalance ib){
            itemmessage.setText("Insufficient Balance");
        }
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
        GlobalUser.setUserID("");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gohomefrombalance(ActionEvent event) throws Exception {
        itemmessage.setText("");
        itemamount.clear();
        itemstore.clear();
        itemname.clear();
        transfermesssage.setText("");
        transferamount.clear();
        withdrawamount.clear();
        withdrawmesssage.setText("");
        transferreceiver.clear();
        billamount.clear();
        billamount.clear();
        balancetf.clear();
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
    void dodeposit(ActionEvent event){
        System.out.println(Double.valueOf(depositamount.getText()));
        Bank.check(GlobalUser.getUserID(),GlobalUser.getUserPASS()).deposit(Double.valueOf(depositamount.getText()));
    }
    @FXML
    void dowithdraw(ActionEvent event){
        try {
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).withdraw(Double.valueOf(withdrawamount.getText()));
        }catch(InsufficientBalance ib){
            withdrawmesssage.setText("Insufficient Balance");
        }
    }
    @FXML
    void dotransfer(ActionEvent event){
        try{
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).transfer(Double.valueOf(withdrawamount.getText()), Integer.valueOf(transferreceiver.getText()));
        }catch(InsufficientBalance ib){
            transfermesssage.setText("Insufficient Balance");
        }catch(InvalidAccountNo ivn){
            transfermesssage.setText("InvalidAccountNo");
        } catch(TransferExceptions e){

        }
    }
    @FXML
    void gotransactionhome(ActionEvent event) throws Exception {
        Stage stage = (Stage) transactionmenu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("transaction.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void gosignup(ActionEvent event) throws Exception {
        Stage stage = (Stage) signup.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        billCombo.setItems(FXCollections.observableArrayList(BillType.values()));
    }
}