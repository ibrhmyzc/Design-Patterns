package sample;

public class PartFlameThrower extends CustomizeTheSuit {
    ExoskeletonArmoredSuit exoskeletonArmoredSuit;
    public PartFlameThrower(ExoskeletonArmoredSuit exoskeletonArmoredSuit) {
        this.exoskeletonArmoredSuit = exoskeletonArmoredSuit;
    }
    @Override
    public String getPart() {
        return exoskeletonArmoredSuit.getPart() + " + Flame Thrower";
    }

    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(50 + exoskeletonArmoredSuit.cost().getPrice() ,
                                    2 + exoskeletonArmoredSuit.cost().getWeight());
    }
}
