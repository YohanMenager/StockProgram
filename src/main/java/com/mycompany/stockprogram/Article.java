/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stockprogram;

/**
 *
 * @author Bocchetti
 */
public class Article {
    private int art_reference;
    private String art_nom;
    private float art_PrixVente;
    private int art_Stock;
    
    
    public Article(int art_reference, String art_nom, float art_PrixVente, int art_Stock) {
        this.art_reference = art_reference;
        this.art_nom = art_nom;
        this.art_PrixVente = art_PrixVente;
        this.art_Stock = art_Stock;
    }




    
    
    public int getRef() {
        return art_reference;
    }
    
    public String getNom() {
        return art_nom;
    }
    
    public float getPrixVente()  {
        return art_PrixVente;
    }
    
    public int getStock() {
        return art_Stock;
    }
    
        @Override
    public String toString() {
        return "Article{" + "reference=" + art_reference + ", Nom article=" + art_nom + ", Prix Vente=" + art_PrixVente + ", Stock=" + art_Stock + '}';
    }
    
    
    
    public void setArt_nom(String art_nom) {
        this.art_nom = art_nom;
    }

    public void setArt_PrixVente(float art_PrixVente) {
        this.art_PrixVente = art_PrixVente;
    }

    public void setArt_Stock(int art_Stock) {
        this.art_Stock = art_Stock;
    }
    
}
