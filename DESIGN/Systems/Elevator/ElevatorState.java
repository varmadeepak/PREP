
class ElevatorState {
    private ElevatorStatus elevatorStatus;
    private int currentFloor;
    private ElevatorDirection elevatorDirection;
    ElevatorState() {
        currentFloor = 0;
        elevatorStatus = ElevatorStatus.IDLE;
        elevatorDirection = ElevatorDirection.IDLE;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int floor) {
        currentFloor = floor;
    }
    public ElevatorStatus getCurrentStatus() {
        return elevatorStatus;
    }
    public void setElevatorStatus(ElevatorStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public ElevatorDirection getCurrentDirection() {
        return elevatorDirection;
    }
    public void setElevatorDirection(ElevatorDirection elevatorDirection) {
        this.elevatorDirection = elevatorDirection;
    }
}
