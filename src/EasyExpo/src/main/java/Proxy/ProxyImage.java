package proxy;

public class ProxyImage implements Image {

  private RealImage realImage;
  private final String iconPath;

  public ProxyImage(String iconPatch) {

    if (iconPatch != null && !iconPatch.equals("")) {
      this.realImage = new RealImage(iconPatch);
      this.iconPath = iconPatch;
    } else {
      this.iconPath = "images/img-errata.png";
    }

  }

  @Override
  public String display() {
    if (realImage == null) {
      return this.iconPath;
    }
    return realImage.display();
  }

}

