package bytebuddies.hvl;

public class Brett {

    private static int[] ruter = new int[100];

    public Brett() {
        ruter[17] = 19;
        ruter[30] = -3;
        ruter[47] = 19;
        ruter[56] = -22;
        ruter[61] = 17;
        ruter[69] = 19;
        ruter[84] = -22;
        ruter[97] = -16;
    }

    /**
     * @param rute Ruten til spilleren.
     * @return Hvor mange ruter spilleren må flytte pga. en slage/stige.
     */
    public int slangeEllerStige(int rute) {
        return ruter[rute];
    }

}
