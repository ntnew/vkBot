package vk;


import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VKServer {
    static int RECONNECT_TIME = 10000;
    public static VKCore vkCore;
    public static List<String> reserveQueue = new ArrayList<>();
    public static final String pathToLetters = "/Reserves";
    public static final String programPath = System.getProperty("user.dir");
    public static final String resourcesPath = "/Resources";

    static {
        try {
            vkCore = new VKCore();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NullPointerException, ApiException, InterruptedException {


        System.out.println("Running server...");
        while (true) {
            Thread.sleep(300);
            try {
                Message message = vkCore.getMessage();
                if (message != null) {
                    ExecutorService exec = Executors.newCachedThreadPool();
                    exec.execute(new Messenger(message));
                    exec.shutdown();
                }
            } catch (ClientException e) {
                System.out.println("Возникли проблемы");
                System.out.println("Повторное соединение через " + RECONNECT_TIME / 1000 + " секунд");
                Thread.sleep(RECONNECT_TIME);
            }
        }
    }
}