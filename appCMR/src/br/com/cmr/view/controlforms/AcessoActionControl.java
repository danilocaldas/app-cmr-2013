/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.controller.AcessoController;
import br.com.cmr.view.Acesso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ritacosta
 */
public class AcessoActionControl implements ActionListener {

    public Acesso form;

    public AcessoActionControl(Acesso form) {
        this.form = form;
        adcionarBTN();
    }

    private void adcionarBTN() {
        form.getBtEntrar().addActionListener(this);
        form.getBtSair().addActionListener(this);
    }

    private boolean validarCampos() {
        if (form.getTxtLogin().getText().length() > 0 && form.getTxtSenha().getText().length() > 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.", "Erro de validadação!",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private void acessarSistema() {

        if (validarCampos()) {
            AcessoController acesoo = new AcessoController();
            acesoo.buscarUsuarios("" + form.getTxtLogin().getText().trim() + "",
                    "" + form.getTxtSenha().getText().trim() + "");
        }
    }
    
    private void sairSistema(){
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Entrar":
                acessarSistema();
                break;
            case "Sair":
                sairSistema();
                break;
        }
    }
}
