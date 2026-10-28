package dsa_ch4_arrays;

public class TestScoreboard {
    static void main() {

        Scoreboard scoreboard = new Scoreboard(10);
        GameEntry entry1 = new GameEntry("gary", 10);
        GameEntry entry2 = new GameEntry("hollie", 3);
        GameEntry entry3 = new GameEntry("patrick", 5);
        GameEntry entry4 = new GameEntry("george", 4);

        scoreboard.add(entry1);
        scoreboard.add(entry2);
        scoreboard.add(entry3);
        scoreboard.add(entry4);
        scoreboard.display();
    }



}
