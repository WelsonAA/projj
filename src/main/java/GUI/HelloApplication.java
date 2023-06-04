package GUI;
import System.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 650, 450));
        stage.show();
    }

    public static void main(String[] args) {
        Bank b =new Bank("HSBC","1C 90th Avenue");
        launch();
    }
}