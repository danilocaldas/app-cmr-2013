/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller;

import br.com.cmr.controller.facade.AcessoFacade;
import br.com.cmr.model.entity.Usuarios;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class AcessoController {
    
    private AcessoFacade facade;

    public AcessoController() {
        this.facade = new AcessoFacade();
    }
    
    public List<Usuarios>  buscarUsuarios(String login, String senha){
        return facade.buscarUsuarios(login, senha);
    }
}
