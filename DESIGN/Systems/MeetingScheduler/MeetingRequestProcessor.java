class MeetingRequestProcessor {
    private static MeetingRequestProcessor meetingRequestProcessor = null;

    private MeetingRequestProcessor(){}
    public static MeetingRequestProcessor getMeetingRequestProcessor() {
        if(null == meetingRequestProcessor) {
            meetingRequestProcessor = new MeetingRequestProcessor();
        }
        return meetingRequestProcessor;
    }
    public void scheduleMeeting(Meeting meeting) {
        // get user details
        // from user get calendar details
        // see if we can add any meeting
        User orgainzer = meeting.getOrganizer();
        if(canScheduleMeeting(orgainzer,meeting)) {
            int dayOfMeeting = meeting.getDayOfMeeting();
            int meetingId = meeting.getMeetingId();
            orgainzer.getCalendar().addMeeting(dayOfMeeting, meetingId);
            meeting.getParticipants().forEach(user -> 
                user.getCalendar().addMeeting(dayOfMeeting, meetingId)
            );
            // update meeting manager
            MeetingManager meetingManager = MeetingManager.getMeetingManager();
            meetingManager.addMeeting(meetingId, meeting);
            // send notification
            NotificationManager notificationManager = NotificationManager.getNotificationManager();
            meeting.getParticipants().forEach(user -> 
                notificationManager.notifyAll(user.getId(), "MEETING_SCHEDULED")
            );
        }

    }
    public boolean canScheduleMeeting(User organizer,Meeting meeting) {
        return true;
    }
}
