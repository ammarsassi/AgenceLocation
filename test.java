package Ex8;


import java.util.List;
import java.util.Scanner;

public class test
{

    public static void main(String [] args)
    {
        AgenceLocation agence =new AgenceLocation("EliteCar");
        Scanner entree= new Scanner(System.in);
        System.out.println("**************\tBienvenu à l'agence EliteCar\t****************");


        int choix;

        do
        {
            System.out.println("\tMenu");
            System.out.println("\t--> Taper 1 pour ajouter voiture sport");
            System.out.println("\t--> Taper 2 pour ajouter voiture de luxe");
            System.out.println("\t--> Taper 3 pour louer une voiture");
            System.out.println("\t--> Taper 4 pour rendre une voiture");
            System.out.println("\t--> Taper 5 pour afficher la marque de voiture de sport la plus chére");
            System.out.println("\t--> Taper 6 pour afficher toute les voitures disponibles");
            System.out.println("\t--> Taper 0 pour quiter");

            choix=entree.nextInt();
            entree.nextLine();

            switch (choix)
            {
                case 0 :
                    System.exit(0);
                case 1 :
                    {
                    System.out.println("Donner marque de voiture de sport à ajouter");
                    String marque=entree.nextLine();
                    System.out.println("Donner prix de la voiture");
                    float prix=entree.nextFloat();
                    System.out.println("Donner montant de réduction");
                    float montantR=entree.nextFloat();
                    entree.nextLine();
                    System.out.println("Donner vitesse de la voiture en km/h");
                    String vitesse=entree.nextLine();

                    Voiture v1 = new VoitureSport(marque, prix,montantR, vitesse);
                    v1.setEtat(Tetat.disponible);
                    agence.ajouterVoiture(v1);

                    if(v1!=null) {
                        System.out.println("Ajout fait avec succés");
                        System.out.println(v1);
                    }
                    else
                        System.out.println("Il y a eu problème");
                }break;

                case 2:
                {

                    System.out.println("Donner marque de voiture de luxe à ajouter");
                    String marqueV=entree.nextLine();
                    System.out.println("Donner prix de la voiture");
                    float prix=entree.nextFloat();
                    System.out.println("Donner montant supplémentaire");
                    float montantR=entree.nextFloat();

                    Voiture v1 = new VoitureDeLuxe(marqueV, prix, montantR);
                    v1.setEtat(Tetat.disponible);
                    agence.ajouterVoiture(v1);

                    if(v1!=null)
                    {
                        System.out.println("Ajout fait avec succés");
                        System.out.println(v1);
                    }
                    else
                        System.out.println("Il y a eu problème");

                }break;

                case  3 :
                {
                    System.out.println("Donner votre seuil pour louer une voiture");
                    float seuil = entree.nextFloat();
                    Voiture v3 = agence.louerVoiture(seuil);
                    if (v3 != null) {
                        System.out.println("La voiture qui vous correspond est la suivante");
                        System.out.println(v3);
                        System.out.println("Taper 1 si voulez louer cette voiture 0 sinon");
                        int choix2 =entree.nextInt();
                        if(choix2==1)
                            v3.etat=Tetat.indisponible;
                        System.out.println("Opération réuissie");
                    } else
                        System.out.println("Aucune voiture ne vous correspond");
                }break;

                case 4 :
                {
                    System.out.println("Entrer matricule voiture à rendre");
                    long m = entree.nextLong();
                    Voiture v4 = agence.rechercheVoiture(m);
                    if(agence.rendreVoiture(v4)!=false)
                    System.out.println("Voiture restorée dans le parc auto, vérifiez en tappant 6");
                    else
                        System.out.println("Voiture inexistante");
                }break;

                case 5:
                {
                    String la_plus_chere = agence.marqueDeSportLaPlusChère();
                    if(la_plus_chere==null) {
                        System.out.println("La base de données est vide");
                    }
                    else
                    {
                        System.out.println("La marque la plus chére des voitures disponibles est\n"+la_plus_chere);
                    }
                }break;

                case 6 :
                {

                    List<Voiture> disponibles;
                    disponibles=agence.voituresDisponibles();

                    if(disponibles.size()!=0) {
                        System.out.println("Toutes les voitures disponibles jusqu'à cet instant sont");
                        for (Voiture v : disponibles) {
                            System.out.println(v);
                        }
                    }
                    else
                        System.out.println("Aucune voiture n'est disponible pour le moment");
                }break;

                }
        }while(choix!=0);


    }
}
