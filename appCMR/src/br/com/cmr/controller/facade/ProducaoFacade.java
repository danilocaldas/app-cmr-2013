/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.IProducaoDAO;
import br.com.cmr.model.dao.ProducaoDAO;
import br.com.cmr.model.entity.Producao;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ProducaoFacade {
    
    private IProducaoDAO dao;

    public ProducaoFacade() {
        this.dao = new ProducaoDAO();
    }
    
    public int save(Producao producao){
        return dao.save(producao);
    }
    
    public int update(Producao producao){
        return dao.update(producao);
    }
    
    public int remove(Long id){
        return dao.excluir(id);
    }
    public List<Producao> findAll(){
        return dao.findAll();
    }
}
