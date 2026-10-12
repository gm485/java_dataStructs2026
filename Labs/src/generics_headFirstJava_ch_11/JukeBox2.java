package generics_headFirstJava_ch_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JukeBox2 {


    static void main() {
        new JukeBox2().go();
    }

    public void go() {

        List<SongV2> songList = MockSongs.getSongStringsV2();
        System.out.println("Song List: " + songList);

        Collections.sort(songList);
        System.out.println("Song List: " + songList);
    }


}
