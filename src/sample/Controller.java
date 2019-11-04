package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * The Controller class holds almost all of the code that will be executed during this project,
 * including event handling and connecting to the data base.
 *
 * @author Jackson Turner
 */

public class Controller {

  Connection conn = null;
  Statement stmt = null;

  /**
   * The Event Handler for the "Add Product" Button.
   *
   * @param event This is the event that is activated when the button is pressed.
   * @throws SQLException These are any SQL problems that occur within the code.
   * @brief
   */
  public void handleButtonAction(ActionEvent event) {
    //Event Handler for "Add Product" Button
    try {
      final String JDBC_DRIVER = "org.h2.Driver";
      final String DB_URL = "jdbc:h2:./res/ProductionDB";
      conn = DriverManager.getConnection(DB_URL);
      stmt = conn.createStatement();
      String sqlInsertProduct =
          "INSERT INTO Product(type, manufacturer, name)" + " VALUES ( 'AUDIO', 'Apple', 'iPod' );";
      //ResultSet rs = stmt.executeQuery(sqlInsertProduct); //Bugged for "Dead Store to rs"
      stmt.executeUpdate(sqlInsertProduct);
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void handleRecordButtonAction(ActionEvent actionEvent) {
    //Event Handler for "Record Production" Button
    System.out.println("Production Recorded.");
  }

  ObservableList<String> numList =
      FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

  @FXML
  private ComboBox chooseQuantity;

  @FXML
  private void initialize() {
    //chooseQuantity.setValue("1");
    chooseQuantity.setItems(numList);
    chooseQuantity.setEditable(true);
    chooseQuantity.getSelectionModel().selectFirst();
  }
}
