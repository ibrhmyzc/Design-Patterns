
public class Subscriber implements Observer {
    private Newspaper w = new Newspaper();
    private String name;
    private String text;
    private String photo;
    private String audio;

    /**
     * Constructor for the class
     * @param w newsapper object
     * @param name name of the subscriber
     */
    public Subscriber(Newspaper w, String name){
        this.w = w;
        this.name = name;
        w.add(this);
    }

    @Override
    public void update() {
        text = w.getText();
        photo = w.getPhoto();
        audio = w.getAudio();
        display();
    }

    /**
     * Displays the new content
     */
    public void display(){
        System.out.println("Hey " + name + "! What you are looking for is updated." + text);
        System.out.println("Hey " + name + "! What you are looking for is updated." + photo);
        System.out.println("Hey " + name + "! What you are looking for is updated." + audio);
    }
}
