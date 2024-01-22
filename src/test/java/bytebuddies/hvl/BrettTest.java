package bytebuddies.hvl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrettTest {

    @Test
    void slangeEllerStige() {
        Brett b = new Brett();

        assertEquals(17,b.slangeEllerStige(61));
        assertEquals(-3,b.slangeEllerStige(30));
    }
}