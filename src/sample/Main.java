package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Jackson Turner
 */

public class Main extends Application {

  /**
   * The "start" method is the starting point of a JavaFX program. This method sets the title.
   *
   * @param primaryStage This is the Primary Stage
   * @throws Exception These are any problems that occur within the code
   * @brief
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
