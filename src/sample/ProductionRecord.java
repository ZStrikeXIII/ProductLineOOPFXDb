package sample;

import java.util.Date;

/**
 * A class to assign every product a Production Number, a unique Product ID and Serial Number, as
 * well as the date it was produced.
 *
 * @author Jackson
 */

public class ProductionRecord {

  int productionNumber;
  int productID;
  String serialNumber;
  Date dateProduced;

  /**
   * This method is made to assign every product its number, unique ID and Serial Number, and the
   * date it was produced.
   *
   * @param productionNumber The production number of the product.
   * @param productID        The individual product's ID.
   * @param serialNumber     The serial number of the product, unique for each one.
   * @param dateProduced     Date the product was produced.
   */
  public ProductionRecord(int productionNumber, int productID, String serialNumber,
      Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced; //Bugged for code vulnerability

  }

  /**
   * An overloaded constructor for ProductionRecord, which creates the unique serial number, taking
   * into account the item count for the specific product.
   *
   * @param productProduced The product produced to be used in the production record.
   * @param i               The item count for the product, used in the assignment of the serial
   *                        number.
   */
  public ProductionRecord(Product productProduced, int i) {
    this.serialNumber =
        productProduced.manufacturer.substring(0, 3) + productProduced.type.code + String
            .format("%05d", i);
    this.dateProduced = new Date();
  }

  public int getProductionNum() {
    return productionNumber;
  }

  public void setProductionNum(int prodNum) {
    this.productionNumber = prodNum;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int prodID) {
    this.productID = prodID;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public void setSerialNum(String serNum) {
    this.serialNumber = serNum;
  }

  public Date getProdDate() {
    return dateProduced; //Bugged for code vulnerability
  }

  public void setProdDate(Date dtProd) {
    this.dateProduced = dtProd; //Bugged for code vulnerability
  }

  /**
   * The identifier of a specific product.
   *
   * @param productIdent The product's unique identifier to be used.
   */
  public ProductionRecord(int productIdent) {
    this.productionNumber = 0;
    this.productID = productIdent;
    this.serialNumber = "0";
    this.dateProduced = new Date();
  }

  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productID + " Serial Num: "
        + serialNumber + " Date: " + dateProduced;
  }
}
