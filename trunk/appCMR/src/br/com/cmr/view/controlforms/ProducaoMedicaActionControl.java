/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.controlforms;

import br.com.cmr.controller.FuncionarioController;
import br.com.cmr.controller.PrestadorController;
import br.com.cmr.controller.ProcedimentoController;
import br.com.cmr.controller.ProducaoMedicaController;
import br.com.cmr.model.entity.Funcionario;
import br.com.cmr.model.entity.Prestador;
import br.com.cmr.model.entity.Procedimento;
import br.com.cmr.model.entity.ProducaoMedica;
import br.com.cmr.view.FormProducaoMedica;
import br.com.cmr.view.tables.ProducaoMedicaCellRenderer;
import br.com.cmr.view.tables.ProducaoMedicaTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ritacosta
 */
public class ProducaoMedicaActionControl implements ActionListener {

    private FormProducaoMedica form;
    public List<Procedimento> listProdimento;
    public List<Prestador> listPrestador;
    public List<Funcionario> listFuncionario;
    public List<ProducaoMedica> listProducaoMedica;
    private Long idProducaoMedica;

    public ProducaoMedicaActionControl(FormProducaoMedica form) {
        this.form = form;
        addControleBtn();
        refreshCombo();
        refreshTable();
        enableFilds(false);
        //DBConnection.createTableProducaoMedica();
        
    }
    
    private void addControleBtn(){
        form.getBtNovo().addActionListener(this);
        form.getBtAtualizar().addActionListener(this);
        form.getBtSalvar().addActionListener(this);
        form.getBtExcluir().addActionListener(this);
        form.getBtCancelar().addActionListener(this);
    }
    
    private void refreshCombo() {
        listFuncionario = new FuncionarioController().findNome("%%");
        listPrestador = new PrestadorController().findNome("%%");
        listProdimento = new ProcedimentoController().finfNome("%%");
        form.getComboFuncionario().removeAllItems();
        form.getComboPrestador().removeAllItems();
        form.getComboProcedimento().removeAllItems();

        if (listFuncionario != null) {
            for (int i = 0; i < listFuncionario.size(); i++) {
                form.getComboFuncionario().addItem(listFuncionario.get(i).getNome());
            }
        }
        if (listPrestador != null) {
            for (int i = 0; i < listPrestador.size(); i++) {
                form.getComboPrestador().addItem(listPrestador.get(i).getNome());
            }
        }
        if (listProdimento != null) {
            for (int i = 0; i < listProdimento.size(); i++) {
                form.getComboProcedimento().addItem(listProdimento.get(i).getNome());
            }
        }
    }
    
    private void mostraDadosTable() {
        if (listProducaoMedica != null) {
            form.getTbProducaoMedica().setModel(new ProducaoMedicaTableModel(listProducaoMedica));
            form.getTbProducaoMedica().setDefaultRenderer(Object.class, new ProducaoMedicaCellRenderer());
        }
    }
    
    private void refreshTable() {
        listProducaoMedica = new ProducaoMedicaController().listarProducao();
        mostraDadosTable();
    }
    
    private void enableFilds(boolean enabled) {
        form.getTxtDataEntrada().setEnabled(enabled);
        form.getComboPrestador().setEnabled(enabled);
        form.getComboProcedimento().setEnabled(enabled);
        form.getTxtQtdLaudos().setEnabled(enabled);
        form.getTxtDataAnalise().setEnabled(enabled);
        form.getComboFuncionario().setEnabled(enabled);
        form.getTxtEncaminhamento().setEnabled(enabled);
        form.getTxtNucleos().setEnabled(enabled);
    }

