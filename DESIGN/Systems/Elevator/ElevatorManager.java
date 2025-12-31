import java.util.Map;
import java.util.HashMap;

public class ElevatorManager {
    private static ElevatorManager elevatorManager;
    Map<Integer,Elevator> elevators;

    private ElevatorManager() {
        elevators = new HashMap<>();
    }

    public static ElevatorManager getElevatorManager() {
        if(null == elevatorManager) {
            elevatorManager = new ElevatorManager();
        }
        return elevatorManager;
    }

    public void initializeElevators(int nOfElevators) {
       for(int idx=1; idx<=nOfElevators; idx++) {
         elevators.put(idx,new Elevator(idx));
       }
    }

    public Elevator getElevator(int elevatorId) {
        return elevators.get(elevatorId);
    }

}
