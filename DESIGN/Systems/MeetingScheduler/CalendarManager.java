import java.util.Map;
import java.util.HashMap;

class CalendarManager {
    private Map<String,Calendar> calendars;

    public CalendarManager() {
        calendars = new HashMap<>();
    }
    public Calendar getCalendarForUser(String userName) { 
        // If the user has a calendar, return it; otherwise, create a new one and return it
        return calendars.computeIfAbsent(userName,key -> new Calendar());
    }
}
