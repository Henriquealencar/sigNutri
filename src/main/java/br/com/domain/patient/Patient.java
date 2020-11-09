/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.domain.patient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Henrique
 */

@Entity
public class Patient {
    
    @Id
    private String cpf;
    
    
    @Column(nullable = false)
    public String nome;
    
    
    @OneToOne(cascade = CascadeType.ALL)                                        // Um para um, serve para o que fazer com um fazer com o outro
    @JoinColumn
    public Endereco endereco;
    
    @OneToOne(cascade = CascadeType.ALL)                                        // Um para um, serve para o que fazer com um fazer com o outro
    @JoinColumn
    public Contato contato;

    @Column(nullable = false)
    private String password;
    
    
    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
}
