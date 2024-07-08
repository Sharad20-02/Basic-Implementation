public class MergeSort{
    public static void main(String[] args) {
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
            "Wish You Were Here",
            "Highway to Hell",
            "Sweet Child o' Mine",
            "Under the Bridge",
            "Livin' on a Prayer",
            "Every Breath You Take",
            "Don't Stop Believin'",
            "My Way",
            "Stand by Me",
            "Despacito",
            "Radioactive",
            "Eye of the Tiger",
            "All Star",
            "We Will Rock You",
            "I Will Always Love You",
            "I Want to Hold Your Hand",
            "Imagine",
            "Sweet Home Alabama",
            "Let It Be",
            "Angie",
            "Purple Haze",
            "The Sound of Silence",
            "Comfortably Numb",
            "Hotel California",
            "Like a Rolling Stone",
            "Every Rose Has Its Thorn",
            "Bohemian Rhapsody",
            "Hotel California",
            "Smells Like Teen Spirit",
            "Satisfaction",
            "In the Air Tonight",
            "Another Brick in the Wall",
            "Bridge Over Troubled Water",
            "You've Lost That Lovin' Feelin'",
            "Dancing Queen",
            "Billie Jean",
            "Every Breath You Take",
            "I Will Always Love You",
            "Bohemian Rhapsody",
            "Imagine"
        };
        mergeSort(0, songs.length-1, songs);
        System.out.println("Sorted array is :");
        printSongs(songs);

    }

    public static void merge(int l, int r, int mid, String[] songs){
        int n1 = mid - l + 1;
        int n2 = r - mid;

        String[] left = new String[n1];
        String[] right = new String[n2];

        for(int i=0; i<n1; i++){
            left[i] = songs[l + i];
        }
        for(int j=0; j<n2; j++){
            right[j] = songs[mid + 1 +j];
        }

        int i=0, j=0;
        int k = l;

        while( i<n1 && j<n2){
            if(left[i].compareToIgnoreCase(right[j]) < 0){
                songs[k] = left[i];
                i++;
            }else{
                songs[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            songs[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            songs[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int l, int r, String[] songs){
        if(l>=r){
            return;
        }
        int mid = l + (r-l)/2;
        mergeSort(l, mid, songs);
        mergeSort(mid+1, r, songs);
        merge(l, r, mid, songs);
    }

    public static void printSongs(String[] songs){
        for(int i=0; i<songs.length; i++){
            System.out.println(songs[i]);
        }
    }
}
