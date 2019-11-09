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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The Controller class holds almost all of the code that will be executed during this project,
 * including event handling and connecting to the data base.
 *
 * @author Jackson Turner
 */

public class Controller {

  @FXML
  private TextField txtProdName;

  @FXML
  private TextField txtManu;

  @FXML
  private Button buttAddProd;

  @FXML
  private TextArea txtbxProdLog;

  @FXML
  private TableView<Product> tvProductLine;

  @FXML
  private ChoiceBox<ItemType> choiceItemType;

  @FXML
  private TableColumn<?, ?> colName;

  @FXML
  private TableColumn<?, ?> colManu;

  @FXML
  public TableColumn<?, ?> colType;

  @FXML
  private ListView<Product> listChooseProd;

  @FXML
  private Button buttRecordProd;

  Connection conn = null;
  Statement stmt = null;

  private ObservableList<Product> productLine = FXCollections.observableArrayList();


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

      String name = txtProdName.getText();

      String manufacturer = txtManu.getText();

      ItemType type = choiceItemType.getValue();

      //String typeString = type.toString(); //Bugged for "Dead Store"

      Product newProduct = new Widget(name, manufacturer, type);

      productLine.add(newProduct);

      listChooseProd.getItems().add(newProduct);

      textSetter(newProduct);

      //ResultSet rs = stmt.executeQuery(sqlInsertProduct); //Bugged for "Dead Store to rs"
      stmt.executeUpdate(sqlInsertProduct);
      stmt.close();
      conn.close();

      System.out.println(newProduct);


    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /*private void productLineSet() {
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));
  }*/

  /**
   * Event handler for when the "Record Production" Button is clicked by the user.
   *
   * @param actionEvent The actionEvent is the User clicking the button.
   */
  public void handleRecordButtonAction(ActionEvent actionEvent) {
    //Event Handler for "Record Production" Button
    System.out.println("Production Recorded.");
    Object quantity = chooseQuantity.getValue();
    String quantString = quantity.toString();
    txtbxProdLog.appendText("Quantity: " + quantString + "\n");
    //textSetter(newProduct);
  }

  public void textSetter(Product nP) {
    String prodString = nP.toString();
    txtbxProdLog.appendText(prodString + "\n" /*+ "Quantity: " + chooseQuantity.getValue()*/);
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

    listChooseProd.getItems().addAll(productLine);

    colName.setCellValueFactory(new PropertyValueFactory<>("name"));

    colManu.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

    colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    tvProductLine.setItems(productLine);

    choiceItemType.getItems().addAll(ItemType.values());
  }
}
