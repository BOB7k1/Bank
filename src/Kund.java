public class Kund {

    private double pengar;
    private String namn;
    public Kund (String name){
        namn = name;
        pengar = 0.0;
    }

    public void insattning(double belopp){
        pengar = pengar + belopp;
    }
    public void utdrag (double belopp){
        if (belopp<=pengar){
            pengar = pengar - belopp;
        }
        else {
            System.err.println("transaktionen avbröts på grund av otillräcklig finansiering(in på leovegas och dubbla skiten)");
        }

    }
    public double getPengar(){
        return pengar;
    }

    public String getName() { return namn; }

}
