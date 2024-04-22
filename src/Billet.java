// Interface for Billet
interface Billet {
    double pris(); // beregne prisen
}

// dør billet
class DørBillet implements Billet {
    private static final double dørBillet = 150;

    @Override
    public double pris() {
        return dørBillet;
    }
}

// Billet i forsalg
class ForsalgBillet implements Billet {
    private static final double normalPris = 120;
    private static final double rabat = 0.15;
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
}

// forsalg med studierabat
class StudieRabatBillet implements Billet {
    private static final double standardPris = 90;
    private static final double medRabat = 0.15;
    private int dageTilEvent;

    public StudieRabatBillet(int dageTilEvent ) {
        this.dageTilEvent = dageTilEvent;

    }

    @Override
    public double pris() {
        if (dageTilEvent < 10) {
            return standardPris;
        } else {
            return standardPris - (standardPris * medRabat);
        }

    }
}
