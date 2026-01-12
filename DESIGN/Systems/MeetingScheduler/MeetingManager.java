import java.util.Map;
import java.util.HashMap;

class MeetingManager {
    public static MeetingManager meetingManager = null;
    private Map<Integer,Meeting> meetings;
    private MeetingManager(){
        meetings = new HashMap<>();
    }
    public static MeetingManager getMeetingManager() {
        if(null == meetingManager) {
            meetingManager = new MeetingManager();
        }
        return meetingManager;
    }
    
    public Meeting getMeeting(int meetingId) {
        if(meetings.containsKey(meetingId)) {
            return meetings.get(meetingId);
        }
        return null;
    }
    public void addMeeting(int meetingId,Meeting meeting) {
        meetings.put(meetingId,meeting);
    }
}
