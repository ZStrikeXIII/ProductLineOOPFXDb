package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The Controller class holds almost all of the code that will be executed during this project,
 * including event handling and connecting to the data base.
 *
 * @author jbturner
 */

public class Controller {

  //FX ID set ups
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
  private TableColumn<?, ?> colType;

  @FXML
  private ListView<Product> listChooseProd;

  @FXML
  private Button buttRecordProd;

  @FXML
  private ComboBox chooseQuantity;

  @FXML
  public TextField nameField;

  @FXML
  public TextField initialPassword;

  @FXML
  public Button genButton;

  @FXML
  public TextArea returnGensTextArea;

  Connection conn = null;
  Statement stmt = null;

  //Creating Observable List for the TableView
  private ObservableList<Product> productLine = FXCollections.observableArrayList();


  /**
   * The Event Handler for the "Add Product" Button.
   *
   * @param event This is the event that is activated when the button is pressed.
   */
  public void handleButtonAction(ActionEvent event) {
    //Event Handler for "Add Product" Button
    try {
      final String JDBC_DRIVER = "org.h2.Driver";
      final String DB_URL = "jdbc:h2:./res/ProductionDB";
      conn = DriverManager.getConnection(DB_URL);
      stmt = conn.createStatement();
      String sqlInsertProduct =
          "INSERT INTO Product(type, manufacturer, name)" + " VALUES ( 'AUDIO', 'Apple', 'iPod');";
      /*PreparedStatement productPreparation = conn.prepareStatement(sqlInsertProduct);
      productPreparation.setString(1, txtProdName.getText());
      productPreparation.setString(2, txtManu.getText());
      ItemType type = choiceItemType.getValue();
      String typeString = type.toString();
      productPreparation.setString(3, typeString);
      productPreparation.executeUpdate(sqlInsertProduct);*/
      //ResultSet rs = stmt.executeQuery(sqlInsertProduct); //Bugged for "Dead Store to rs"
      stmt.executeUpdate(sqlInsertProduct);
      stmt.close();
      conn.close();

      //Setting up Table variables
      String name = txtProdName.getText();

      String manufacturer = txtManu.getText();

      ItemType type = choiceItemType.getValue();

      String typeString = type.toString(); //Bugged for "Dead Store"

      //Creating a new Product for the Table
      Product newProduct = new Widget(name, manufacturer, type);

      tvProdLineSetup();

      //Adding new product
      productLine.add(newProduct);

      //Adding product to Product tab's list
      listChooseProd.getItems().add(newProduct);

      //tvProductLine.setItems(productLine);

      //Checking to see if product's type is stored or not due to unknown errors
      System.out.println(newProduct);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method for setting up the Table View's columns and contents.
   */
  private void tvProdLineSetup() {
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));

    colManu.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

    colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    tvProductLine.setItems(productLine);
  }

  /**
   * Event handler for when the "Record Production" Button is clicked by the user, which will add
   * the selected quantity to the Production Log's textbox.
   *
   * @param actionEvent The actionEvent is the User clicking the button.
   */
  public void handleRecordButtonAction(ActionEvent actionEvent) {
    //Event Handler for "Record Production" Button
    int i;
    System.out.println("Production Recorded.");
    Object quantity = chooseQuantity.getValue();
    String quantString = quantity.toString();
    int quant = Integer.valueOf(quantString); //Bugged for Performance
    //Setting the product's info in the Production Log
    Product recordedProd = listChooseProd.getSelectionModel().getSelectedItem();
    for (i = quant; i >= 0; i--) {
      textSetter(recordedProd);
      //ProductionRecord recordProd = new ProductionRecord();
      String serialNum = recordedProd.manufacturer.substring(0, 3) + recordedProd.type.code + String
          .format("%05d", i);
      txtbxProdLog.appendText("Serial Number: " + serialNum + "\n");
    }
  }

  /**
   * A method to add a product's information to the Production Log.
   *
   * @param newProd The New Product's information to be added to the Production Log
   */
  public void textSetter(Product newProd) {
    String prodString = newProd.toString();
    txtbxProdLog.appendText(prodString + "\n" /*+ "Quantity: " + chooseQuantity.getValue()*/);
  }

  private void loadProdList() {
  }

  private void loadProdLog() {
    //textSetter(Product newProd);
  }

  //List of numbers for the Product tab's Quantity Choice Box
  ObservableList<String> numList =
      FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");


  /**
   * Method to initialize multiple aspects of the program.
   */
  @FXML
  private void initialize() {
    //chooseQuantity.setValue("1");
    chooseQuantity.setItems(numList);
    chooseQuantity.setEditable(true);
    chooseQuantity.getSelectionModel().selectFirst();

    listChooseProd.getItems().addAll(productLine);

    /*colName.setCellValueFactory(new PropertyValueFactory<>("name"));

    colManu.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

    colType.setCellValueFactory(new PropertyValueFactory<>("type"));

    tvProductLine.setItems(productLine);*/

    tvProdLineSetup();

    choiceItemType.getItems().addAll(ItemType.values());

    loadProdList();

    loadProdLog();
  }

  /**
   * A method for the Employee tab to generate the Employee's username, password (if their desired
   * password is invalid), and email, returned to them in a TextArea via a toString method from the
   * Employee class.
   *
   * @param actionEvent The action event is the user clicking the button.
   */
  public void handleGenButtonAction(ActionEvent actionEvent) {
    String name = nameField.getText();
    String initPassword = initialPassword.getText();
    Employee employ = new Employee(name, initPassword);
    returnGensTextArea.setText(employ.toString());
  }
}
