import java.util.Random;
import java.util.Scanner;

public class FisherYatesShuffleAlgorithm{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] songs = {
            "Bohemian Rhapsody",
            "Hotel California",
            "Stairway to Heaven",
            "Imagine",
            "Yesterday",
            "Smells Like Teen Spirit",
            "Like a Rolling Stone",
            "Hey Jude",
            "Let It Be",
            "Hallelujah",
            "Thriller",
            "Billie Jean",
            "Shape of You",
            "Someone Like You",
            "Wonderwall",
        };
        
        while(true){
            System.out.println("\n1 - Shuffle");
            System.out.println("0 - Exit");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    shuffle(songs);
                    System.out.println("Shuffled Songs: ");
                    printSongs(songs);
                    break;

                default:
                    return;
            }
        }
    }

    public static void shuffle(String[] songs){
        Random r = new Random();

        for(int i=songs.length-1; i>0; i--){
            int randomIndex = r.nextInt(i+1);

            String temp = songs[i];
            songs[i] = songs[randomIndex];
            songs[randomIndex] = temp;
        }
    }

    public static void printSongs(String[] songs){
        for(int i=0; i<songs.length; i++){
            System.out.println(songs[i]);
        }
    }
}