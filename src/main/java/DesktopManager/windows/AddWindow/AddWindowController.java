package DesktopManager.windows.AddWindow;

import DesktopManager.Entities.Bot;
import DesktopManager.Entities.BotStatus;
import DesktopManager.EntityUtils.BotUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Окно добавления нового бота
 */
public class AddWindowController {

  public TextField nameField;
  public TextField descriptionField;
  public TextField accessTokenField;
  public TextField groupIdField;
  public TextField emailToField;
  public TextField emailFromField;
  public TextField emailPassField;
  public VBox content;

  /*
   * Обработка нажатия на кнопку создать
   */
  public void onCreateButtonClick(ActionEvent actionEvent) {
    checkFilledFields();
    Bot bot = new Bot(nameField.getText(), descriptionField.getText(), BotStatus.DISABLE, accessTokenField.getText(),
        groupIdField.getText(), emailToField.getText(), emailFromField.getText(), emailPassField.getText());
    BotUtils.initializeBotSettings(bot);
    onCancelButtonClick(null);
  }

  public void onCancelButtonClick(ActionEvent actionEvent) {
    ((Stage) content.getScene().getWindow()).close();
  }

  private void checkFilledFields() {

  }
}
