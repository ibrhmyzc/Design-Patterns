package sample;

public class PriceAndWeight {
    private double price;
    private double weight;

    public PriceAndWeight(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    /**
     * Get price
     * @return price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * set Price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * get Weight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * sets weigth
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * To string method
     * @return desired output
     */
    public String toString() {
        return "Price:" + price + "K" + System.lineSeparator() +"Weight:" + weight + "kg";
    }
}
