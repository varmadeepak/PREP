import java.util.List;

public class Train {

    private String trainNumber;
    private String trainName;
    private List<String> stations;
    private List<String> arrivalTimes;
    private List<Compartment> compartments;

    // No-args constructor (important for frameworks)
    public Train() {
    }

    // All-args constructor
    public Train(String trainNumber,
                 String trainName,
                 List<String> stations,
                 List<String> arrivalTimes,
                 List<Compartment> compartments) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.stations = stations;
        this.arrivalTimes = arrivalTimes;
        this.compartments = compartments;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public List<String> getArrivalTimes() {
        return arrivalTimes;
    }

    public void setArrivalTimes(List<String> arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }

    public List<Compartment> getCompartments() {
        return compartments;
    }

    public void setCompartments(List<Compartment> compartments) {
        this.compartments = compartments;
    }
}