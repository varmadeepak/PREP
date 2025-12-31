
public class ExternalRequestProcessor {
    private ElevatorSelectionStrategy elevatorSelectionStrategy;

    public ExternalRequestProcessor() {
        elevatorSelectionStrategy = new OddEvenStrategy();
    }
    public void setStrategy(ElevatorSelectionStrategy strategy) {
        elevatorSelectionStrategy = strategy;
    }
    public void processExternalRequest(ExternalRequest externalRequest) {
        int assignedElevatorId = elevatorSelectionStrategy.selectElevator(externalRequest);
        ElevatorManager elevatorManager = ElevatorManager.getElevatorManager();
        Elevator assignedElevator = elevatorManager.getElevator(assignedElevatorId);
        assignedElevator.moveToFloor(externalRequest.getSourceFloor());
    }
}
