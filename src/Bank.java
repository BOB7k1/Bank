import java.util.Scanner;

public class Bank {
//attribut
    Kund kund1 = new Kund("Didrik");
    Kund kund2 = new Kund("William");

    public Bank() {
        kund1.insattning(500);
        kund2.insattning(300);
        meny();
    }

    public Kund[] getAllCustomers() {
        return new Kund[]{kund1, kund2};
    }

    public void meny(){

        /* _____________För att logga in____________________ */
        Scanner scan = new Scanner(System.in);
        Kund[] kunder = getAllCustomers();

        for (int i = 0; i < kunder.length; i++) {
            System.out.println((i + 1) + ": " + kunder[i].getName());
        }

        int choice;

        while (true) {
            try {
                System.out.print("Vilken kund vill du logga in som? ");
                choice = scan.nextInt();

                if (choice > 0 && choice <= kunder.length) {
                    break;
                } else {
                    System.out.println("Du kan bara skriva tal mellan 1 till " + kunder.length);
                }

            } catch (Exception e) {
                System.out.println("Du kan bara skriva tal mellan 1 till " + kunder.length);
                scan.nextLine();
            }
        }

        Kund user = kunder[choice - 1];
        System.out.println("You are logged in as " + user.getName());

        /* _____________________________________________________________________ */

        System.out.println("Vad vill du göra?");
        System.out.println("1: Visa saldo");
        System.out.println("2: Sätta in pengar");
        System.out.println("3. Ta ut pengar");

        while (true) {
            try {
                System.out.print("Välj vad du vill göra: ");
                choice = scan.nextInt();

                if (choice > 0 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Du kan bara välja mellan 1 till 3");
                }
            } catch (Exception e) {
                System.out.println("Du kan bara välja mellan 1 till 3");
                scan.nextLine();
            }
        }

        switch (choice) {
            case 1:
                System.out.println(user.getPengar() + "kr");
                break;

            case 2:
                System.out.print("Hur mycket vill du insätta? ");
                int insattning_belopp = scan.nextInt();
                user.insattning(insattning_belopp);
                System.out.println("Du har nu " + user.getPengar() + "kr");
                break;

            case 3:
                System.out.print("Hur mycket vill du ta ut? ");
                int utdrag_belopp = scan.nextInt();
                user.utdrag(utdrag_belopp);
                System.out.println("Du har nu " + user.getPengar() + "kr");
                break;
        }
    }

}
