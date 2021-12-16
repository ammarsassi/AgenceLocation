package Ex8;

public class VoitureSport extends Voiture
{

    private float montReduction;
    private String vitesseMax;

    public VoitureSport(String m, float p, float mnt, String vM)
    {
        super(m,p);
        this.montReduction=mnt;
        this.vitesseMax=vM;
    }

    public float getMontRéduction() {
        return montReduction;
    }

    public void setMontRéduction(float mR) {
        this.montReduction = mR;
    }

    public String getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(String vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    @Override
    public float calculerPrixAPayer()
    {
        return (this.prixLocation-this.montReduction);
    }

    @Override
    public boolean estIdentique(Object o) {
        if(this==o)
            return true;
        else
            return false;
    }

    @Override
    public boolean correspond(float p) {
        if((this.etat==Tetat.disponible)&&(this.calculerPrixAPayer()<=p))
            return true;
        else
             return false;
    }

    @Override
    public String toString()
    {
        return "Voiture{"+"\tID voiture : "+idVoiture+
                "\tMarque : "+this.marque+
                "\tEtat de la voiture : "+this.etat+
                "\tPrix :"+this.prixLocation+
                "\tMontant de réuction :"+this.montReduction+
                "\tVitesse de la voiture : "+this.vitesseMax+"}";
    }

}
