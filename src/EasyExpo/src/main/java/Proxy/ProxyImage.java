package proxy;

import java.io.InputStream;
import java.nio.file.Path;

public class ProxyImage implements Image {

  private RealImage realImage;
  private String iconPath;

  public ProxyImage(String iconPatch) {

    if(iconPatch != null && !iconPatch.equals("")) {
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

