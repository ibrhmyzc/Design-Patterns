package sample;

public class PartAutoRifle extends CustomizeTheSuit {
    ExoskeletonArmoredSuit exoskeletonArmoredSuit;

    public PartAutoRifle(ExoskeletonArmoredSuit exoskeletonArmoredSuit) {
        this.exoskeletonArmoredSuit = exoskeletonArmoredSuit;
    }

    @Override
    public String getPart() {
        return exoskeletonArmoredSuit.getPart() + " + Auto Rifle";
    }

    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(30 + exoskeletonArmoredSuit.cost().getPrice() ,
                1.5 + exoskeletonArmoredSuit.cost().getWeight());
    }
}
