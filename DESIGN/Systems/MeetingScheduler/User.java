public class User {
    private int id;
    private String name;
    private Calendar calendar;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.calendar = new Calendar();
    }

    public void displayCalendar(int day) {
        calendar.display(day);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Calendar getCalendar() {
        return calendar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}