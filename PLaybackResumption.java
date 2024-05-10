import java.util.HashMap;
import java.util.Map;

class PlaybackHistory {
    private Map<String, Integer> playbackPositions;

    public PlaybackHistory() {
        playbackPositions = new HashMap<>();
    }

    public void savePlaybackPosition(String userId, int position) {
        playbackPositions.put(userId, position);
        System.out.println("Playback position saved for user " + userId + ": " + position);
    }

    public int getPlaybackPosition(String userId) {
        return playbackPositions.getOrDefault(userId, 0);
    }
}

public class PlaybackResumption {
    public static void main(String[] args) {

        String userId = "user123";

        int playbackPosition = 120;

        PlaybackHistory playbackHistory = new PlaybackHistory();

        playbackHistory.savePlaybackPosition(userId, playbackPosition);

        int resumedPlaybackPosition = playbackHistory.getPlaybackPosition(userId);
        System.out.println("Resumed playback position for user " + userId + ": " + resumedPlaybackPosition);
    }
}
