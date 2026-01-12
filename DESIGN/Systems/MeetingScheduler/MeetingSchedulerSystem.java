class MeetingSchedulerSystem {
    private static MeetingSchedulerSystem meetingSchedulerSystem = null;

    private MeetingSchedulerSystem(){}

    public static MeetingSchedulerSystem gMeetingSchedulerSystem() {
        if(null == meetingSchedulerSystem) {
            meetingSchedulerSystem = new MeetingSchedulerSystem();
        }
        return meetingSchedulerSystem;
    }
    public boolean scheduleMeeting(Meeting meeting) {
        MeetingRequestProcessor meetingRequestProcessor = MeetingRequestProcessor.getMeetingRequestProcessor();
        meetingRequestProcessor.scheduleMeeting(meeting);
        return true;
    }
    public void updateMeeting() {
        //
    }
    public void cancelMeeting() {
        // cancel logic
        // notification logic
    }
}
