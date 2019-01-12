public class SingletonCloneable implements Cloneable {
    private static SingletonCloneable uniqueInstance;
    private SingletonCloneable(){}
    public static  SingletonCloneable getUniqueInstance(){
        if(uniqueInstance == null){
            synchronized (SingletonCloneable.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new SingletonCloneable();
            }
        }
        return uniqueInstance;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

