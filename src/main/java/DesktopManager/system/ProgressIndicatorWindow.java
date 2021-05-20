package DesktopManager.system;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class ProgressIndicatorWindow {

  private Stage stage;

  public ProgressIndicatorWindow(Window window) {
    try {
      String fxmlPath = "/ru/barsim/client/sysClass/ProgressIndicatorWindow.fxml";
      stage = new Stage();

      stage.setScene(new Scene(new FXMLLoader().load(ProgressIndicatorWindow.class.getResource(fxmlPath))));

      stage.getScene().getRoot().setStyle("-fx-background-color: transparent;");
      stage.initStyle(StageStyle.TRANSPARENT);
      stage.getScene().setFill(Color.TRANSPARENT);
      stage.centerOnScreen();
      stage.initOwner(window);
      WindowHelper.showStage(stage);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ProgressIndicatorWindow(Node node) {
    this(window(node));
  }

  public ProgressIndicatorWindow() {
    this((Window) null);
  }

  private static Window window(Node node) {
    if (node == null) {
      return null;
    }
    Scene scene = node.getScene();
    if (scene == null) {
      return null;
    }
    return scene.getWindow();
  }

  /**
   * Отобразить окно с вертушкой ожидания
   *
   * @param runnable длительный процесс в обычном потоке
   */
  public void show(UncheckedRunnable runnable) {
    show(Executors.callable(runnable), null);
  }

  /**
   * Отобразить окно с вертушкой ожидания
   *
   * @param callable длительный процесс в обычном потоке
   */
  public void show(Callable<?> callable) {
    show(callable, null);
  }

  /**
   * Отобразить окно с вертушкой ожидания
   *
   * @param runnable       длительный процесс в обычном потоке
   * @param fxThreadOnDone метод вызываемый по окончании основного процесса, выполняется в FX потоке
   */
  public void show(UncheckedRunnable runnable, UncheckedRunnable fxThreadOnDone) {
    show(Executors.callable(runnable), o -> fxThreadOnDone.run());
  }

  /**
   * Отобразить окно с вертушкой ожидания
   *
   * @param callable       длительный процесс в обычном потоке
   * @param fxThreadOnDone метод вызываемый по окончании основного процесса, выполняется в FX потоке
   * @param <T>            тип возвращаемого значения, передаётся в потребитель
   */
  public <T> void show(Callable<T> callable, Consumer<T> fxThreadOnDone) {
    FutureTask<T> futureTask = getTask(callable, fxThreadOnDone);
    new Thread(futureTask).start();
  }

  /**
   * Отобразить окно с вертушкой ожидания
   *
   * @param callable       длительный процесс в обычном потоке
   * @param fxThreadOnDone метод вызываемый по окончании основного процесса, выполняется в FX потоке
   * @param <T>            тип возвращаемого значения, передаётся в потребитель
   */
  public <T> void showFXThread(Callable<T> callable, Consumer<T> fxThreadOnDone) {
    FutureTask<T> futureTask = getTask(callable, fxThreadOnDone);
    Platform.runLater(futureTask);
  }

  /**
   * Создать задание на выполнение
   *
   * @param callable       длительный процесс в обычном потоке
   * @param fxThreadOnDone метод вызываемый по окончании основного процесса, выполняется в FX потоке
   * @param <T>            тип возвращаемого значения, передаётся в потребитель
   * @return созданный таск на выполнение в отдельном потоке
   */
  private <T> FutureTask<T> getTask(Callable<T> callable, Consumer<T> fxThreadOnDone) {
//    Callable<T> wrapped = () -> {
//      try {
//        return callable.call();
//      } catch (Exception e) {
//        WindowHelper.undecoratedError(e);
//        return null;
//      }
//    };
//
//    FutureTask<T> futureTask = new FutureTask<T>(wrapped) {
//      @Override
//      protected void done() {
//        Platform.runLater(stage::close);
//        Platform.runLater(fxThreadOnDone == null
//            ? Runnables.doNothing()
//            : () -> {
//              try {
//                fxThreadOnDone.accept(get());
//              } catch (InterruptedException e) {
//              } catch (ExecutionException e) {
//              }
//            });
//      }
//    };
    return null;
  }
}
