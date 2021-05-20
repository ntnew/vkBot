package DesktopManager.system;

import javafx.stage.Window;

public interface AppWindow <T> {

  /**
   * Получение контроллера окна
   *
   * @return Контроллер
   */
  T getController();

  /**
   * Отображение окна
   */
  void show();

  /**
   * Отображение окна и ожидание его закрытия
   *
   * @return Результат работы окна. Желательно использовать для указания того, был ли выбран элемент
   */
  boolean showAndWait();

  /**
   * Установить владельца окна
   *
   * @param owner Владелец окна
   */
  void initOwner(Window owner);

}
