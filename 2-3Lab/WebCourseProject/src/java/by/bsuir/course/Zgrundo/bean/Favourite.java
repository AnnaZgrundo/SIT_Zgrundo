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
public class Favourite {
    private int idFavourite;
    private Dish dish;
    private int idUser;

    public Favourite() {
    }

    public Favourite(int idFavourite, Dish dish, int idUser) {
        this.idFavourite = idFavourite;
        this.dish = dish;
        this.idUser = idUser;
    }

    public int getIdFavourite() {
        return idFavourite;
    }

    public void setIdFavourite(int idFavourite) {
        this.idFavourite = idFavourite;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idFavourite;
        hash = 23 * hash + Objects.hashCode(this.dish);
        hash = 23 * hash + this.idUser;
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
        final Favourite other = (Favourite) obj;
        if (this.idFavourite != other.idFavourite) {
            return false;
        }
        if (!Objects.equals(this.dish, other.dish)) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Favourite{" + "idFavourite=" + idFavourite + ", dish=" + dish 
                + ", idUser=" + idUser + '}';
    }

    
}
