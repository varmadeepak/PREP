
public class InternalRequestProcessor {
    public void processInternalRequest(InternalRequest internalRequest) {
        ElevatorManager elevatorManager = ElevatorManager.getElevatorManager();
        Elevator sourcElevator = elevatorManager.getElevator(internalRequest.getElevatorId());
        sourcElevator.moveToFloor(internalRequest.getDestinationFloor());
    }
}
