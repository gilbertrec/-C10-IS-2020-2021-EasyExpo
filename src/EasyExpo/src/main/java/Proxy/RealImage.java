package proxy;

public class RealImage implements Image {

  private final String iconPath;

  public RealImage(String iconPath) {
    this.iconPath = iconPath;
  }

  @Override
  public String display() {
    return iconPath;
  }

}