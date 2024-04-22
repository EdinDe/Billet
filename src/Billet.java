import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Interface for Billet
interface Billet {
    double pris(); // beregne prisen
}

// dør billet
class DørBillet implements Billet {
    private double dørBillet = 150;

    @Override
    public double pris() {
        return dørBillet;
    }
    @Override
    public String toString(){
        return "Dørbillet - pris " + pris() + " kr";
    }
}

// Billet i forsalg
class ForsalgBillet implements Billet {
    private double normalPris = 120;
    private double rabat = 0.15;
    private int dageTilEvent;


    public ForsalgBillet(int dageTilEvent) {
        this.dageTilEvent = dageTilEvent;
    }

    @Override
    public double pris() {
        if (dageTilEvent < 10){
            return normalPris;
        } else {
            return normalPris - (normalPris * rabat);
        }
    }

    public String toString() {
        return "ForsalgBillet (" + dageTilEvent + " dage til event) - pris:" + pris() + " kr";

    }
}

// forsalg med studierabat
class StudieRabatBillet implements Billet {
    private double studentpris = 90;
    private double medRabat = 0.15;
    private int dageTilEvent;

    public StudieRabatBillet(int dageTilEvent) {
        this.dageTilEvent = dageTilEvent;

    }

    @Override
    public double pris() {
        if (dageTilEvent < 10) {
            return studentpris;
        } else {
            return studentpris - (studentpris * medRabat);
        }

    }

    @Override
    public String toString() {
        return "Billet købt med studierabat | Dage til event: " + dageTilEvent + " | Pris: " + pris() + " kr";


    }
}

class SolgeBilletter {
    private ArrayList<Billet> solgteBiletter;

    public SolgeBilletter() {
        solgteBiletter = new ArrayList<>();
    }
    public void tilføjBilletter(Billet billet) {
        solgteBiletter.add(billet);
    }

    public void visSolgeBilletter() {
        Collections.sort(solgteBiletter, Comparator.comparing(Object::hashCode));

        System.out.println("Solgte Billetter");
        for (Billet billet : solgteBiletter){
            System.out.println(billet);
        }


    }
}