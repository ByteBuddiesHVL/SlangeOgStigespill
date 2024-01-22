package bytebuddies.hvl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlangeOgStigespillTest {

    @Test
    void testFlytt() {
        assertEquals(30,SlangeOgStigespill.flytt(28,2));
        assertEquals(98,SlangeOgStigespill.flytt(98,2));
        assertEquals(98,SlangeOgStigespill.flytt(95,3));
    }

    @Test
    void testSpill() {
        TerningI terning = new TerningI() {
            @Override
            public int trill() {
                return 6;
            }
        };
        Spiller spiller = new Spiller(0);
        SlangeOgStigespill.spill(spiller, terning);
        assertEquals(0, spiller.getRute());

        terning = new TerningI() {
            @Override
            public int trill() {
                return 4;
            }
        };

        spiller.setRute(0);

        for (int i = 0; i < 9; i++) {
            SlangeOgStigespill.spill(spiller, terning);
        }
        assertEquals(36, spiller.getRute()); // aktuell rute er 37
    }
}