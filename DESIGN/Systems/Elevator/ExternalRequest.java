
public class ExternalRequest {
    private ElevatorDirection elevatorDirection;
    private int sourceFloor;

    public ExternalRequest(ElevatorDirection elevatorDirection,int sourceFloor) {
        this.elevatorDirection = elevatorDirection;
        this.sourceFloor = sourceFloor;
    }

    public ElevatorDirection getDirection() {
        return elevatorDirection;
    }
    public void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }
    public int getSourceFloor() {
        return sourceFloor;
    }
    public void setSourceFloor(int floor) {
        sourceFloor = floor;
    }
}
