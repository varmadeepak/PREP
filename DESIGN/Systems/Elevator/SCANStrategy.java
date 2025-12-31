
public class SCANStrategy implements ElevatorControlStrategy {

    @Override
    public int determinNextStop(int floor) {
        System.out.println("SCAN STRATEGY , moving elevator to floor : " + floor);
        return 2;
    }
    
}
