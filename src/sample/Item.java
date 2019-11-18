package sample;

/**
 * An interface that sets up the getters and setters for Items that will be used in the program.
 *
 * @author Jackson
 */

public interface Item {
  //public int getInt();

  public void setName(String name);

  public String getName();

  public void setManufacturer(String manufacturer);

  public String getManufacturer();
}
