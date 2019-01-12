package sample;

public class SuitDec extends ExoskeletonArmoredSuit {
    public SuitDec() {
        part = "Suit Dec";
    }
    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(500, 25);
    }
}
