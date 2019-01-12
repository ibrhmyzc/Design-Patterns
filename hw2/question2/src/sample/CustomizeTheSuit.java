package sample;

public abstract class CustomizeTheSuit extends ExoskeletonArmoredSuit {
    /**
     * Gets the wanted parts to implement in the suit and calculate new cost
     * and weight of the suit
     * @return
     */
    public abstract String getPart();
}
