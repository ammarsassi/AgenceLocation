package Ex8;

public class VoitureDeLuxe extends Voiture implements IComparable
{
    private float montSupp;

    public VoitureDeLuxe(String m, float p, float mnt)
    {
        super(m,p);
        this.montSupp=mnt;
    }

    public float getMontSupp() {
        return montSupp;
    }

    public void setMontSupp(float montSupp) {
        this.montSupp = montSupp;
    }

    public void afficher()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        return "Voiture{"+"\tID voiture : "+idVoiture+
                "\tMarque : "+this.marque+
                "\tEtat de la voiture : "+this.etat+
                "\tPrix :"+this.prixLocation+
                "\tMontant supplémentaire :"+this.montSupp+"}";
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
    public float calculerPrixAPayer()
    {
      return (this.prixLocation+this.montSupp);
    }
}
