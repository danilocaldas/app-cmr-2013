/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.IUsuariosDAO;
import br.com.cmr.model.dao.UsuariosDAO;
import br.com.cmr.model.entity.Usuarios;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class UsuarioFacade {
    
    private IUsuariosDAO dao;

    public UsuarioFacade() {
        this.dao = new UsuariosDAO();
    }
    
    public int save(Usuarios usuarios){
        return dao.save(usuarios);
    }
    
    public int update(Usuarios usuarios){
        return dao.update(usuarios);
    }
    
    public int delete(Long id){
        return dao.delete(id);
    }
    
    public List<Usuarios> listar(){
        return dao.listar();
    }
}
