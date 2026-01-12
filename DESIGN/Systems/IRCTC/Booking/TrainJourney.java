import java.util.Map;
public class TrainJourney {
    private Train train;
    private String dateOfJourney;
    private Map<String,SeatStatus> seatAvailabiltyMap;

    TrainJourney(Train train,String dateOfJourney) {
        this.train = train;
        this.dateOfJourney = dateOfJourney;
    }
    
}
