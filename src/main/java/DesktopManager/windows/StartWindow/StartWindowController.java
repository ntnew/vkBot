package DesktopManager.windows.StartWindow;

import DesktopManager.EntityUtils.BotUtils;
import DesktopManager.windows.AddWindow.AddWindow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class StartWindowController {

  public Button addBotButton;
  public TableView<BotViewModel> botsTable;
  public VBox content;

  public void configure(){
    botsTable.setPrefWidth(content.getWidth()/1.8);
    updateTable();
  }


  public void onAddBotButtonClick(ActionEvent actionEvent) {
    AddWindow addWindow = new AddWindow();
    if (addWindow.showAndWait()) {
      updateTable();
    }
  }

  private void updateTable(){
    try {
      List<BotViewModel> botViewModels = new ArrayList<>();
      BotUtils.getLocalBotSettings().forEach(x -> botViewModels.add(new BotViewModel(x)));
      botsTable.setItems(FXCollections.observableArrayList(botViewModels));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
