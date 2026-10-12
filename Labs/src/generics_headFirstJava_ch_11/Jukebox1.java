package generics_headFirstJava_ch_11;

import java.util.Collections;
import java.util.List;

public class Jukebox1 {

    static void main() {
        new Jukebox1().go();

    }

    public void go() {
        List<String> songList = MockSongs.getSongStrings();
        Collections.sort(songList);
        System.out.println(songList);
        
    }
}
