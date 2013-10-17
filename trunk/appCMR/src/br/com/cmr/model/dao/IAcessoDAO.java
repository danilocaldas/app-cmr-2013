/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Usuarios;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IAcessoDAO {
    
    List<Usuarios> pesquisar(String nome, String senha, String role_user);
}
