package sample;

public abstract class ExoskeletonArmoredSuit {
    String part = "vanilla armor";

    /**
     * Get part
     * @return
     */
    public String getPart(){
        return part;
    }

    /**
     * Calculates the price and the weight
     * @return
     */
    public abstract PriceAndWeight cost();
}
