package DesktopManager.windows.StartWindow;

import DesktopManager.Entities.Bot;
import DesktopManager.Entities.BotStatus;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;

@Data
public class BotViewModel {

  Bot bot;

  StringProperty botName = new SimpleStringProperty();

  ObjectProperty<BotStatus> botStatusProperty = new SimpleObjectProperty<>();

}
