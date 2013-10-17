/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.AcessoDAO;
import br.com.cmr.model.dao.IAcessoDAO;
import br.com.cmr.model.entity.Usuarios;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class AcessoFacade {
    
    private IAcessoDAO dao;

    public AcessoFacade() {
        this.dao = new AcessoDAO();
    }
    
    public List<Usuarios> buscarUsuarios(String login, String senha){
        return dao.pesquisar(login, senha, null);
    }
    
}
