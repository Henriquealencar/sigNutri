/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.DAO.NutritionistDAO;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.domain.nutritionist.Nutritionist;
import javax.inject.Inject;

/**
 *
 * @author Henrique
 */

@Controller
@Path("nutritionist")
public class NutritionistController {
    
    
    @Inject
    private Result result;

    @Inject
    private NutritionistDAO nutritionistDAO;

    
    @Get("editar/{cfn}")
    public void editNutritionist(String cfn) {
        Nutritionist nutritionist = nutritionistDAO.findById(cfn);
        result.include("nutritionist", nutritionist);
    }

    
}
