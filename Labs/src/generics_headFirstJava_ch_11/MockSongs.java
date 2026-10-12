package generics_headFirstJava_ch_11;

import java.util.ArrayList;
import java.util.List;

public class MockSongs {
    //method static because class doesn't have any instance fields and need any.
    public static List<String> getSongStrings() {
        //because ArrayList is-a List we can create an arrayList
        // store it in a List and return List
        //often you will see code that returns the interface type.
        List<String> songs = new ArrayList<>();
        songs.add("somersault");
        songs.add("cassidy");
        songs.add("$10");
        songs.add("havana");
        return songs;
    }

    public static List<SongV2> getSongStringsV2(){
        List <SongV2> songs = new ArrayList<>();
        songs.add(new SongV2("somersault", "zero 7", 147));
        songs.add(new SongV2("cassidy", "oasis", 147));
        songs.add(new SongV2("Snow", "RHCP", 147));
        songs.add(new SongV2("$10 Cowboy", "Charley Crockett", 147));

        return songs;
    }



}
