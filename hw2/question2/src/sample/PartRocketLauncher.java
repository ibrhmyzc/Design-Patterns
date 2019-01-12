package sample;

public class PartRocketLauncher extends CustomizeTheSuit {
    ExoskeletonArmoredSuit exoskeletonArmoredSuit;

    public PartRocketLauncher(ExoskeletonArmoredSuit exoskeletonArmoredSuit) {
        this.exoskeletonArmoredSuit = exoskeletonArmoredSuit;
    }

    @Override
    public String getPart() {
        return exoskeletonArmoredSuit.getPart() + " + Rocket Launcher";
    }

    @Override
    public PriceAndWeight cost() {
        return new PriceAndWeight(150 + exoskeletonArmoredSuit.cost().getPrice() ,
                7.5 + exoskeletonArmoredSuit.cost().getWeight());
    }
}
