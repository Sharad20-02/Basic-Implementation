import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedPlaylist {
    private List<String> playlist;
    private Lock lock;

    public SharedPlaylist() {
        playlist = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public void addSong(String song) {
        lock.lock();
        try {
            playlist.add(song);
            System.out.println("Added song: " + song);
        } finally {
            lock.unlock();
        }
    }

    public void removeSong(String song) {
        lock.lock();
        try {
            playlist.remove(song);
            System.out.println("Removed song: " + song);
        } finally {
            lock.unlock();
        }
    }

    public void printPlaylist() {
        lock.lock();
        try {
            System.out.println("Playlist:");
            for (String song : playlist) {
                System.out.println(song);
            }
        } finally {
            lock.unlock();
        }
    }
}

public class SynchronisationMechanism {
    public static void main(String[] args) {
        SharedPlaylist sharedPlaylist = new SharedPlaylist();

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedPlaylist.addSong("Song " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                sharedPlaylist.removeSong("Song " + i);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sharedPlaylist.printPlaylist();
    }
}
