package sample;

public interface ModernPayment {
    /**
     *
     * @param cardNo card no
     * @param amount amount of money
     * @param destination destination
     * @param installments installment
     * @return
     */
    int pay(String cardNo, float amount, String destination, String installments);
}
