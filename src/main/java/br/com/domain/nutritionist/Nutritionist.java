/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domain.nutritionist;

import br.com.domain.patient.Patient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Henrique
 */

@Entity
public class Nutritionist {

@Id
private String cfn;

@Column(nullable = false)
private String password;


@Column(nullable = false)
public String nome;

    public String getCfn() {
        return cfn;
    }

    public void setCfn(String cfn) {
        this.cfn = cfn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
