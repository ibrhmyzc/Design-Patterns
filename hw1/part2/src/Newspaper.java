import java.util.ArrayList;

public class Newspaper implements Subject {

    private ArrayList<Observer> observers;
    private String text;
    private String photo;
    private String audio;

    public Newspaper() {
        observers = new ArrayList<>();
    }

    /**
     * adds a new subscriber
     * @param o new subscriber-
     */
    @Override
    public void add(Observer o) {
        observers.add(o);
    }

    /**
     * removes a new subscriber
     * @param o new subscriber-
     */
    @Override
    public void remove(Observer o) {
    int i = observers.indexOf(o);
        if(i >= 0 )
            observers.remove(i);
    }

    /**
     * notify all subscrivers about the change
     */
    @Override
    public void notifyObservers() {
        for(Observer ob : this.observers)
            ob.update();
    }

    /**
     * Stores the new content
     * @param text new text
     * @param photo new photo
     * @param audio new audio
     */
    public void newContent(String text, String photo, String audio) {
        this.text = text;
        this.photo = photo;
        this.audio = audio;
        notifyObservers();
    }

    /**
     * setter for new text
     * @param text new text
     */
    public void setText(String text){
        this.text = text;
        notifyObservers();
    }

    /**
     * setter for new photo
     * @param photo new photo
     */
    public void setPhoto(String photo){
        this.photo = photo;
        notifyObservers();
    }

    /**
     * setter for new audio
     * @param audio new audio
     */
    public void setAudio(String audio){
        this.audio = audio;
        notifyObservers();
    }

    /**
     * returns new text
     * @return text
     */
    public String getText(){
        return text;
    }

    /**
     * returns new photo
     * @return new photo
     */
    public String getPhoto(){
        return photo;
    }

    /**
     * returns new audio
     * @return new audio
     */
    public String getAudio(){
        return audio;
    }

}
