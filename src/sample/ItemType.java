package sample;

/**
 * An Enum containing every ItemType we will use in the program.
 *
 * @author Jackson
 */
public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  //public final String type;
  public final String code;

  ItemType(String code) {
    //this.type = type;
    this.code = code;
  }
}
