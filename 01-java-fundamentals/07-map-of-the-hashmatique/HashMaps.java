import java.util.HashMap;
import java.util.Set;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class HashMaps {
    public static void Songs() {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Whiskey Lallaby", "Then the willow sang a whiskey lallaby...");
        trackList.put("Something about a woman", "That's something about a woman...");
        trackList.put("What was I thinkin'?", "...And like a bullet we were gone again!");
        trackList.put("On the road again", "On the road again...");
        
        trackList.remove("On the road again");
        
        Set<String> keys = trackList.keySet();
        for(String key : keys){
            System.out.println(key + "| Song Lyrics: " + trackList.get(key));
        }

        
    }

    
}
