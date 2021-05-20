package DesktopManager.windows.StartWindow;

import DesktopManager.windows.AddWindow.AddWindow;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class StartWindowController {

  public Button addBotButton;
  public TableView<BotViewModel> botsPane;

  public void onAddBotButtonClick(ActionEvent actionEvent) {
    BotViewModel bot = new BotViewModel();
    AddWindow addWindow = new AddWindow();
    addWindow.showAndWait();
  }
}
