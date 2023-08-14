package GUI;
import System.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Math.abs;

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
    private Button showbalancebutton;
    @FXML private Label notificationMessage;
    @FXML private Label depositmessage;

    @FXML
    void login(ActionEvent event) throws Exception{

        String tempEmail= emailtf.getText();
        String tempPasswd= passwdtf.getText();
        long start=System.currentTimeMillis();
        Account current=Bank.check(tempEmail,tempPasswd);
        if(current==null){
            loginmessage.setText("Wrong Password or User does not exist");
        }else{
            Stage stage = (Stage) login.getScene().getWindow();
            GlobalUser.setUserID(current.getUserName());
            GlobalUser.setUserPASS(current.getPassword());


                    emailtf.clear();
                    passwdtf.clear();

                    Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
                    stage.setScene(new Scene(root));
                    stage.show();
                    long finish =System.currentTimeMillis();
                    long ElapsedTime=start-finish;
                    System.out.println("elapsedtime "+abs(ElapsedTime));
                    GlobalUser.setTime(ElapsedTime+GlobalUser.getTime());
        }
    }
    @FXML
    void goshowbalance(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) showbalance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("showBalance.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        System.out.println(Bank.check(GlobalUser.getUserID(),GlobalUser.getUserPASS()).getBalance().toString());
        long end=System.currentTimeMillis();
        long elapsed=start-end;
        System.out.println("elapsedtime "+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());

    }
    @FXML
    void doshowbalance(ActionEvent event){
        long start=System.currentTimeMillis();
        balancetf.setText("");
        balancetf.setText(Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).getBalance().toString());
        long end=System.currentTimeMillis();
        long elapsed=start-end;
        System.out.println("elapsedtime "+abs(elapsed));
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }

    @FXML
    void gotransaction(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) transaction.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("transaction.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("elapsedtime "+abs(elapsed));
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void gobills(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) bills.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("bills.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("elapsedtime "+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void gopurchaseitems2(ActionEvent event)throws Exception{
        long start=System.currentTimeMillis();
        Stage stage = (Stage) billconfirm.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("purchaseitem.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("elapsedtime "+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML private Label billsmessage;
    @FXML
    void dobills(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        billsmessage.setText("");
        if(billCombo.getValue().equals(BillType.PURCHASED_ITEMS)){
            //TODO: set values of purchase items screen
            //String x=billamount.getText();
            gopurchaseitems2(event);
        }else {
            try {
                Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).payBill(Double.valueOf(billamount.getText()), billCombo.getValue());
                billsmessage.setText("Bill Payment Successful");
            } catch (TransactionsExceptions ib) {
                billsmessage.setText(ib.toString());
            }
        }
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void dopurcchaseitems(ActionEvent event){
        long start=System.currentTimeMillis();
        itemmessage.setText("");
        try {
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).purchaseItem(Double.valueOf(itemamount.getText()), itemstore.getText(), itemname.getText());
            itemmessage.setText("Item Purchase Successful");
        }catch(TransactionsExceptions ib){
            itemmessage.setText(ib.toString());
        }
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void gopurchaseitems(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) purchaseitem.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("purchaseitem.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }

    @FXML
    void gonotifications(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) notifications.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("notifications.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }

    @FXML
    void gobankstatement(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) bankstatement.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BankStatement.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }

    @FXML
    void gologout(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) logout.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        GlobalUser.setUserID("");
        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }

    @FXML
    void gowithdraw(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) withdraw.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("withdraw.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void gotransfer(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) transfer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("TransferScene.fxml"));

        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
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
        long start=System.currentTimeMillis();
        Stage stage = (Stage) deposit.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("deposit.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void dodeposit(ActionEvent event){
        long start=System.currentTimeMillis();
        depositmessage.setText("");
        try {
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).deposit(Double.valueOf(depositamount.getText()));
            depositmessage.setText("Deposit Successful");
        }catch( TransactionsExceptions e){
            depositmessage.setText(e.toString());
        }
        long end=System.currentTimeMillis();
        long elapsed=end-start;
       System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void dowithdraw(ActionEvent event){
        long start=System.currentTimeMillis();
        withdrawmesssage.setText("");
        try {
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).withdraw(Double.valueOf(withdrawamount.getText()));
            withdrawmesssage.setText("Withdraw Successful");
        }catch(TransactionsExceptions ib){
            withdrawmesssage.setText(ib.toString());
        }
        long end=System.currentTimeMillis();
        long elapsed=end-start;
       System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void dotransfer(ActionEvent event){
        long start=System.currentTimeMillis();
        transfermesssage.setText("");
        try{
            Bank.check(GlobalUser.getUserID(), GlobalUser.getUserPASS()).transfer(Double.valueOf(transferamount.getText()), Integer.valueOf(transferreceiver.getText()));
            transfermesssage.setText("Transfer Successful");
        }catch(TransactionsExceptions ib){
            transfermesssage.setText(ib.toString());
        }
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void gohomefrombalance(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) homebalance.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML
    void gotransactionhome(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) transactionmenu.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("transaction.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
       System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        billCombo.setItems(FXCollections.observableArrayList(BillType.values()));
    }
    @FXML
    void gosignup(ActionEvent event) throws Exception {
        long start=System.currentTimeMillis();
        Stage stage = (Stage) signup.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        long end=System.currentTimeMillis();
        long elapsed=end-start;
        System.out.println("Elapsedtime"+elapsed);
        GlobalUser.setTime(elapsed+GlobalUser.getTime());
    }
    @FXML public TextField fName;
    @FXML public TextField mName;
    @FXML public TextField lName;
    @FXML public TextField address;
    @FXML public TextField city;
    @FXML public TextField zipcode;
    @FXML public TextField SSN;
    @FXML public PasswordField cardNo;
    @FXML public TextField telephoneNo;
    @FXML public TextField eMail;
    @FXML public PasswordField passWord;
    @FXML public PasswordField rePassWord;
    @FXML public Label createmessage;
    @FXML public DatePicker birthDate;
    @FXML public Button confirmCreate;
    @FXML
    void doCreateAccount(ActionEvent event){
        long start=System.currentTimeMillis();
        createmessage.setText("");
        try{
            if(passWord.getText().equals(rePassWord.getText())==false){
                throw new NotMatchingPassword();
            }
            Bank.addAccount(new Account(eMail.getText(),passWord.getText(),birthDate.getValue(),
                    address.getText(),zipcode.getText(),SSN.getText(),cardNo.getText(),telephoneNo.getText(),
                    fName.getText(),mName.getText(),fName.getText()));
            createmessage.setText("Created Successfully");
        }catch(NotMatchingPassword e){
            createmessage.setText("Unmatching passwords");
        }
        long end=System.currentTimeMillis();
        long elapsed=start-end;
        System.out.println("Elapsedtime"+elapsed);


    }
    @FXML private Button shownot;
    @FXML
    void donot (ActionEvent event){
        notificationMessage.setText(Bank.check(GlobalUser.getUserID(),GlobalUser.getUserPASS()).notification);
    }
    @FXML private Label statementfname;
    @FXML private Label statementlname;
    @FXML private Label statementaddress;
    @FXML private Label statementSSN;
    @FXML private Label statementuser;
    @FXML private Button showstatement;
    @FXML private Label statementdisplay;
    @FXML private DatePicker statementdate;
    @FXML void dostatement(ActionEvent event){
        Account acc=Bank.check(GlobalUser.getUserID(),GlobalUser.getUserPASS());
        statementdisplay.setText("");
        statementfname.setText("");
        statementlname.setText("");
        statementaddress.setText("");
        statementSSN.setText("");
        statementuser.setText("");


        statementfname.setText(acc.getFirstName());
        statementlname.setText(acc.getLastName());
        statementaddress.setText(acc.getAddress());
        statementSSN.setText(acc.getSSN());
        statementuser.setText(acc.getUserName());

        statementdisplay.setText(Bank.check(GlobalUser.getUserID(),GlobalUser.getUserPASS()).Transactions.toString());
    }
}