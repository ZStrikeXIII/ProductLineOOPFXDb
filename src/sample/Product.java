package sample;

/**
 * The main Product class that the majority of the program revolves around for data.
 *
 * @author Jackson
 */

public abstract class Product implements Item {

  //int id;
  String name;
  String manufacturer;
  ItemType type;

  /*
  public int getId(){
    return id;
  }*/

  public String getName() {
    return name;
  }

  public void setName(String nm) {
    this.name = nm;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String mnfct) {
    this.manufacturer = mnfct;
  }

  Product(String nm, String mnfct, ItemType tp) {
    this.name = nm;
    this.manufacturer = mnfct;
    this.type = tp;
  }

  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type;
  }

}


class Widget extends Product { //The Widget class here makes a Google Check error

  Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
