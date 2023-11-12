import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/table.fxml"))));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }
//Nvn
    public static void main(String[] args) {
        launch(args);
    }
}
