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
public class Dish {
    private int idDish;
    private String name;
    private int cost;
    private int kkal;
    private DishType type;
    private String cookingMethod;
    private int userAddID;
    private String userAddName;
    private String picture;
    private Status status;
    private String time;

    public Dish() {
    }

    public Dish(int idDish, String name, int cost, int kkal, DishType type, String cookingMethod, int userAddID, String userAddName, String picture, Status status, String time) {
        this.idDish = idDish;
        this.name = name;
        this.cost = cost;
        this.kkal = kkal;
        this.type = type;
        this.cookingMethod = cookingMethod;
        this.userAddID = userAddID;
        this.userAddName = userAddName;
        this.picture = picture;
        this.status = status;
        this.time = time;
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public int getUserAddID() {
        return userAddID;
    }

    public void setUserAddID(int userAddID) {
        this.userAddID = userAddID;
    }

    public String getUserAddName() {
        return userAddName;
    }

    public void setUserAddName(String userAddName) {
        this.userAddName = userAddName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idDish;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.cost;
        hash = 79 * hash + this.kkal;
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Objects.hashCode(this.cookingMethod);
        hash = 79 * hash + this.userAddID;
        hash = 79 * hash + Objects.hashCode(this.userAddName);
        hash = 79 * hash + Objects.hashCode(this.picture);
        hash = 79 * hash + Objects.hashCode(this.status);
        hash = 79 * hash + Objects.hashCode(this.time);
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
        final Dish other = (Dish) obj;
        if (this.idDish != other.idDish) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.cost != other.cost) {
            return false;
        }
        if (this.kkal != other.kkal) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.cookingMethod, other.cookingMethod)) {
            return false;
        }
        if (this.userAddID != other.userAddID) {
            return false;
        }
        if (!Objects.equals(this.userAddName, other.userAddName)) {
            return false;
        }
        if (!Objects.equals(this.picture, other.picture)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dish{" + "idDish=" + idDish + ", name=" + name + ", cost=" + cost 
                + ", kkal=" + kkal + ", type=" + type + ", cookingMethod=" + cookingMethod 
                + ", userAddID=" + userAddID + ", userAddName=" + userAddName 
                + ", picture=" + picture + ", status=" + status + ", time=" + time + '}';
    }

    
}
