
public class ZonalStragey implements ElevatorSelectionStrategy {

    @Override
    public int selectElevator(ExternalRequest externalRequest) {
       System.out.println("using ZONAL_ELECTION_STRATEGY for elevator");
       return 3;
    }
    
}
