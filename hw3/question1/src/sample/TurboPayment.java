package sample;

/**
 * Old payment system that we want to replace
 */
public interface TurboPayment {
    /**
     * Payemnt method
     * @param turboCardNo card no
     * @param turboAmount amount of money
     * @param destinationTurboOfCourse destination
     * @param installmentsButInTurbo installment
     * @return
     */
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}
