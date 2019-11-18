package sample;

/**
 * A class that has unique functionality for AudioPlayer products.
 *
 * @author Jackson
 */
public class AudioPlayer extends Product implements MultimediaControl {

  public void play() {
    System.out.println("Playing");
  }

  public void stop() {
    System.out.println("Stopping");
  }

  public void previous() {
    System.out.println("Previous");
  }

  public void next() {
    System.out.println("Next");
  }

  String supportedAudioFormats;

  String supportedPlaylistFormats;


  /**
   * A class to store and display the information of an Audio Player product.
   *
   * @param name                     The name of the product.
   * @param manufacturer             The manufacturer of the product.
   * @param supportedAudioFormats    The product's supported audio formats.
   * @param supportedPlaylistFormats The product's supported playlist formats.
   */
  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {

    super(name, manufacturer, ItemType.AUDIO);

    this.supportedAudioFormats = supportedAudioFormats;

    this.supportedPlaylistFormats = supportedPlaylistFormats;

  }

  /**
   * A method used to print a String of text that can be changed depending on the product selected.
   *
   * @return A String is returned, using variables to fill in the necessary information
   */
  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type + "\n"
        + "Supported Audio Formats: " + supportedAudioFormats + "\n"
        + "Supported Playlist Formats: " + supportedPlaylistFormats;
  }
}
