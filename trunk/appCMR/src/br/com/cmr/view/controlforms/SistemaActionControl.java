/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.view.FormProducaoMedica;
import br.com.cmr.view.FormSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author ritacosta
 */
public class SistemaActionControl implements ActionListener{
    
    public FormSistema form;

    public SistemaActionControl(FormSistema form) {
        this.form = form;
        addControlBtMenusForm();
    }
    
    private void addControlBtMenusForm(){
        form.getMenuProducaoMedica().addActionListener(this);
    }

    private void abrirProducaoMedica(){
        FormProducaoMedica formSis = new FormProducaoMedica();
        form.getjDesktopPaneSistema().add(formSis);
        formSis.show();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Produção Médica")){
            abrirProducaoMedica();
        }
    }
    
}
