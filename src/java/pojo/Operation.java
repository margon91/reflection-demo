/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author marta
 */

public class Operation {
    private String id;
    private String nClass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNClass() {
        return nClass;
    }

    public void setNClass(String nClass) {
        this.nClass = nClass;
    }

    @Override
    public String toString() {
        return "op = " + id + " c " + nClass;
    }
    
    
}
