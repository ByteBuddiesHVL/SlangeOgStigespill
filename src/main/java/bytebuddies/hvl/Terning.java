package bytebuddies.hvl;

import java.util.Random;

public class Terning implements TerningI {

    Random rand = new Random();

    public int trill() {
         return rand.nextInt(6) + 1;
    }
}
