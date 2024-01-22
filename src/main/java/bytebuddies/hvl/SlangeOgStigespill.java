package bytebuddies.hvl;

import java.util.Scanner;

public class SlangeOgStigespill {

    private static Brett brett = new Brett();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int antallSpillere = 0;
        System.out.println("Velkommen til stigespillet! Velg mellom 2 og 4 spillere.");
        while (true) {
            System.out.print("Antall spillere: ");
            try {
                antallSpillere = Integer.parseInt(scanner.nextLine());
                if (antallSpillere < 5 && antallSpillere > 1) break;
            } catch (Exception e) {
                System.out.println("Prøv igjen");
            }
        }

        Spiller[] spillere = new Spiller[antallSpillere];
        for (int i = 0; i < antallSpillere; i++) spillere[i] = new Spiller(i + 1);

        int teller = 0;

        Terning terning = new Terning();

        while (true) {
            Spiller spiller = spillere[teller++ % antallSpillere];
            System.out.println();
            spill(spiller, terning);

            if (spiller.getRute() == 99) {
                System.out.println("Spiller " + spiller.getNummer() + " har vunnet spillet!");
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * @param posisjon Den gamle posisjonen til spilleren
     * @param terningkast Terningkastet til spilleren
     * @return Den nye posisjonen til spilleren. Kan være på en stige eller en slange
     */
    public static int flytt(int posisjon, int terningkast) {
        if (posisjon + terningkast > 99) return 198 - terningkast - posisjon;
        return posisjon += terningkast;
    }

    /**
     * Triller terniningen og flytter spilleren.
     * Hvis terningen viser 6, får spilleren trille på nytt.
     * Blir det trillet seks 3 ganger på rad, blir spilleren flyttet tilbake til start
     * @param spiller Spilleren som skal spille
     * @param terning Terningen spilleren skal bruke
     */
    public static void spill(Spiller spiller, TerningI terning) {
        int nummer = spiller.getNummer();
        int teller = 0;
        while (true) {
            int kast = terning.trill();
            int rute = flytt(spiller.getRute(), kast);
            int slangeEllerStige = brett.slangeEllerStige(rute);

            System.out.println("Spiller " + nummer + " trillet " + kast);

            if (slangeEllerStige != 0) {
                if (slangeEllerStige > 0) {
                    System.out.println("Hurra! Spiller " + nummer + " landet på en stige og er nå på rute " + (rute + 1));
                } else {
                    System.out.println("Å nei! Spiller " + nummer + " landet på en slange og er nå på rute " + (rute + 1));
                }
            }

            spiller.setRute(rute += slangeEllerStige);
            System.out.println("Spiller " + nummer + " er nå på rute " + (rute + 1));

            if (kast != 6) break;

            if (++teller == 3) {
                System.out.println("Spiller " + nummer + " trillet 3 seksere på rad og må begynne på nytt.");
                spiller.setRute(0);
                break;
            }
            System.out.println("Spiller " + nummer + " får trille igjen");
        }
    }
}
