package bytebuddies.hvl;

public class Spiller {

    private int rute;
    private int nummer;

    public Spiller(int nummer) {
        this.nummer = nummer;
    }

    public void setRute(int nyRute) {
        rute = nyRute;
    }

    public int getRute() {
        return rute;
    }

    public int getNummer() {
        return nummer;
    }
}
