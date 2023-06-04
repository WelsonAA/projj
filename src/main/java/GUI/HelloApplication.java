package GUI;
import System.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 650, 450));
        stage.show();
    }

    public static void main(String[] args) {
        Bank.addAccount(new Account("user1","1234", 2500.0,LocalDate.parse("2003-03-24")));
        launch();
    }
}