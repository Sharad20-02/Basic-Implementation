import java.util.LinkedList;
import java.util.Queue;

public class QueueManagement {

    public static class Song {
        int id;
        String name;
        String artist;
        float duration;

        public Song(int id, String name, String artist, float duration) {
            this.id = id;
            this.name = name;
            this.artist = artist;
            this.duration = duration;
        }

        public String getSongName(){
            return this.name;
        }
    }

    public static void main(String[] args) {
        Queue<Song> songQueue = new LinkedList<>();

        Song song1 = new Song(1, "Song One", "Artist One", 3.5f);
        Song song2 = new Song(2, "Song Two", "Artist Two", 4.0f);
        Song song3 = new Song(3, "Song Three", "Artist Three", 2.8f);

        addSongToQueue(song1, songQueue);
        addSongToQueue(song2, songQueue);
        addSongToQueue(song3, songQueue);

        removeSongFromQueue(song3, songQueue);
    }

    public static void addSongToQueue(Song song, Queue<Song> queue) {
        queue.add(song);
        System.out.println("Song added to queue: " + song.getSongName());
    }

    public static void removeSongFromQueue(Song song, Queue<Song> queue) {
        if (queue.isEmpty()) {
            System.out.println("No songs in Queue");
        } else {
            queue.remove(song);
            System.out.println("Song removed from queue: " + song.getSongName());
        }
    }
}
