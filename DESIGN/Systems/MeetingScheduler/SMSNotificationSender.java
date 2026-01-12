class SMSNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(int userId, String message) {
        System.out.println("SENDING SMS_NOTIFICATION for user : " + userId + "with message : " + message);
    }
    
}
