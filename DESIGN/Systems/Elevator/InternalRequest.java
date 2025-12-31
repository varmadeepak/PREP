
public class InternalRequest {
    private int destinationFloor;
    private int elevatorId;

    InternalRequest(int destinationFloor,int elevatorId) {
        this.destinationFloor = destinationFloor;
        this.elevatorId = elevatorId;
    }
    
    public int getDestinationFloor() {
        return destinationFloor;
    }
    public int getElevatorId() {
        return elevatorId;
    }
    public void setDestinationFloor(int floor) {
        destinationFloor = floor;
    }
    public void setElevatorId(int id) {
        elevatorId = id;
    }
}
