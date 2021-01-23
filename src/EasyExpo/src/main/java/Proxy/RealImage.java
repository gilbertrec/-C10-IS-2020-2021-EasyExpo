package proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;

public class RealImage implements Image {

  private String iconPath;

  public RealImage(String iconPath) {
    this.iconPath = iconPath;
  }

  @Override
  public String display() {
    return iconPath;
  }

}