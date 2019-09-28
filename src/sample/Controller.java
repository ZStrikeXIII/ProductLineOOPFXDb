package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;

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
}
