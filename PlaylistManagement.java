import java.util.LinkedList;

public class PlaylistManagement{

    public static class Song{
        int id;
        String name;
        String artist;
        float duration;

        Song(int id, String name, String artist, float duration){
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
        LinkedList<Song> playlist = new LinkedList<>();
        Song song1 = new Song(1, "Name1", "artist1", 3.4f);
        Song song2 = new Song(2, "Name2", "artist2", 4.5f);
        Song song3 = new Song(3, "Name3", "artist3", 2.5f);
        Song song4 = new Song(4, "Name4", "artist4", 3.7f);

        addSongToPlaylist(song1, playlist);
        addSongToPlaylist(song2, playlist);

        removeSongFromPlaylist(song4, playlist);
        removeSongFromPlaylist(song1, playlist);

        addSongToPlaylist(song2, playlist);
    }

    public static void addSongToPlaylist(Song song, LinkedList<Song> playlist){
        if(playlist.contains(song)){
            System.out.println("Song" + song.getSongName() + " already in playlist!");
            return;
        }
        playlist.addLast(song);
        System.out.println("Song " + song.getSongName() + " added successfully");
    }

    public static void removeSongFromPlaylist(Song song, LinkedList<Song> playlist){
        if(!playlist.contains(song)){
            System.out.println("Song"+ song.getSongName() + " not in the playlist!");
            return;
        }
        playlist.remove(song);
        System.out.println("Song" + song.getSongName() + " removed successfully");
    }

}
