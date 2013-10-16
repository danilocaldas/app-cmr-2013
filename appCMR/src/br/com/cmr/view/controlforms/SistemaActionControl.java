/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.view.FormSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ritacosta
 */
public class SistemaActionControl implements ActionListener{
    
    private FormSistema form;

    public SistemaActionControl(FormSistema form) {
        this.form = form;
    }
    
    private void addControlBtMenusForm(){
        form.getMenuProducaoMedica().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
