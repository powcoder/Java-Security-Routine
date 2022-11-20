import java.util.*;
import java.util.stream.Collectors;

public class SecurityRoutine extends SecurityRoutineBase {

    /* Implement all the necessary methods here */

    /*
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        REMOVE THE MAIN FUNCTION BEFORE SUBMITTING TO THE AUTOGRADER
        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        The following main function is provided for simple debugging only

        Note: to enable assertions, you need to add the "-ea" flag to the
        VM options of SecurityRoutine's run configuration
     */
    public static void main(String[] args) {
        SecurityRoutine g = new SecurityRoutine();
        AreaBase areaZ = g.insertArea(new AreaBase("Z"));
        AreaBase areaA = g.insertArea(new AreaBase("A"));
        AreaBase areaB = g.insertArea(new AreaBase("B"));
        AreaBase areaC = g.insertArea(new AreaBase("C"));

        g.addOrder(areaZ, areaA);
        g.addOrder(areaA, areaB);
        g.addOrder(areaB, areaC);
        g.addOrder(areaA, areaC);
        List<AreaBase> t = g.calculateTotalOrder();

        assert t.stream()
                .map(AreaBase::getId)
                .collect(Collectors.toList()).equals(List.of("Z", "A", "B", "C"));
    }
}
