class ElevatorController {
   private ElevatorState elevatorState;
   private ElevatorControlStrategy elevatorControlStrategy;
   ElevatorController() {
    elevatorState = new ElevatorState();
   }
   public void setCurrentFloor(int floor) {
    elevatorState.setCurrentFloor(floor);
   }
   public void moveElevatorToFloor(int floor) {

    elevatorControlStrategy = new FCFSStrategy();
    int nextStop = elevatorControlStrategy.determinNextStop(floor);
    if(nextStop > elevatorState.getCurrentFloor()) {
        elevatorState.setElevatorDirection(ElevatorDirection.UP);
    } else if(nextStop < elevatorState.getCurrentFloor()) {
        elevatorState.setElevatorDirection(ElevatorDirection.DOWN);
    }
    if(nextStop != elevatorState.getCurrentFloor()) {
        elevatorState.setElevatorStatus(ElevatorStatus.MOVING);
    }
   }
}
