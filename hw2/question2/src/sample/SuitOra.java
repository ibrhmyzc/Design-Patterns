package sample;

public class SuitOra extends ExoskeletonArmoredSuit {
    public SuitOra() {
        part = "Suit Ora";
    }
    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(1500, 30);
    }
}
