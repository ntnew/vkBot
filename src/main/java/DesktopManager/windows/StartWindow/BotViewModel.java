package DesktopManager.windows.StartWindow;

import DesktopManager.Entities.Bot;
import DesktopManager.Entities.BotStatus;
import DesktopManager.EntityUtils.BotUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import lombok.Data;

public class BotViewModel {

  Bot bot;

  StringProperty botName = new SimpleStringProperty();
  StringProperty botDescription = new SimpleStringProperty();
  SimpleObjectProperty<BotStatus> botStatus = new SimpleObjectProperty<>(BotStatus.DISABLE);

  ObjectProperty<BotStatus> botStatusProperty = new SimpleObjectProperty<>();
  ObjectProperty<Button> buttonControl = new SimpleObjectProperty<>();

  public BotViewModel(Bot bot) {
    this.bot = bot;
    initValues();
  }

  private void initValues() {
    botName.setValue(bot.getName());
    botDescription.setValue(bot.getDescription());
  }

  public Bot getBot(){
    return bot;
  }

  public void setBot(Bot bot) {
    this.bot = bot;
  }

  public String getBotName() {
    return botName.get();
  }

  public StringProperty botNameProperty() {
    return botName;
  }

  public void setBotName(String botName) {
    this.botName.set(botName);
  }

  public String getBotDescription() {
    return botDescription.get();
  }

  public StringProperty botDescriptionProperty() {
    return botDescription;
  }

  public void setBotDescription(String botDescription) {
    this.botDescription.set(botDescription);
  }

  public BotStatus getBotStatus() {
    return botStatus.get();
  }

  public SimpleObjectProperty<BotStatus> botStatusProperty() {
    return botStatus;
  }

  public void setBotStatus(BotStatus botStatus) {
    this.botStatus.set(botStatus);
  }

  public BotStatus getBotStatusProperty() {
    return botStatusProperty.get();
  }

  public ObjectProperty<BotStatus> botStatusPropertyProperty() {
    return botStatusProperty;
  }

  public void setBotStatusProperty(BotStatus botStatusProperty) {
    this.botStatusProperty.set(botStatusProperty);
  }
}
