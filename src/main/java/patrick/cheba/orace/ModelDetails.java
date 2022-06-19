package patrick.cheba.orace;

public class ModelDetails {
    private String nom;
    private String plante;
    private int nombrePieds;
    private double p;
    private double k;
    private double n;
//    private double total;

    public ModelDetails(){
        super();
    }

    public ModelDetails(String nom, String plante, double n, double p, double k, int nombrePieds) {
        this.nom = nom;
        this.plante = plante;
        this.nombrePieds = nombrePieds;
        this.p = p;
        this.k = k;
        this.n = n;
//        this.total = total;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPlante() {
        return plante;
    }

    public void setPlante(String plante) {
        this.plante = plante;
    }

    public int getNombrePieds() {
        return nombrePieds;
    }

    public void setNombrePieds(int nombrePieds) {
        this.nombrePieds = nombrePieds;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

//    public double getTotal() {
//        return total;
//    }
//
//    public void setTotal(double total) {
//        this.total = total;
//    }
}
