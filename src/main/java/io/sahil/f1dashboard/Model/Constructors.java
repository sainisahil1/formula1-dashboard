package io.sahil.f1dashboard.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Constructors {
    
    @Id
    private String constructorId;
    private String constructorRef;
    private String name;
    private String nationality;
    
    public String getConstructorId() {
        return constructorId;
    }
    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }
    public String getConstructorRef() {
        return constructorRef;
    }
    public void setConstructorRef(String constructorRef) {
        this.constructorRef = constructorRef;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    


}
