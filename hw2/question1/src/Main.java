import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

public class Main {
    public static void main(String[] args) {

        Singleton singleton  = Singleton.getUniqueInstance();
        // now we have a unique singleton object
        System.out.println(singleton);
        // we call clone  without overriding clone method
        try{
            singleton.callClone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone without override is not supported");
        }


        System.out.println("\n**********************************************");
        // Here I use a new singleton class that implements Cloneable interface
        SingletonCloneable singletonCloneable = SingletonCloneable.getUniqueInstance();
        System.out.println(singletonCloneable);
        try{
            System.out.println( singletonCloneable.clone());
        } catch (CloneNotSupportedException ex) {
            System.out.println("Clone with override is not supported");
        }
        System.out.println("To prevent this, we throw CloneNotSupported exception");

        System.out.println("\n**********************************************");
        SingletonSubclass singletonSubclass = SingletonSubclass.getUniqueInstance();
        System.out.println(singletonSubclass);
        try{
            System.out.println(singletonSubclass.clone());
        } catch(CloneNotSupportedException ex){
            System.out.println("subclass singleton clone exception");
        }
    }
}
