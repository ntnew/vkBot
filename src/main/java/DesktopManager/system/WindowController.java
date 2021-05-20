package DesktopManager.system;


/**
 * Интерфейс для всех контроллеров окна, для создания окна типичным образом
 */
public interface WindowController {

  /**
   * Путь для FXML файла данного окна
   *
   * @return путь
   */
  String getFXMLPath();

  /**
   * Получить заголовок текущего окна
   *
   * @return Заголовок окна
   */
  String getTitle();

  /**
   * Достаточно создать объект контроллера и вызывать этот метод для показа модального окна с единственной кнопкой
   * "закрыть"
   */
//  default void showWaiting() {
//    WindowHelper.showStageAndWait(WindowHelper.getStage(this));
//  }
//
//  /**
//   * Достаточно создать объект контроллера и вызывать этот метод для показа нового окна
//   */
//  default void showStage() {
//    WindowHelper.showStage(WindowHelper.getStage(this));
//  }

}
