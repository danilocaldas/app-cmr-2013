/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.ProducaoMedica;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IProducaoMedicaDAO {

    int save(ProducaoMedica pMedica);

    int updade(ProducaoMedica pMedica);

    int delete(Long id);

    public List<ProducaoMedica> listar();
}
