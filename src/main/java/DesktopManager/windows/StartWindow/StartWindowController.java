package DesktopManager.windows.StartWindow;

import DesktopManager.EntityUtils.BotUtils;
import DesktopManager.windows.AddWindow.AddWindow;
import java.io.IOException;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

/*
 * Контроллер основного окна
 */
public class StartWindowController {

  public Button addBotButton;
  public TableView<BotViewModel> botsTable;
  public VBox content;
  public Button controlButton;

  public void configure() {
    botsTable.setPrefWidth(content.getWidth() / 1.8);
    updateTable();
  }


  public void onAddBotButtonClick(ActionEvent actionEvent) {
    AddWindow addWindow = new AddWindow();
    if (addWindow.showAndWait()) {
      updateTable();
    }
  }

  /*
   * Обновление данных в таблице
   */
  private void updateTable() {
    try {
      botsTable.setItems(FXCollections.observableArrayList(
          BotUtils.getLocalBotSettings().stream().map(BotViewModel::new).collect(Collectors.toList())));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
