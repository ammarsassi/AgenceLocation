package Ex8;

import java.util.ArrayList;

public class AgenceLocation
{
    private String nomAgence;
    private int capacitéMax =1000;
    private ArrayList <Voiture> tabVoitures;




    public AgenceLocation(String n)
    {
        this.nomAgence=n;
        this.tabVoitures= new ArrayList<>();
    }


    public int ajouterVoiture(Voiture v)
    {
        if(this.tabVoitures.size()==this.capacitéMax)
            return 0;
        else {
            this.tabVoitures.add(v);
            return 1;
        }
    }

    public Voiture louerVoiture(float p)
    {
        if(this.tabVoitures.isEmpty()!=true)
        {
            Voiture v1 = this.tabVoitures.get(0);
            for (Voiture v : this.tabVoitures)
            {
                if (v.correspond(p) == true && (v.calculerPrixAPayer()>v1.calculerPrixAPayer()))
                {
                   v1=v;
                }

            }
          return v1;
        }

        return null;
    }

    public boolean rendreVoiture(Voiture v)
    {
        boolean trouve=false;
        if(this.tabVoitures.isEmpty()!=true)
        {
            int i=0;
            while(trouve!=true)
            {
                Voiture v1 = this.tabVoitures.get(i);
                if (v1.estIdentique(v))
                {
                    if (v.getEtat()==Tetat.indisponible)
                        v1.etat = Tetat.disponible;
                    trouve=true;
                }
                i++;
            }
        }
        return trouve;
    }

    public String marqueDeSportLaPlusChère()
    {
        if(this.tabVoitures.isEmpty())
            return null;
        else {
            String marq = this.tabVoitures.get(0).marque;
            float prix = this.tabVoitures.get(0).getPrixLoc();
            for (Voiture v : tabVoitures)
            {
                if (v.getClass().getName() == "Ex8.VoitureSport")
                {
                    if (v.getPrixLoc() > prix)
                    {
                        prix = v.getPrixLoc();
                        marq = v.getMarque();
                    }
                }
            }

            return marq;
        }

    }

    public Voiture rechercheVoiture(long matricule)
    {
        for(Voiture v : this.tabVoitures)
        {
            if (v.idVoiture == matricule)
                return v;
        }
        return null;
    }

        public ArrayList<Voiture> voituresDisponibles()
        {
            ArrayList<Voiture> res = new ArrayList<>();

            for (Voiture v : this.tabVoitures) {
                if (v.getEtat() == Tetat.disponible)
                    res.add(v);
            }

            return res;
        }



}
