package sample;

public class MoviePlayer extends Product implements MultimediaControl {

  private Screen newScreen;
  private MonitorType mt;

  public MoviePlayer(String nm, String mnfct, Screen newScreen, MonitorType mt) {
    super(nm, mnfct, ItemType.VISUAL);
    this.newScreen = newScreen;
    this.mt = mt;

  }

  @Override
  public String toString() {
    return super.toString() + "\n" + "Screen: " + "\n" + "Resolution: " + newScreen.resolution
        + "\n"
        + "Refresh rate: " + newScreen.refreshrate
        + "\n" + "Response time: " + newScreen.responsetime + "\n" + "Monitor Type: " + mt;
  }

  public void play() {
    System.out.println("Playing movie");
  }

  public void stop() {
    System.out.println("Stopping movie");
  }

  public void previous() {
    System.out.println("Previous movie");
  }

  public void next() {
    System.out.println("Next movie");
  }
}

