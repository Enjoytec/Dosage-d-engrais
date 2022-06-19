package patrick.cheba.orace;

public class ModelDosage {

    private String nom;
    private double N;
    private double P;
    private double K;

    public ModelDosage (){
        super();
    }

    public ModelDosage(String nom, double N, double P, double K) {
        this.nom = nom;
        this.N = N;
        this.P = P;
        this.K = K;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getN() {
        return N;
    }

    public void setN(double n) {
        N = n;
    }

    public double getP() {
        return P;
    }

    public void setP(double p) {
        P = p;
    }

    public double getK() {
        return K;
    }

    public void setK(double k) {
        K = k;
    }
}
