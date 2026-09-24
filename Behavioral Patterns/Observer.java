
import java.util.ArrayList;
import java.util.List;

interface Subscriber {

    public void update();
}

interface Channel {

    public void addSubscriber(Subscriber s);

    public void removeSubscriber(Subscriber s);

    public void notifySubscriber();
}

class YoutubeSubscriber implements Subscriber {

    public void update() {
        System.out.println("Me " + this.hashCode() + " got the notification");
    }
}

class YoutubeChannel implements Channel {

    public List<Subscriber> subList;

    YoutubeChannel() {
        this.subList = new ArrayList<>();
    }

    public void addSubscriber(Subscriber s) {
        this.subList.add(s);
    }

    public void removeSubscriber(Subscriber s) {
        this.subList.remove(s);
    }

    public void notifySubscriber() {
        for (Subscriber s : subList) {
            s.update();
        }
    }
}

class Observer {

    public static void main(String[] jayesh) {
        Channel youtubeChannel = new YoutubeChannel();

        Subscriber sub1 = new YoutubeSubscriber();
        youtubeChannel.addSubscriber(sub1);
        youtubeChannel.notifySubscriber();

        Subscriber sub2 = new YoutubeSubscriber();
        youtubeChannel.addSubscriber(sub2);

        youtubeChannel.removeSubscriber(sub1);
        youtubeChannel.notifySubscriber();
    }
}