    private void onCancelar() {
        form.getTxtDataAnalise().setDate(null);
        form.getTxtEncaminhamento().setDate(null);
        form.getTxtDataEntrada().setDate(null);
        form.getTxtQtdLaudos().setText("");
        form.getTxtNucleos().setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Novo":
                enableFilds(true);
                break;
            case "Cancelar":
                onCancelar();
                enableFilds(false);
                break;
            case "Salvar":
                onSaveProducao();
                break;
            case "Atualizar":
                onAlterarProducao();
                break;
            case "Excluir":
                removerProducao();
                break;
        }
    }
    
    private boolean verificarPreencherDatas() {
        if (form.getTxtDataEntrada().getDate() == null && form.getTxtDataAnalise().getDate() == null 
                && form.getTxtEncaminhamento().getDate() == null &&
                form.getTxtQtdLaudos().getText().length() <= 0 && form.getTxtNucleos().getText().equals("")) {
            return false;
        } else {
            return true;
        }
    }
    
    private void onSaveProducao() {
        ProducaoMedica pMedica = new ProducaoMedica();
        if (verificarPreencherDatas()) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dataEntrada = (java.util.Date) form.getTxtDataEntrada().getDate();
            java.util.Date dataAnalise = (java.util.Date) form.getTxtDataAnalise().getDate();
            java.util.Date dataEncaminhamento = (java.util.Date) form.getTxtEncaminhamento().getDate();
            pMedica.setEntradaCmr(Date.valueOf(formato.format(dataEntrada)));
            pMedica.setPrestador(form.getComboPrestador().getSelectedItem().toString());
            pMedica.setProcedimento(form.getComboProcedimento().getSelectedItem().toString());
            pMedica.setQuantidade(Integer.parseInt(form.getTxtQtdLaudos().getText()));
            pMedica.setAnalise(Date.valueOf(formato.format(dataAnalise)));
            pMedica.setFuncionario(form.getComboFuncionario().getSelectedItem().toString());
            pMedica.setEncaminhamento(Date.valueOf(formato.format(dataEncaminhamento)));
            pMedica.setNucleos(form.getTxtNucleos().getText().trim());
        } else {
            JOptionPane.showMessageDialog(form, "Todos os campos são obrigatórios!");
            return;
        }

        int result = 0;
        if (idProducaoMedica == null) {
            result = new ProducaoMedicaController().salvarProducaoMedica(pMedica);
        } else {
            pMedica.setId(idProducaoMedica);
            result = new ProducaoMedicaController().atualizarProducaoMedica(pMedica);
            idProducaoMedica = null;
        }
        if (result == 1) {
            JOptionPane.showMessageDialog(form, "Produção inserido com sucesso!");
            enableFilds(false);
            onCancelar();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(form, "Tente novamente!");
        }
    }
    
    private void onAlterarProducao() {
        int indexRow = form.getTbProducaoMedica().getSelectedRow();
        if (indexRow == -1) {
            JOptionPane.showMessageDialog(form, "Selecione a produção a ser alterada!");
            return;
        }
        ProducaoMedica pMedica = new ProducaoMedicaTableModel(listProducaoMedica).get(indexRow);
        
        idProducaoMedica = pMedica.getId();
        form.getTxtDataEntrada().setDate(pMedica.getEntradaCmr());
        form.getComboPrestador().setSelectedItem(pMedica.getPrestador());
        form.getComboProcedimento().setSelectedItem(pMedica.getProcedimento());
        form.getTxtQtdLaudos().setValue(pMedica.getQuantidade());
        form.getTxtDataAnalise().setDate(pMedica.getAnalise());
        form.getComboFuncionario().setSelectedItem(pMedica.getFuncionario());
        form.getTxtEncaminhamento().setDate(pMedica.getEncaminhamento());
        form.getTxtNucleos().setText(pMedica.getNucleos());
        enableFilds(true);
    }
    
    private void removerProducao() {
        int indexRow = form.getTbProducaoMedica().getSelectedRow();
        if (indexRow == -1) {
            JOptionPane.showMessageDialog(form, "Selecione a produção a ser removida!");
            return;
        }
        ProducaoMedica pMedica = new ProducaoMedicaTableModel(listProducaoMedica).get(indexRow);
        int confirm = JOptionPane.showConfirmDialog(form, "Confirmar a exclusão?", "Excluir Produção", JOptionPane.YES_NO_OPTION);
        if (confirm != 0) {
            return;
        }
        int result = new ProducaoMedicaController().deletarProducao(pMedica.getId());
        if (result == 1) {
            JOptionPane.showMessageDialog(form, "Produção removida com sucesso!");
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(form, "Tente novamente!");
        }
    }
}
