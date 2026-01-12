import java.util.List;

class MeetingSchedulerDemo {
    public static void main(String[] args) {
        User orgainzer = new User(1,"Deepak");
        User participant1 = new User(2, "PARTICIPANT_1");
        User participant2 = new User(3, "PARTICIPANT_2");

        List<User> participants = List.of(participant1,participant2);
       String meetingTitle = "Deepak/1-1";
       String meetingDesc = "One To One meeting";
       String meetingStartTime = "10:30 AM";
       String meetingEndTime = "11:00 AM";


       NotificationManager notificationManager = NotificationManager.getNotificationManager();
       notificationManager.subscribeToNotificationType(2, new SMSNotificationSender());
       notificationManager.subscribeToNotificationType(2, new EmailNotificationSender());
       notificationManager.subscribeToNotificationType(3, new SMSNotificationSender());

        Meeting meeting = 
            new Meeting(123,meetingTitle,meetingDesc,meetingStartTime,meetingEndTime,true,participants,orgainzer,10);
        MeetingSchedulerSystem meetingSchedulerSystem = MeetingSchedulerSystem.gMeetingSchedulerSystem();
        if(meetingSchedulerSystem.scheduleMeeting(meeting)) {
            System.out.println("MEETING with id : " + 123 + "SCHEDULED SUCCESSFULLY");
        } 
        participant1.displayCalendar(10);
    }
}