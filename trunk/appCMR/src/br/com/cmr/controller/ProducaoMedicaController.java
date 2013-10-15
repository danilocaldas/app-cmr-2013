/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.controller;

import br.com.cmr.controller.facade.ProducaoMedicaFacade;
import br.com.cmr.model.entity.ProducaoMedica;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ProducaoMedicaController {
    
    private ProducaoMedicaFacade facade;
    
    public ProducaoMedicaController() {
        this.facade = new ProducaoMedicaFacade();
    }
    
    public int salvarProducaoMedica(ProducaoMedica pMedica) {
        return facade.save(pMedica);
    }

    public int atualizarProducaoMedica(ProducaoMedica pMedica) {
        return facade.update(pMedica);
    }

    public int deletarProducao(Long id) {
        return facade.remove(id);
    }

    public List<ProducaoMedica> listarProducao() {
        return facade.findAll();
    }
}
