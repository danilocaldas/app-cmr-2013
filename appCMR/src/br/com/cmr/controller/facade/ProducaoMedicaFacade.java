/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller.facade;

import br.com.cmr.model.dao.IProducaoMedicaDAO;
import br.com.cmr.model.dao.ProducaoMedicaoDAO;
import br.com.cmr.model.entity.ProducaoMedica;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ProducaoMedicaFacade {
    
    private IProducaoMedicaDAO dao;

    public ProducaoMedicaFacade() {
        this.dao = new ProducaoMedicaoDAO();
    }
    
     public int save(ProducaoMedica pMedica){
        return dao.save(pMedica);
    }
    
    public int update(ProducaoMedica pMedica){
        return dao.updade(pMedica);
    }
    
    public int remove(Long id){
        return dao.delete(id);
    }
    public List<ProducaoMedica> findAll(){
        return dao.listar();
    }
    
}
