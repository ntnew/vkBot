package DesktopManager.system;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowHelper {

//  /**
//   * Получить стэйдж контейнер для отображения
//   *
//   * @param controller контроллер на основе которого создаётся стэйдж
//   * @return стэйдж
//   */
//  public static Stage getStage(WindowController controller) {
//    return getStage(controller.getFXMLPath(), controller.getTitle(), false, controller);
//  }

//  /**
//   * Получение сцены окна с определенным контролером
//   *
//   * @param fxmlPath    Путь к шаблону окна
//   * @param title       Заголовок окна
//   * @param isMaximized Признак того, что окно должно быть развернуто на весь экран
//   * @param controller  Контроллер окна
//   * @return Сцена окна
//   */
//  public static Stage getStage(String fxmlPath, String title, boolean isMaximized,
//      Object controller) {
//
//    URL fxmlURL = WindowHelper.class.getResource(fxmlPath);
//    FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
//    fxmlLoader.setController(controller);
//    return getStage(fxmlLoader, title, isMaximized);
//  }

  /**
   * Получение сцены окна
   *
   * @param fxmlLoader  Загрузчик
   * @param title       Заголовок окна
   * @param isMaximized Признак того, что окно должно быть развернуто на весь экран
   * @return Сцена окна
   */
  public static Stage getStage(FXMLLoader fxmlLoader, String title, boolean isMaximized) {
    return getStage(fxmlLoader, title, isMaximized, true);
  }

  /**
   * Получение сцены окна
   *
   * @param fxmlLoader  Загрузчик
   * @param title       Заголовок окна
   * @param isMaximized Признак того, что окно должно быть развернуто на весь экран
   * @param resizible   Признак того, что можно изменять размеры окна
   * @return Сцена окна
   */
  public static Stage getStage(FXMLLoader fxmlLoader, String title, boolean isMaximized,
      boolean resizible) {
    Integer width = (isMaximized) ? 0 : null;
    Integer height = (isMaximized) ? 0 : null;
    return getStage(fxmlLoader, title, width, height, resizible);
  }
  /**
   * Получение сцены окна
   *
   * @param fxmlLoader Загрузчик
   * @param title      Заголовок окна
   * @param width      Ширина окна       (width=0 & height=0 -> Максимальное окно по ширине и высоте)
   * @param height     Высота окна
   * @return Сцена окна
   */
  public static Stage getStage(FXMLLoader fxmlLoader, String title, Integer width,
      Integer height, boolean resizible) {
    try {
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle(title);

      if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
        stage.setMaximized(width != null && height != null && width == 0 && height == 0);
      } else {
        stage.setMaximized(false);
      }
      stage.setResizable(resizible);
      Scene scene = new Scene(fxmlLoader.load());
//TODO сделать картинку
//      Image imageOk = new Image(WindowHelper.class.getClassLoader().
//          getResourceAsStream("icons/bars.png"));
//      stage.getIcons().add(imageOk);
      stage.setScene(scene);
      return stage;

    } catch (IOException ex) {
      //LOG.error("", ex);
      throw new RuntimeException(ex);
    }
  }
  /**
   * Показать сцену
   *
   * @param stage Сцена
   */
  public static void showStage(Stage stage) {
    stage.initModality(Modality.NONE);
    stage.show();
    Platform.runLater(() -> {
      stage.toFront();
      stage.requestFocus();
    });
  }

  /**
   * Показать сцену и ждать
   *
   * @param stage Сцена
   */
  public static void showStageAndWait(Stage stage) {
    Modality modality = stage.getOwner() == null ?
        Modality.APPLICATION_MODAL : Modality.WINDOW_MODAL;

    stage.initModality(modality);
    Platform.runLater(
        () -> stage.requestFocus());  // под Linux бросает на главное окно. Для борьбы с этим
    stage.showAndWait();
  }

}
