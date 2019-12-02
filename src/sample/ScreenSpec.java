package sample;

/**
 * An interface setting up the getter methods to retrieve the aspects of a Product's Screen, if the
 * Product has one.
 *
 * @author jbturner
 */

public interface ScreenSpec {

  public String getResolution();

  public int getRefreshRate();

  public int getResponseTime();
}
