
interface VideoServiceInterface {

    public void playVideo(String video);
}

class VideoServiceImpl implements VideoServiceInterface {

    public void playVideo(String video) {
        System.out.println("Playing the Video :" + video);
    }
}

class GatekeeperVideoService {

    private final VideoServiceImpl videoServiceImpl;

    GatekeeperVideoService() {
        this.videoServiceImpl = new VideoServiceImpl();
    }

    public void playVideo(String user, String video) {
        if (video.startsWith("premium")) {
            if (!user.startsWith("premium")) {
                System.out.println("Access Denied");
                return;

            }
        }
        videoServiceImpl.playVideo(video);
    }
}

class Proxy {

    public static void main(String[] jayesh) {
        GatekeeperVideoService videoService = new GatekeeperVideoService();
        videoService.playVideo("normalUser", "normalVideo");
        videoService.playVideo("premiumUser", "premiumVideo");
        videoService.playVideo("normalUser", "premiumVideo");
    }
}
