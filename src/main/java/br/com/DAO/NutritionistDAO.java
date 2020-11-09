/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.connection.Connection;
import br.com.domain.nutritionist.Nutritionist;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Henrique
 */
public class NutritionistDAO {
    
    public Nutritionist carrega(Nutritionist nutritionist) {
        
        EntityManager connection = Connection.getConnection();
        Session session = (Session) connection.getDelegate();
        Criteria criteria = session.createCriteria(Nutritionist.class);
        Criterion c1 = Restrictions.eq("cfn", nutritionist.getCfn());
        Criterion c2 = Restrictions.eq("password", nutritionist.getPassword());
        criteria.add(c1);
        criteria.add(c2);
        connection.close();
        return nutritionist;
  }
    
     public Nutritionist update(Nutritionist nutritionist) {
        EntityManager connection = Connection.getConnection();
        try {
            connection.getTransaction().begin();
            connection.merge(nutritionist);
            connection.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return nutritionist;
    }
     
     public Nutritionist findById(String cfn) {
        EntityManager connection = Connection.getConnection();
        Nutritionist nutritionist = null;
        try {
            nutritionist = connection.find(Nutritionist.class, cfn);
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return nutritionist;
    }
}
