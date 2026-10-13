
class AudioPlayer {

    public void initializeDrivers() {
        System.out.println("Initializing the Audio driver");
    }

    public void decodeAudio() {
        System.out.println("Decoding the audio");
    }

    public void startPlayback() {
        System.out.println("Starting the playback");
    }

}

class ImageViewer {

    public void loadImage() {
        System.out.println("Loading the image");
    }

    public void applyScaling() {
        System.out.println("Applying the scale");
    }

    public void displayImage() {
        System.out.println("Currently Displaying the image");
    }
}

class MediaFacade {

    private final AudioPlayer audioPlayer;
    private final ImageViewer imageViewer;

    MediaFacade() {
        this.audioPlayer = new AudioPlayer();
        this.imageViewer = new ImageViewer();
    }

    public void performAction(String req) {
        switch (req) {
            case "playaudio":
                this.audioPlayer.initializeDrivers();
                this.audioPlayer.decodeAudio();
                this.audioPlayer.startPlayback();
                break;
            case "showimage":
                this.imageViewer.loadImage();
                this.imageViewer.applyScaling();
                this.imageViewer.displayImage();
                break;
            default:
                System.out.println("unrecognized request");
        }
    }
}

class Facade {

    public static void main(String[] jayesh) {
        MediaFacade mediaFacade = new MediaFacade();
        mediaFacade.performAction("playaudio");
        mediaFacade.performAction("showimage");
        mediaFacade.performAction("anything");
    }
}
