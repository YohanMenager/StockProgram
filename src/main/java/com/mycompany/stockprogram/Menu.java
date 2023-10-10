/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stockprogram;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author MENAGER
 */
public class Menu {
    private ArrayList<Article> lesArticles = new ArrayList();
    private Scanner sc=new Scanner(System.in);
    
    public Menu(ArrayList<Article> lesarts)
    {
        lesArticles=lesarts;
    }
    
    

    public int AfficheMenu() throws IOException
    {
        //affichage du menu
        System.out.println("*****************************Menu*****************************");
        System.out.println("1-Rechercher un article par numéro");
        System.out.println("2-Ajouter un article");
        System.out.println("3-Supprimer un article par numéro");
        System.out.println("4-Modifier un article par numéro");
        System.out.println("5-Rechercher un article par nom");
        System.out.println("6-Rechercher un article par intervalle de prix de vente");
        System.out.println("7-Afficher tous les articles");
        System.out.println("8-Quitter");
        System.out.println("Donnez votre choix");
        
        //récupère le choix de l'utilisateur. fonctionne avec une valeur non numérique
        int choix=0;
        while(sc.hasNext())
        {
            if(sc.hasNextInt())
            {
                choix = sc.nextInt();
                return choix;
            }
            else
            {
                sc.next();
                return 0;
            }
        }
        return 0;
    }
    
    public String ChercheArtParNum() throws IOException
    {
        System.out.println("Donnez le numéro de l'article à rechercher");
        int num = sc.nextInt();
        
        //cherche l'article
        for(Article Art : lesArticles)
        {
            if(Art.getRef()==num)
            {
                return Art.toString();
            }
        }
        return "Cet article n'existe pas";
    }
    
    public void AjouterArticle() throws IOException
    {
        
        System.out.println("Donnez le numéro de l'article à ajouter");
        int num = sc.nextInt();
        
        System.out.println("Donnez le nom");
        String nom = sc.nextLine();//nextLine doit être fait 2 fois pour éviter les bugs
        nom = sc.nextLine();
        
        System.out.println("Donnez le prix");
        float prix = sc.nextFloat();
        
        System.out.println("Donnez la quantité");
        int quantite = sc.nextInt();
        
        //ajout de l'article
        Article larticle = new Article(num, nom, prix, quantite); 
        lesArticles.add(larticle);
    }
    
    public void SupprimerArticle() throws IOException
    {
        System.out.println("Donnez le numéro de l'article à supprimer");
        int num = sc.nextInt();

        //cherche l'article
        int i=0;
        for(Article Art : lesArticles)
        {
            if(Art.getRef()==num)
            {
                lesArticles.remove(i);//suppression
            }
            i++;
        }
        //si l'article n'existe pas
        if(i>lesArticles.size())
        {
            System.out.println("Cet article n'existe pas");
        }
        
    }
    
        public void ModifArticle() throws IOException {
        
        
        System.out.println("Entrer le numéro de l'article à modifier");
        
        int num = sc.nextInt();
        
        //affichage d'un menu
        System.out.println("*****Options*****");
        System.out.println("1-Modifier le nom");
        System.out.println("2-Modifier le prix");
        System.out.println("3-Modifier la quantité");
        System.out.println("4-Terminer");
        
        //choix
        System.out.println("Donner votre choix: ");
        int choix = sc.nextInt();
        
        switch(choix) {
            case 1 -> {
                System.out.println("Donner le nouveau nom");
                String Nnom = sc.next();
                lesArticles.forEach((Art)-> {
                    if(Art.getRef()==num)
                    {
                        Art.setArt_nom(Nnom);
                    }
                });
            }
                
                case 2 -> {
                    System.out.println("Donner le nouveau Prix");
                    float Nprix = sc.nextFloat();
                    lesArticles.forEach((Art)-> {
                        if(Art.getRef()==num)
                        {
                            Art.setArt_PrixVente(Nprix);
                        }
                    });
            }
                
                case 3 -> {
                    System.out.println("Donner la nouvelle quantité");
                    int Nquan = sc.nextInt();
                    lesArticles.forEach((Art)-> {
                        if(Art.getRef()==num)
                        {
                            Art.setArt_Stock(Nquan);
                        }
                    });
            }
        }
            
        
        
        
        System.out.println("Nom modifié avec succès");
    }
    
    
    
    
    
    
    public void ChercheArtParNom() throws IOException
    {
        System.out.println("Donnez le nom de l'article à rechercher");
        String nom = sc.nextLine();//nextline doit être utilisé 2 fois
        nom = sc.nextLine();

        int i=0;
        for(Article Art : lesArticles)
        {
            if(Art.getNom().equals(nom))
            {
                System.out.println(Art.toString());
            }
            i++;
        }
        if(i>lesArticles.size())//si l'article n'existe pas
        {
            System.out.println("Cet article n'existe pas");
        }
    }    

    public void ChercheArtParTranchePrix() throws IOException
    {
        int min, max;//déclaration des bornes
        
        var wrapper = new Object(){ String Liste = ""; };//sert pour utiliser une variable dans la boucle foreach sans qu'elle ai été créée dedans
        
        System.out.println("entrez le prix minimal");
        min = sc.nextInt();
        System.out.println("entrez le prix maximal");
        max = sc.nextInt();
        System.out.println("Liste des articles avec un prix entre "+min+" et "+max);
        lesArticles.forEach((Art)-> {
                if(Art.getPrixVente()>=min && Art.getPrixVente()<=max)
                    {
                        wrapper.Liste+=Art.toString()+"\n";
                    }}
        ); 
        if(!wrapper.Liste.isBlank())
        {
            System.out.println(wrapper.Liste);
        }
    }
    public void AfficherTousArticles()
    {
        var wrapper = new Object(){ String articles = ""; };//sert pour utiliser une variable dans la boucle foreach sans qu'elle ai été créée dedans
        lesArticles.forEach((Art)-> wrapper.articles+=Art.toString()+"\n");
        
        System.out.println(wrapper.articles);
    }
}
