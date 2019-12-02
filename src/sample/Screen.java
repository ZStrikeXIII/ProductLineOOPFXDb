package sample;

/**
 * A class that holds the aspects of a Product's Screen, if it is of a Visual type.
 *
 * @author jbturner
 */

public class Screen implements ScreenSpec {

  String resolution;
  int refreshrate;
  int responsetime;

  /**
   * The attributes of a screen to be used with a Movie Player product.
   *
   * @param resolution   The resolution of the screen.
   * @param refreshrate  The refresh rate of the screen.
   * @param responsetime The response time of the screen.
   */
  public Screen(String resolution, int refreshrate, int responsetime) {
    this.resolution = resolution;
    this.refreshrate = refreshrate;
    this.responsetime = responsetime;
  }

  public String getResolution() {
    return resolution;
  }

  public int getRefreshRate() {
    return refreshrate;
  }

  public int getResponseTime() {
    return responsetime;
  }
}
