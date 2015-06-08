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
public class DishIngredient {
    private int idDish;
    private int idIngredient;
    private int weight;    

    public DishIngredient() {
    }

    public DishIngredient(int idDish, int idIngredient, int weight) {
        this.idDish = idDish;
        this.idIngredient = idIngredient;
        this.weight = weight;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idDish;
        hash = 97 * hash + this.idIngredient;
        hash = 97 * hash + this.weight;
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
        final DishIngredient other = (DishIngredient) obj;
        if (this.idDish != other.idDish) {
            return false;
        }
        if (this.idIngredient != other.idIngredient) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DishIngredient{" + "idDish=" + idDish + ", idIngredient=" + idIngredient 
                + ", weight=" + weight + '}';
    }

    
}
