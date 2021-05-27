package DesktopManager.windows.StartWindow;

import DesktopManager.system.AppWindow;
import DesktopManager.system.WindowHelper;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StartWindow implements AppWindow<StartWindowController> {

  /**
   * Путь к шаблону окна
   */
  private static final String FXML_PATH =
      "/DesktopManager/windows/StartWindow/StartWindow.fxml";

  /**
   * Заголовок окна
   */
  private static final String TITLE = "Диспетчер ботов";
  /**
   * Контроллер
   */
  private final StartWindowController controller;
  /**
   * Окно
   */
  private final Stage stage;


  /**
   * Конструктор
   */
  public StartWindow() {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH));
    stage = WindowHelper.getStage(loader, TITLE, 800, 600, true);
    controller = loader.getController();
    controller.configure();
  }

  @Override
  public StartWindowController getController() {
    return controller;
  }

  @Override
  public void show() {
    stage.show();
  }

  @Override
  public boolean showAndWait() {
    return false;
  }

  @Override
  public void initOwner(Window owner) {

  }
}
