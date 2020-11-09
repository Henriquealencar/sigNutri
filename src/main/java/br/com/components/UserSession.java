/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.components;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Henrique
 */
        
@SessionScoped
@Named("userSession")
public class UserSession implements Serializable{
    
    private String cfn;

    public String getCfn() {
        return cfn;
    }

    public void setCpf(String cfn) {
        this.cfn = cfn;
    }
    
    private boolean isLogged;

    public boolean isIsLogged() {
        return cfn != null;
    }
    
    public void logout(){
        this.cfn = null;
        this.isLogged = false;
    }
    
}
