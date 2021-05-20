package DesktopManager.windows.AddWindow;

import DesktopManager.system.AppWindow;
import DesktopManager.system.WindowHelper;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddWindow implements AppWindow<AddWindowController> {

  /**
   * Путь к шаблону окна
   */
  private static final String FXML_PATH =
      "/DesktopManager/windows/AddWindow/AddWindow.fxml";

  /**
   * Заголовок окна
   */
  private static final String TITLE = "Создать бота";
  /**
   * Контроллер
   */
  private final AddWindowController controller;
  /**
   * Окно
   */
  private final Stage stage;

  /**
   * Конструктор
   */
  public AddWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH));
    stage = WindowHelper.getStage(loader, TITLE, 800, 600, true);
    controller = loader.getController();
  }

  @Override
  public AddWindowController getController() {
    return controller;
  }

  @Override
  public void show() {
    stage.show();
  }

  @Override
  public boolean showAndWait() {
    WindowHelper.showStageAndWait(stage);
    return true;
  }

  @Override
  public void initOwner(Window owner) {

  }

}
