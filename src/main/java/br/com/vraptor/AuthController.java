/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vraptor;

import br.com.DAO.NutritionistDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.components.UserSession;
import br.com.controller.IndexController;
import br.com.domain.nutritionist.Nutritionist;
import javax.inject.Inject;

/**
 *
 * @author Henrique
 */

        
@Controller
@Path("auth")
public class AuthController {
    
    @Inject                                                                     // responsavel pelo ciclo de vida
    private UserSession userSession;                                            // Garante que só vai existir um objeto por seção
    
    @Inject         
    private Result result; 
    
    @Inject
    private NutritionistDAO nutritionistDAO;
     
    @Get("signin")
    public void signinView(){
        
    }
    
    @Get("login")
    public void signin( Nutritionist nutritionist){
        
    Nutritionist carregado = nutritionistDAO.carrega(nutritionist);
    
    if (carregado == null) {
        result.redirectTo(this).signinView();
    }
    else{
        userSession.isIsLogged();
        result.redirectTo(IndexController.class).Nutritionist();
        }
    }
    
    @Get("signout")
    public void signOut(){
        userSession.logout();
        result.redirectTo(this).signinView();
    }
}
