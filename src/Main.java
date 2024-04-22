
public class Main {
    public static Billet lavBillet(String billetId, int dageTilEvent) {
        switch (billetId) {
            case "Dør":
                return new DørBillet();
            case "Førsalg":
                return new ForsalgBillet(dageTilEvent);
            case "Student":
                return new StudieRabatBillet(dageTilEvent);

            default:
                System.out.println("Ukendt billet-id " + billetId);
                return null;
        }
    }

    public static double billetPris (Billet billet) {
        return billet.pris();
    }

    public static void main(String[] args) {
        Billet billet1 = lavBillet("Dør", 0);
        Billet billet2 = lavBillet("Førsalg", 7);
        Billet billet3 = lavBillet("Student", 15);

        //System.out.println("Billet 1 pris " + billet1.pris());
        //System.out.println("Billet 2 pris " + billet2.pris());
        //System.out.println("Billet 3 pris " + billet3.pris());

        System.out.println(billet1);
        System.out.println(billet2);
        System.out.println(billet3);
    }
}