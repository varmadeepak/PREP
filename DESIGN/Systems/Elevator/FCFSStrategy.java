public class FCFSStrategy implements ElevatorControlStrategy {

    @Override
    public int determinNextStop(int floor) {
        System.out.println("FCFS STRATEGY , moving elevator to floor : " + floor);
        return 2;
    }
    
}
