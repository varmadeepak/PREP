
public class Seat {
    private SeatType seatType;
    private String seatId;
    public Seat(String seatId) {
        this.seatId = seatId;
    }

    public void setSeatType(String seat) {
        if("LOWER".equals(seat)) {
           this.seatType = SeatType.LOWER;
        }
        else {
            this.seatType = SeatType.UPPER;
        }
    }
    public SeatType getSeatType() {
        return this.seatType;
    }
    public String getSeatID() {
        return this.seatId;
    }
}
