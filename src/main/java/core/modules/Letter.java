package core.modules;

import vk.VKServer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static core.modules.FileHelper.clearLetter;
import static core.modules.FileHelper.readLetter;

/*
 * Класс отправки письма
 */
public class Letter extends Thread {

  public static String header = "Здравствуйте. Клиент хочет заказать стол, перезвоните ему по номеру, " +
      "указанному ниже.\n";

  public static String foot = "\nЭто письмо создано автоматически. На него не нужно отвечать.";
  /*
   * идентификатор пользователя
   */
  public int userId;
  /*
   * sender email
   */
  private String to;
  /*
   * receiver email
   */
  private String from;
  /*
   * mail server host
   */
  private String host = "smtp.gmail.com";
  /*
   * receiver password
   */
  private String password;

  public Letter(int userId) {
    this.userId = userId;
    loadLetterProperties();
  }

  /*
   * Отправить письмо
   */
  @Override
  public void run() {

    try {
      Properties properties = System.getProperties();
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.user", from);
      properties.put("mail.smtp.password", password);
      properties.put("mail.smtp.port", "587");
      properties.put("mail.smtp.auth", "true");

      Session session = Session.getDefaultInstance(properties); // default session
      MimeMessage message = new MimeMessage(session); // email message

      message.setFrom(new InternetAddress(from)); // setting header fields

      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      message.setSubject("Бронирование стола"); // subject line

      message.setText(header + readLetter(userId + "") + foot);

      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, password);
      transport.sendMessage(message, message.getAllRecipients());
      System.out.println("Email Sent successfully....");
      transport.close();
      System.out.println("Сделан заказ");

    } catch (MessagingException mex) {
      mex.printStackTrace();
      System.out.println("не отправил");
    }
    clearLetter(userId + "");
  }

  /*
   * Заполнить настройки письма (кому, от кого, пароль, хост)
   */
  private void loadLetterProperties() {
    Properties prop = new Properties();
    try {
      prop.load(new FileInputStream(VKServer.programPath + VKServer.resourcesPath + "/vkconfig.properties"));
      to = prop.getProperty("email");
      from = prop.getProperty("emailFrom");
      host = "smtp.gmail.com";
      password = prop.getProperty("emailPassword");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
