package sample;

public class Screen implements ScreenSpec {

  String resolution;
  int refreshrate;
  int responsetime;

  /**
   *
   * @param resolution
   * @param refreshrate
   * @param responsetime
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
