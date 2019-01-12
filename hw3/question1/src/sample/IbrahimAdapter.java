package sample;

/**
 * Ibrahim adapter
 */
public class IbrahimAdapter implements TurboPayment {
    ModernPayment modernPayment;

    public IbrahimAdapter(ModernPayment modernPayment) {
        this.modernPayment = modernPayment;
    }

    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return modernPayment.pay(turboCardNo, turboAmount, destinationTurboOfCourse, installmentsButInTurbo);
    }
}
