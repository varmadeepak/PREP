
public class OddEvenStrategy implements ElevatorSelectionStrategy {

    @Override
    public int selectElevator(ExternalRequest externalRequest) {
       System.out.print("using ODD_EVEN_STRATEGY and returning elevator with id : ");
       if(externalRequest.getSourceFloor() % 2 == 0) {
        System.out.println(2);
        return 2;
       }
       System.out.println(1);
       return 1;
    }
    
}
