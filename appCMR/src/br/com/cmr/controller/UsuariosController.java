/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller;

import br.com.cmr.controller.facade.UsuarioFacade;
import br.com.cmr.model.entity.Usuarios;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class UsuariosController {

    private UsuarioFacade facade;

    public UsuariosController() {
        this.facade = new UsuarioFacade();
    }

    public int save(Usuarios usuarios) {
        return facade.save(usuarios);
    }

    public int update(Usuarios usuarios) {
        return facade.update(usuarios);
    }

    public int delete(Long id) {
        return facade.delete(id);
    }
    
    public List<Usuarios> listar(){
        return facade.listar();
    }
}
