class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(int userId, String message) {
        System.out.println("SENDING EMAIL_NOTIFICATION for user : " + userId + "with message : " + message);
    }
    
}