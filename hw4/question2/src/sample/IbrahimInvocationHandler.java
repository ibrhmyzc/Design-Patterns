package sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IbrahimInvocationHandler<T> implements InvocationHandler {
    private RegisterWallet registerWallet;
    private IbrahimsGraph ibrahimGraph;
    private final double costOfAnOperation = 10.0;
    private float MILLION = 1000000f;

    public IbrahimInvocationHandler(IbrahimsGraph<T> ibrahimGraph, RegisterWallet registerWallet) {
        this.registerWallet = registerWallet;
        this.ibrahimGraph = ibrahimGraph;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException, OutOfMoneyException {

        // starts
        Long start = System.nanoTime();
        Wallet wallet = (Wallet) args[1];

        registerWallet.changeBalance(wallet, costOfAnOperation);

        if(registerWallet.getBalance(wallet) < 0) {
            System.out.println("You are out of money");
            throw new OutOfMoneyException("you are out of money :D");
        }


        System.out.println(method.getName()
                + " started at "
                + new SimpleDateFormat("hh:mm:ss").format(new Date())
                + " Account:" + wallet.getClientId()
                + " Balance:"
                + registerWallet.getBalance(wallet));

        Object object = method.invoke(ibrahimGraph, args);


//        int simulateTime = 0;
//        try {
//            Random r = new Random();
//            simulateTime = r.nextInt(3) + 2;
//            Thread.sleep(simulateTime * 1000);
//        } catch(Exception e) {
//            System.out.println("thread sleep error :(");
//        }

        // finishes
        Long finish = System.nanoTime();

        float totalTime = (finish - start) / MILLION;

        System.out.println(method.getName() +" Operation that is served to client: " + wallet.getClientId()
                + " took " + totalTime + " ms");
        return object;
    }
}

