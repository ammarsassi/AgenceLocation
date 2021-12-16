package Ex8;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.util.Date;

public abstract class Voiture implements IComparable
{

    protected long idVoiture;
    protected String marque;
    protected float prixLocation;
    protected Tetat etat;

    public Voiture(String m, float p)
    {
        this.idVoiture = new Date().getTime();
        this.marque=m;
        this.prixLocation=p;
        this.etat=Tetat.disponible;
    }

    public String getMarque()
    {
        return this.marque;
    }

    public float getPrixLoc()
    {
        return this.prixLocation;
    }

    public Tetat getEtat()
    {
        return this.etat;
    }

    public void setEtat(Tetat t)
    {
        this.etat=t;
    }

    public abstract float calculerPrixAPayer();

    @Override
    public String toString()
    {
        return "Voiture{"+"\tID voiture : "+idVoiture+
                "\n\tMarque : "+this.marque+
                "\n\tEtat de la voiture : "+this.etat+
                "\n\tPrix :"+this.prixLocation+"}";
    }

    @Override
    public boolean estIdentique(Object o)
    {
        if(this==o)
            return true;
        else
            return false;
    }
    @Override
    public boolean correspond(float p)
    {
        if((this.etat== Tetat.disponible)&&(this.calculerPrixAPayer()<=p))
            return true;
        else
            return false;
    }



}
