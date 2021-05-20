package DesktopManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Bot {

  private String name;

  private BotStatus botStatus;
}
