package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {

  Connection conn = null;
  Statement stmt = null;

  public void handleButtonAction(ActionEvent event) {
    //Event Handler for "Add Product" Button
    try {

      stmt = conn.createStatement();
      String sqlInsertProduct = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' );";
      ResultSet rs = stmt.executeQuery(sqlInsertProduct);
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
