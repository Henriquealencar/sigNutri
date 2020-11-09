/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.connection.Connection;
import br.com.domain.patient.Patient;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Henrique
 */
public class PatientDAO {

public Patient save(Patient patient) {
        EntityManager connection = Connection.getConnection();
        try {
            connection.getTransaction().begin();
            if (patient.getCpf() == null) {
                connection.persist(patient);
            } else {
                connection.merge(patient);
            }
            connection.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return patient;
    }

    public Patient update(Patient patient) {
        EntityManager connection = Connection.getConnection();
        try {
            connection.getTransaction().begin();
            connection.merge(patient);
            connection.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return patient;
    }

    public Patient findById(String cpf) {
        EntityManager connection = Connection.getConnection();
        Patient patient = null;
        try {
            patient = connection.find(Patient.class, cpf);
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return patient;
    }

    public List<Patient> findAll() {
        EntityManager connection = Connection.getConnection();
        List<Patient> patient = null;

        try {
            patient = connection.createQuery("from Patient").getResultList();
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return patient;
    }

    public Patient remove(String cpf) {
        EntityManager connection = Connection.getConnection();
        Patient patient = null;
        try {
            patient = connection.find(Patient.class, cpf);
            connection.getTransaction().begin();
            connection.remove(patient);
            connection.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            connection.getTransaction().rollback();
        } finally {
            connection.close();
        }
        return patient;
    }

    public List<Patient> findByName(String name) {
        EntityManager connection = Connection.getConnection();
        System.out.println("br.com.DAO.PatientDAO.findByName()");
        Session session = (Session) connection.getDelegate();
        Criteria criteria = session.createCriteria(Patient.class);
        Criterion c1 = Restrictions.ilike("nome", name, MatchMode.ANYWHERE);
        //Criterion c2 = Restrictions;
        criteria.add(c1);
        //criteria.add(c2);
        List<Patient> patient = criteria.list();
        connection.close();
        return patient;
    }
    
}
