package sample;

public class PartLaser extends CustomizeTheSuit {
    ExoskeletonArmoredSuit exoskeletonArmoredSuit;
    public PartLaser(ExoskeletonArmoredSuit exoskeletonArmoredSuit) {
        this.exoskeletonArmoredSuit = exoskeletonArmoredSuit;
    }
    @Override
    public String getPart() {
        return exoskeletonArmoredSuit.getPart() + " + Flame Thrower";
    }

    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(200 + exoskeletonArmoredSuit.cost().getPrice() ,
                5.5 + exoskeletonArmoredSuit.cost().getWeight());
    }
}
