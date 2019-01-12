public class Singleton {
    private static Singleton uniqueInstance;
    private Singleton(){}
    public static  Singleton getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (Singleton.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }
    public void callClone() throws CloneNotSupportedException {
        System.out.println(super.clone());
    }
}
