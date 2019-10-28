package sample;

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
   *
   * @param name
   * @param manufacturer
   * @param supportedAudioFormats
   * @param supportedPlaylistFormats
   */
  public AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {

    super(name, manufacturer, ItemType.AUDIO);

    this.supportedAudioFormats = supportedAudioFormats;

    this.supportedPlaylistFormats = supportedPlaylistFormats;

  }

  /**
   *
   * @return
   */
  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + type + "\n"
        + "Supported Audio Formats: " + supportedAudioFormats + "\n"
        + "Supported Playlist Formats: " + supportedPlaylistFormats;
  }
}
