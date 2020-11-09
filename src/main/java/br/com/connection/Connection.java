/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Henrique
 */
public class Connection {
    
    private static EntityManagerFactory connection = Persistence.createEntityManagerFactory("br.com_signutri");

    private Connection() {
    }

    public static EntityManager getConnection() {
        return connection.createEntityManager();
    }
    public static void fechar(){                                                // Metodo para fechar a conexão
        connection.close();                                                       // fazendo com que aconteça
    }
    
}
