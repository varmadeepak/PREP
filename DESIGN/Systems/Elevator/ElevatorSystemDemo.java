public class ElevatorSystemDemo {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.getElevatorSystem();
        elevatorSystem.initializeElevatorSystem(4,2);
        elevatorSystem.setElevatorSelectionStrategy(new OddEvenStrategy());
        // process external request from 4th floor
        elevatorSystem.sendExternalRequest(3,ElevatorDirection.DOWN);

        // process internal request to go to 1st floor
        elevatorSystem.sendInternalRequest(1,1);
    }
}
