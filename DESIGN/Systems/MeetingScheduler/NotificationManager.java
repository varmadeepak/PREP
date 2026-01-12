import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class NotificationManager {
    private static NotificationManager notificationManager = null;
    // userId -> <Type Of Notification>
    private Map<Integer,List<NotificationSender>> subscribedNotificationsPerUser = new HashMap<>();

    private NotificationManager(){}

    public static NotificationManager getNotificationManager() {
        if(null == notificationManager) {
            notificationManager = new NotificationManager();
        }
        return notificationManager;
    }

    public void subscribeToNotificationType(int userId,NotificationSender notificationSender) {
        subscribedNotificationsPerUser.computeIfAbsent(userId,key -> new ArrayList<>())
        .add(notificationSender);
    }

    public void removeNotificationType(int userId,NotificationSender notificationSender) {
        subscribedNotificationsPerUser.get(userId).remove(notificationSender);
    }
    public void notifyAll(int userId,String message) {
        subscribedNotificationsPerUser.get(userId).forEach(notType -> notType.sendNotification(userId, message));
    }
}
