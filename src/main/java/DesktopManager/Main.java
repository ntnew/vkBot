package DesktopManager;

import DesktopManager.windows.StartWindow.StartWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    StartWindow startWindow = new StartWindow();
    startWindow.show();
  }

}
