public class SingletonSubclass extends Parent{
    private static SingletonSubclass uniqueInstance;
    private SingletonSubclass(){}
    public static  SingletonSubclass getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (SingletonSubclass.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new SingletonSubclass();
            }
        }
        return uniqueInstance;
    }
}
