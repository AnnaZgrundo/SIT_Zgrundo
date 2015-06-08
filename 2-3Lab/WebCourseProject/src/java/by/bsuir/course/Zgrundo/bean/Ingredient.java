/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.bean;

import java.util.Objects;

/**
 *
 * @author ko
 */
public class Ingredient {
    private int idIngredient;
    private String ingredient;
    private int cost;
    private int kkal;
    
    public Ingredient() {
    }

    public Ingredient(int idIngredient, String ingredient, int cost, int kkal) {
        this.idIngredient = idIngredient;
        this.ingredient = ingredient;
        this.cost = cost;
        this.kkal = kkal;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getKkal() {
        return kkal;
    }

    public void setKkal(int kkal) {
        this.kkal = kkal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idIngredient;
        hash = 97 * hash + Objects.hashCode(this.ingredient);
        hash = 97 * hash + this.cost;
        hash = 97 * hash + this.kkal;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredient other = (Ingredient) obj;
        if (this.idIngredient != other.idIngredient) {
            return false;
        }
        if (!Objects.equals(this.ingredient, other.ingredient)) {
            return false;
        }
        if (this.cost != other.cost) {
            return false;
        }
        if (this.kkal != other.kkal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "idIngredient=" + idIngredient 
                + ", ingredient=" + ingredient + ", cost=" + cost 
                + ", kkal=" + kkal + '}';
    }

    
}
