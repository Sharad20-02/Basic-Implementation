import java.util.HashMap;
import java.util.Map;

public class SoundexSearch {
    
    private static final Map<Character, Character> soundexMapping = createSoundexMapping();
    
    private static Map<Character, Character> createSoundexMapping() {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('b', '1');
        mapping.put('f', '1');
        mapping.put('p', '1');
        mapping.put('v', '1');
        mapping.put('c', '2');
        mapping.put('g', '2');
        mapping.put('j', '2');
        mapping.put('k', '2');
        mapping.put('q', '2');
        mapping.put('s', '2');
        mapping.put('x', '2');
        mapping.put('z', '2');
        mapping.put('d', '3');
        mapping.put('t', '3');
        mapping.put('l', '4');
        mapping.put('m', '5');
        mapping.put('n', '5');
        mapping.put('r', '6');
        return mapping;
    }
    
    public static String computeSoundex(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }
        
        word = word.toLowerCase();
        
        StringBuilder soundex = new StringBuilder();
        soundex.append(word.charAt(0));
        
        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            
            if ("aeiouhw".indexOf(current) != -1) {
                continue;
            }
            
            char mapped = soundexMapping.getOrDefault(current, '0');
            
            if (mapped != soundex.charAt(soundex.length() - 1)) {
                soundex.append(mapped);
            }
        }
        
        while (soundex.length() < 4) {
            soundex.append('0');
        }
        soundex.setLength(4);
        
        return soundex.toString();
    }
    
    public static void main(String[] args) {
        // Example usage
        String name1 = "smith";
		String name2 = "smeath";
		String name3 = "smooth";
        
        System.out.println(computeSoundex(name1));
		System.out.println(computeSoundex(name2));
		System.out.println(computeSoundex(name3));
    }
}
