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
public class DishType {
    private int idDishType;
    private String type;

    public DishType() {
    }

    public DishType(int idDishType, String type) {
        this.idDishType = idDishType;
        this.type = type;
    }

    public int getIdDishType() {
        return idDishType;
    }

    public void setIdDishType(int idDishType) {
        this.idDishType = idDishType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.idDishType;
        hash = 61 * hash + Objects.hashCode(this.type);
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
        final DishType other = (DishType) obj;
        if (this.idDishType != other.idDishType) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DishType{" + "idDishType=" + idDishType + ", type=" + type + '}';
    }
    
    
}
