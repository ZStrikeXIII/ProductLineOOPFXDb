package sample;

public enum ItemType {
  AUDIO("Audio", "AU"),
  VISUAL("Visual", "VI"),
  AUDIO_MOBILE("AudioMobile", "AM"),
  VISUAL_MOBILE("VisualMobile", "VM");

  public final String type;
  public final String code;

  ItemType(String type, String code) {
    this.type = type;
    this.code = code;
  }
}
