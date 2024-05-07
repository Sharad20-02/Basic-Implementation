import java.util.Arrays;
import java.util.Scanner;

public class LevenshteinDistance{

    public static class ArtistDistance implements Comparable<ArtistDistance>{
        String artist;
        int distance;

        public int compareTo(ArtistDistance other){
            return Integer.compare(this.distance, other.distance);
        }   
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] artists = {
                    "Weeknd",
                    "Who",
                    "Whoop",
                    "Whoa",
                    "WhiteStripes",
                    "WildFeathers",
                    "Wombats",
                    "Wonders",
                    "WoodBrothers",
                    "WorldIsNotFlat",
                    "WeatherGirls",
                    "Weepies",
                    "WayneKramers",
                    "Waterboys",
                    "Walkmen",
                    "Wailers",
                    "Waitresses",
                    "Vines",
                    "Vianna",
                    "Verve",
                    "VelvetUnderground",
                    "Vaselines",
                    "Used",
                    "Unicorns",
                    "TwilightSad",
                    "Turtles",
                    "TurboA.C.s",
                    "TravellingWilburys",
                    "Trashmen"
                };

        String s1;

        while(true){
            System.out.println("1 - Search");
            System.out.println("0 - Exit");
            int choice = scn.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter String: ");
                    scn.nextLine();
                    s1 = scn.nextLine();
                    relatedSearches(s1, artists);
                    System.out.println("Related Searches: ");
                    break;
                default:
                    return;
            }
        }
    }

    public static void relatedSearches(String s1, String[] artists){
        ArtistDistance[] arr = new ArtistDistance[artists.length];
        for(int i=0; i<artists.length; i++){
            int distance = getDistance(s1, artists[i]);
            arr[i] = new ArtistDistance();
            arr[i].distance = distance;
            arr[i].artist = artists[i];
        }
        Arrays.sort(arr);
        printArtists(arr);
    }

    public static void printArtists(ArtistDistance[] arr){
        for(int i=0; i<5; i++){
            System.out.println(arr[i].artist + "  " + arr[i].distance);
        }
    }

    public static int getDistance(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    if(s1.charAt(i-1) == s2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}