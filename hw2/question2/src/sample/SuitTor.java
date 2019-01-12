package sample;

public class SuitTor extends ExoskeletonArmoredSuit {
    public SuitTor() {
        part = "Suit Tor";
    }
    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(5000, 50);
    }
}
