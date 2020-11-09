/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.DAO.PatientDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.domain.patient.Patient;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Henrique
 */

@Controller
@Path("patient")
public class PatientController {
    
    @Inject
    private Result result;

    @Inject
    private PatientDAO patientDAO;

    @Get("new")
    public void newPatient() {

    }
    
    @Post("novo")
    public void newPatient(Patient patient) {
        patientDAO.save(patient);
        result.redirectTo(this).listPatient();
    }

    @Post("editar")
    public void editPatient(Patient patient) {
        patientDAO.update(patient);
        result.redirectTo(this).listPatient();
    }

    @Get("editar/{cpf}")
    public void editPatient(String cpf) {
        Patient patient = patientDAO.findById(cpf);
        result.include("patient", patient);
    }

    @Get("remover/{cpf}")
    public void removePatient(String cpf) {

        Patient patient = patientDAO.findById(cpf);
        result.include("patient", patient);
        patientDAO.remove(cpf);
        result.redirectTo(this).listPatient();
    }

    @Get("listStudent")
    public void listPatient() {
        List<Patient> patient = patientDAO.findAll();
        for (Patient patient1 : patient) {
            System.out.println(patient1.getNome());
        }
        result.include("patient", patient);
    }
    
    
    @Post("busca")
    public void simpleSearch(String nome) {
        System.out.println("NOME: "+nome);
        List<Patient> patient = (List<Patient>) patientDAO.findByName(nome);
        
        result.include("patient", patient);
        result.of(this).listPatient();

    }
    
}
