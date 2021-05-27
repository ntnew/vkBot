package DesktopManager.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Bot {

  private String name;

  private String description;

  private BotStatus botStatus;

  private String accessToken;

  private String groupId;

  private String emailTo;

  private String emailFrom;

  private String emailPassword;
}
