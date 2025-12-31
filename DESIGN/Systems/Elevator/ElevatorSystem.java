
public class ElevatorSystem {
    private int numberOfFloors;
    private int numberOfElevators;
    private static ElevatorSystem elevatorSystem;
    private ExternalRequestProcessor externalRequestProcessor;
    private InternalRequestProcessor internalRequestProcessor;

    private ElevatorSystem() {}
    // SINGELTON
    public static ElevatorSystem getElevatorSystem() {
        if(null == elevatorSystem) {
            elevatorSystem =  new ElevatorSystem();
        }
        return elevatorSystem;
    }

    public void initializeElevatorSystem(int nOfFloors,int nOfElevators) {
        numberOfFloors = nOfFloors;
        numberOfElevators = nOfElevators;

        System.out.println("Initializing elevator system with " + nOfFloors + " floors and " + nOfElevators + " elevators!");
        System.out.println("--------------------------------------------------------");

        ElevatorManager elevatorManager = ElevatorManager.getElevatorManager();
        elevatorManager.initializeElevators(nOfElevators);
        externalRequestProcessor = new ExternalRequestProcessor();
        internalRequestProcessor = new InternalRequestProcessor();
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy){
        externalRequestProcessor.setStrategy(elevatorSelectionStrategy);
    }
    public void sendExternalRequest(int sourceFloor,ElevatorDirection elevatorDirection) {
        externalRequestProcessor.processExternalRequest(new ExternalRequest(elevatorDirection, sourceFloor));
    }
    public void sendInternalRequest(int destinationFloor,int elevatorId) {
        internalRequestProcessor.processInternalRequest(new InternalRequest(destinationFloor, elevatorId));
    }
} 
