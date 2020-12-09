package vk;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static core.modules.RandomId.setRandomId;

/**
 * @author Arthur Kupriyanov
 */
public class VKManager {
    public static VKCore vkCore;

    static {
        try {
            vkCore = new VKCore();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg, int peerId, boolean uniqueMsg){
        if (msg == null){
            return;
        }
        try {
            vkCore.getVk().messages()
                    .send(vkCore.getActor())
                    .peerId(peerId)
                    .randomId(uniqueMsg ? generateUniqId(peerId) :setRandomId())
                    .message(msg)
                    .execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }
    public int generateUniqId(int peerId){
        Calendar calendar = new GregorianCalendar();
        return peerId + calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.MONTH);
    }

    public void sendUniqueMessage(String msg, int peerId){
        if (msg == null){
            return;
        }
        Calendar calendar = new GregorianCalendar();
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).randomId(peerId +
                    calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.MONTH) ).message(msg).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }

    /**
     * Обращается к VK API и получает объект, описывающий пользователя.
     * @param id идентификатор пользователя в VK
     * @return {@link UserXtrCounters} информацию о пользователе
     * @see UserXtrCounters
     */
//    public static UserXtrCounters getUserInfo(int id){
//        try {
//            return vkCore.getVk().users()
//                    .get(vkCore.getActor())
//                    .userIds(String.valueOf(id))
//                    .execute()
//                    .get(0);
//        } catch (ApiException | ClientException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

}
