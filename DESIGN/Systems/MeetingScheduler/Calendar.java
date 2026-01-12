import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Calendar {
    private Map<Integer,List<Integer>> meetingsList;

    public Calendar() {
        meetingsList = new HashMap<>();
    }

    public void addMeeting(int day,int meetingId) {
        if(!meetingsList.containsKey(day)) {
            meetingsList.put(day,new ArrayList<>());
        }
        meetingsList.get(day).add(meetingId);
    }
    public List<Integer> getMeetingsForDay(int day) {
        if(meetingsList.containsKey(day)) {
            return meetingsList.get(day);
        }
        return new ArrayList<>();
    }

    public void display(int day) {
        if(!meetingsList.containsKey(day)) {
            System.out.println("NO_MEETINGS");
        }
        meetingsList.get(day).forEach(meetingId -> {
            MeetingManager meetingManager = MeetingManager.getMeetingManager();
            Meeting meeting = meetingManager.getMeeting(meetingId);
            meeting.display();
        });
    }
}
