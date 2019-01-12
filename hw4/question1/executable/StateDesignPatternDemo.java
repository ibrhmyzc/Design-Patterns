
/**
 * Demo program that shows most of the state changes
 */
public class StateDesignPatternDemo {

    /**
     * testGraduate
     */
    public void testGraduate() throws UnsupportedStateException{
        System.out.println("\n\ntestGraduate");

        try{
            IbrahimYazici ibrahimYazici = new IbrahimYazici();
            ibrahimYazici.outUntilLate();
            ibrahimYazici.hardworking();
            ibrahimYazici.coffeeAndWork();
        } catch(UnsupportedStateException e){
            System.out.println("Unsupported state change has been caught!" + " " + e.toString());
        }
    }

    /**
     * testFit
     */
    public void testFit() throws UnsupportedStateException{
        System.out.println("\n\ntestFit");

        try{
            IbrahimYazici ibrahimYazici = new IbrahimYazici();
            ibrahimYazici.exercise();
            ibrahimYazici.hardworking();
            ibrahimYazici.cheat();
        } catch(UnsupportedStateException e){
            System.out.println("Unsupported state change has been caught!" + " " + e.toString());
        }
    }

    /**
     * testReady
     */
    public void testReady() throws UnsupportedStateException{
        System.out.println("\n\ntestReady");

        try{
            IbrahimYazici ibrahimYazici = new IbrahimYazici();
            ibrahimYazici.outUntilLate();
            ibrahimYazici.sleep();
            ibrahimYazici.buyingAGtx1080();
        } catch(UnsupportedStateException e){
            System.out.println("Unsupported state change has been caught!" + " " + e.toString());
        }
    }

    /**
     * testNeedingSleep
     */
    public void testNeedingSleep() throws UnsupportedStateException{
        System.out.println("\n\ntestNeedingSleep");

        try{
            IbrahimYazici ibrahimYazici = new IbrahimYazici();
            ibrahimYazici.outUntilLate();
            ibrahimYazici.sleep();
            ibrahimYazici.cheat();
        } catch(UnsupportedStateException e){
            System.out.println("Unsupported state change has been caught!" + " " + e.toString());
        }
    }

    /**
     * testChronicIllness
     */
    public void testChronicIllness() throws UnsupportedStateException{
        System.out.println("\n\ntestChronicIllness");

        try{
            IbrahimYazici ibrahimYazici = new IbrahimYazici();
            ibrahimYazici.outUntilLate();
            ibrahimYazici.coffeeAndWork();
            ibrahimYazici.hardworking();
        } catch(UnsupportedStateException e){
            System.out.println("Unsupported state change has been caught!" + " " + e.toString());
        }
    }

    /**
     * testUnableToBecomeARodForAnAxe
     */
    public void testUnableToBecomeARodForAnAxe() throws UnsupportedStateException{
        System.out.println("\n\ntestUnableToBecomeARodForAnAxe");
        try{
            IbrahimYazici ibrahimYazici = new IbrahimYazici();
            ibrahimYazici.buyingAGtx1080();
            ibrahimYazici.coffeeAndWork();
        } catch(UnsupportedStateException e){
            System.out.println("Unsupported state change has been caught!" + " " + e.toString());
        }
    }
}
