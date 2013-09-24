/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.controller.FuncionarioController;
import br.com.cmr.controller.PrestadorController;
import br.com.cmr.controller.ProcedimentoController;
import br.com.cmr.controller.ProducaoController;
import br.com.cmr.model.entity.Funcionario;
import br.com.cmr.model.entity.Prestador;
import br.com.cmr.model.entity.Procedimento;
import br.com.cmr.model.entity.Producao;
import br.com.cmr.view.FormProducao;
import br.com.cmr.view.tables.ProducaoCellRenderer;
import br.com.cmr.view.tables.ProducaoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ProducaoActionControl implements ActionListener {

    public FormProducao frm;
    public List<Producao> listProducao;
    public List<Procedimento> listProdimento;
    public List<Prestador> listPrestador;
    public List<Funcionario> listFuncionario;
    private Long idProducao;

    public ProducaoActionControl(FormProducao frm) {
        this.frm = frm;
        addButoesToForm();
        refreshTable();
        refreshCombo();
        enableFilds(false);
        frm.getTxtId().setEnabled(false);
    }

    private void refreshCombo() {
        listFuncionario = new FuncionarioController().findNome("%%");
        listPrestador = new PrestadorController().findNome("%%");
        listProdimento = new ProcedimentoController().finfNome("%%");
        frm.getComboFuncionario().removeAllItems();
        frm.getComboPrestador().removeAllItems();
        frm.getComboProcedimento().removeAllItems();

        frm.getComboPesquisaFuncionario().removeAllItems();
        frm.getComboPesquisaPrestador().removeAllItems();

        if (listFuncionario != null) {
            for (int i = 0; i < listFuncionario.size(); i++) {
                frm.getComboFuncionario().addItem(listFuncionario.get(i).getNome());
                frm.getComboPesquisaFuncionario().addItem(listFuncionario.get(i).getNome());
            }
        }
        if (listPrestador != null) {
            for (int i = 0; i < listPrestador.size(); i++) {
                frm.getComboPrestador().addItem(listPrestador.get(i).getNome());
                frm.getComboPesquisaPrestador().addItem(listPrestador.get(i).getNome());
            }
        }
        if (listProdimento != null) {
            for (int i = 0; i < listProdimento.size(); i++) {
                frm.getComboProcedimento().addItem(listProdimento.get(i).getNome());
            }
        }
    }

    private void refreshTable() {
        listProducao = new ProducaoController().listarProducao();
        if (listProducao != null) {
            frm.getTbProducao().setModel(new ProducaoTableModel(listProducao));
            frm.getTbProducao().setDefaultRenderer(Object.class, new ProducaoCellRenderer());
        }
    }

    private void enableFilds(boolean enabled) {
        frm.getComboFuncionario().setEnabled(enabled);
        frm.getComboPrestador().setEnabled(enabled);
        frm.getComboProcedimento().setEnabled(enabled);
        frm.getTxtDataDigitacão().setEnabled(enabled);
        frm.getTxtDataEntrada().setEnabled(enabled);
        frm.getTxtQuantidade().setEnabled(enabled);

    }

    private void limparCampos() {
        frm.getTxtDataDigitacão().setText("");
        frm.getTxtDataEntrada().setText("");
        frm.getTxtQuantidade().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Novo":
                enableFilds(true);
                break;

            case "Cancelar":
                limparCampos();
                enableFilds(false);
                break;

        }

    }

    private void addButoesToForm() {
        frm.getBtNovo().addActionListener(this);
        frm.getBtAtualizar().addActionListener(this);
        frm.getBtSalvar().addActionListener(this);
        frm.getBtExcluir().addActionListener(this);
        frm.getBtCancelar().addActionListener(this);
        frm.getBtPesquisar().addActionListener(this);
        frm.getRadioGeral().addActionListener(this);
        frm.getRadioFuncionario().addActionListener(this);
        frm.getRadioFuncionarioPeriodo().addActionListener(this);
        frm.getRadioPeriodo().addActionListener(this);
        frm.getRadioPrestador().addActionListener(this);
    }
}
