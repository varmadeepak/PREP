import java.util.List;

public class Compartment {

    private CompartmentType compartmentType;
    private List<Seat> seats;

    // No-args constructor
    public Compartment() {
    }

    // All-args constructor
    public Compartment(CompartmentType compartmentType, List<Seat> seats) {
        this.compartmentType = compartmentType;
        this.seats = seats;
    }

    public CompartmentType getCompartmentType() {
        return compartmentType;
    }

    public void setCompartmentType(CompartmentType compartmentType) {
        this.compartmentType = compartmentType;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}