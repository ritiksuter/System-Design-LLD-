import java.util.Scanner;

class MusicPlayer {
    public void initializeAudioDrivers() {
        System.out.println("Audio drivers initialized.");
    }

    public void decodeAudio() {
        System.out.println("Audio Decoded.");
    }

    public void startPlayback() {
        System.out.println("Music playback started.");
    }
}

class VideoPlayer {
    public void setupRenderingEngine() {
        System.out.println("Rendering engine set up.");
    }

    public void loadVideoFile() {
        System.out.println("Video file loaded.");
    }

    public void playVideo() {
        System.out.println("Video playback started.");
    }
}

class ImageViewer {
    public void loadImageFile() {
        System.out.println("Image file loaded.");
    }

    public void applyScaling() {
        System.out.println("Image scaled.");
    }

    public void displayImage() {
        System.out.println("Image displayed.");
    }
}

class MediaFascade {
    private MusicPlayer musicPlayer;
    private VideoPlayer videoPlayer;
    private ImageViewer imageViewer;

    public MediaFascade() {
        this.musicPlayer = new MusicPlayer();
        this.videoPlayer = new VideoPlayer();
        this.imageViewer = new ImageViewer();
    }

    public void performAction(String action) {
        switch (action.toLowerCase()) {
            case "playmusic":
                musicPlayer.initializeAudioDrivers();
                musicPlayer.decodeAudio();
                musicPlayer.startPlayback();
                break;
            case "playvideo":
                videoPlayer.setupRenderingEngine();
                videoPlayer.loadVideoFile();
                videoPlayer.playVideo();
                break;
            case "viewimage":
                imageViewer.loadImageFile();
                imageViewer.applyScaling();
                imageViewer.displayImage();
                break;
            default:
                System.out.println("Invalid action!");
        }
    }
}

public class FascadeDesign {
    public static void main(String[] args) {
        MediaFascade mediaFascade = new MediaFascade();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Multimedia App!");
        System.out.println("Choosing an action : PlayMusic, PlayVideo, ViewImage");
        String action = scanner.nextLine();
        mediaFascade.performAction(action);
        scanner.close();
    }
}