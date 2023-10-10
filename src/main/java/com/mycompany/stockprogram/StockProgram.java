/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.stockprogram;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Bocchetti
 */
public class StockProgram {
/**
 * 
 * @param args
 * @throws IOException 
 */
    public static void main(String[] args) throws IOException {
        
        //instanciation des articles
        Article a1 = new Article(1, "un", 10.0f, 10);
        Article a2 = new Article(2, "deux", 20.0f, 20);
        Article a3 = new Article(3, "trois", 30.0f, 30);
        Article a4 = new Article(4, "quatre", 40.0f, 40);
        Article a5 = new Article(5, "cinque", 50.0f, 50);
        
        //création d'une collection d'article
        ArrayList<Article> Stock = new ArrayList();
        
        Stock.add(a1);
        Stock.add(a2);
        Stock.add(a3);
        Stock.add(a4);
        Stock.add(a5);
        
        //instanciation du menu
        Menu lemenu = new Menu(Stock);
        
        boolean fin=false;//sert à continuer d'utiliser le menu jusqu'à ce que l'utilisateur choisisse stop
        int choix;//création de la variable choix
        while(fin==false)
        {
            choix=lemenu.AfficheMenu();//on affiche le menu et on enregistre le choix de l'utilisateur
            switch(choix)
            {
                case 1 -> System.out.println(lemenu.ChercheArtParNum());
                case 2 -> lemenu.AjouterArticle();
                case 3 -> lemenu.SupprimerArticle();
                case 4 -> lemenu.ModifArticle();
                case 5 -> lemenu.ChercheArtParNom();
                case 6 -> lemenu.ChercheArtParTranchePrix();
                case 7 -> lemenu.AfficherTousArticles();
                case 8 -> fin = true;
                default -> System.out.println("Veuillez entrer un chiffre entre 1 et 8");
            }
        }
    }
}
