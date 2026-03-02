import java.util.HashMap;
import java.util.Map;

interface VideoServiceInterface {
    void playVideo(String userType, String videoName);
}

class RealVideoService implements VideoServiceInterface {
    @Override
    public void playVideo(String userType, String videoName) {
        System.out.println("Streaming video: " + videoName);
    }
}

class ProxyVideoService implements VideoServiceInterface {
    private RealVideoService realVideoService;
    private Map<String, String> cachedVideos = new HashMap<>();
    private Map<String, Integer> requestCounts = new HashMap<>();

    public ProxyVideoService(RealVideoService realVideoService) {
        this.realVideoService = realVideoService;
    }

    @Override
    public void playVideo(String userType, String videoName) {
        if (!userType.equals("premium") && videoName.startsWith("Premium")) {
            System.out.println(
                    "Access denied: Premium video requires a premium account.");
            return;
        }

        requestCounts.put(userType, requestCounts.getOrDefault(userType, 0) + 1);
        if (requestCounts.get(userType) > 5) {
            System.out.println("Access denied: Too many requests.");
            return;
        }

        if (cachedVideos.containsKey(videoName)) {
            System.out.println("Streaming cached video: " + videoName);
        } else {
            realVideoService.playVideo(userType, videoName);
            cachedVideos.put(videoName, videoName);
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        RealVideoService realService = new RealVideoService();
        ProxyVideoService proxyService = new ProxyVideoService(realService);

        proxyService.playVideo("free", "Video-1");
        proxyService.playVideo("premium", "Video-1");
        proxyService.playVideo("guest", "video-1");

        for (int i = 0; i < 10; i++) {
            proxyService.playVideo("free", "Video-2");
        }
    }
}