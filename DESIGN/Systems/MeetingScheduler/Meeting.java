import java.util.List;

public class Meeting {

    private int meetingId;
    private String meetingTitle;
    private String meetingDescription;
    private String meetingStartTime;
    private String meetingEndTime;
    private boolean isRecurring;
    private List<User> participants;
    private User organizer;
    private int dayOfMeeting;

    // No-args constructor
    public Meeting() {
    }

    // All-args constructor
    public Meeting(int meetingId,
                   String meetingTitle,
                   String meetingDescription,
                   String meetingStartTime,
                   String meetingEndTime,
                   boolean isRecurring,
                   List<User> participants,
                   User organizer,int dayOfMeeting) {
        this.meetingId = meetingId;
        this.meetingTitle = meetingTitle;
        this.meetingDescription = meetingDescription;
        this.meetingStartTime = meetingStartTime;
        this.meetingEndTime = meetingEndTime;
        this.isRecurring = isRecurring;
        this.participants = participants;
        this.organizer = organizer;
        this.dayOfMeeting = dayOfMeeting;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingDescription() {
        return meetingDescription;
    }

    public void setMeetingDescription(String meetingDescription) {
        this.meetingDescription = meetingDescription;
    }

    public String getMeetingStartTime() {
        return meetingStartTime;
    }

    public void setMeetingStartTime(String meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    public String getMeetingEndTime() {
        return meetingEndTime;
    }

    public void setMeetingEndTime(String meetingEndTime) {
        this.meetingEndTime = meetingEndTime;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
    public int getDayOfMeeting() {
        return dayOfMeeting;
    }
    public void setDayOfMeeting(int day) {
        dayOfMeeting = day;
    }
    public String getMeetingTitle() {
        return meetingTitle;
    }
    public void setMeetingTitle(String title) {
        meetingTitle = title;
    }
     public void display() {
        System.out.println("------------------------------------------");
        System.out.println("Meeting details for meeting id " + meetingId + " -");
        System.out.println("Subject - " + getMeetingTitle());
        System.out.println("Description - " + getMeetingDescription());
        System.out.println("Organiser - " + getOrganizer().getName());
        System.out.print("Participants - ");
        for (User user : participants) {
            System.out.print(user.getName() + " ");
        }
        System.out.println("\n------------------------------------------");
    }
}