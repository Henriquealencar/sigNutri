/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.interceptors;

import br.com.annotations.Private;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.components.UserSession;
import br.com.vraptor.AuthController;
import javax.inject.Inject;

/**
 *
 * @author Henrique
 */

@Intercepts
public class AuthInterceptor implements Interceptor{
    
    @Inject
    private UserSession userSession;
    
    @Inject
    private Result result;
    
    @Override
    public void intercept(InterceptorStack is, ControllerMethod cm, Object o) 
            throws InterceptionException {                                      //To change body of generated methods, choose Tools | Templates.
        if (userSession.isIsLogged()) {
            is.next(cm, o);                                                     // O user será redirecionado para a proxima url (No caso, a que o user informou)
        }else{
            result.redirectTo(AuthController.class).signinView();
        }
    }

    @Override
    public boolean accepts(ControllerMethod cm) {                               //To change body of generated methods, choose Tools | Templates.
        return cm.getController().getType().isAnnotationPresent(Private.class) 
            || cm.containsAnnotation(Private.class);
    }

    
    

}
