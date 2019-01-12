public class Main {
    public static void main(String[] args) {
        Newspaper gebze_times = new Newspaper();

        Subscriber ibrahim = new Subscriber(gebze_times, "ibrahim");
        Subscriber adelheid = new Subscriber(gebze_times, "adelheid");

        String text = "article about the amazon jungle";
        String photo = "breathtaking photos of norwegian fjords";
        String audio = "die toten hosens new album";

        gebze_times.newContent(text, photo, audio);
    }
}
