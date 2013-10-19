/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view;

import br.com.cmr.view.controlforms.SistemaActionControl;

/**
 *
 * @author ritacosta
 */
public class FormSistema extends javax.swing.JFrame {

    public SistemaActionControl control;
    /**
     * Creates new form FormSistema
     */
    public FormSistema() {
        initComponents();
        control = new SistemaActionControl(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneSistema = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuInicio = new javax.swing.JMenu();
        menuTrocarUsuario = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        menuAnaliseMedica = new javax.swing.JMenu();
        menuProducaoMedica = new javax.swing.JMenuItem();
        menuDigitacao = new javax.swing.JMenu();
        menuProdDigitadores = new javax.swing.JMenuItem();
        menuManutencao = new javax.swing.JMenu();
        menuFuncionarios = new javax.swing.JMenuItem();
        menuPrestadores = new javax.swing.JMenuItem();
        menuProcedimentos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Núcleo APAC/AIH - CMR");
        setResizable(false);

        jDesktopPaneSistema.setBackground(new java.awt.Color(255, 255, 255));

        MenuInicio.setText("Inicio");

        menuTrocarUsuario.setText("Trocar usuário");
        MenuInicio.add(menuTrocarUsuario);

        menuSair.setText("Sair");
        MenuInicio.add(menuSair);

        jMenuBar1.add(MenuInicio);

        menuAnaliseMedica.setText("Analise Médica");

        menuProducaoMedica.setText("Produção Médica");
        menuAnaliseMedica.add(menuProducaoMedica);

        jMenuBar1.add(menuAnaliseMedica);

        menuDigitacao.setText("Digitação");

        menuProdDigitadores.setText("Produção digitadores");
        menuDigitacao.add(menuProdDigitadores);

        jMenuBar1.add(menuDigitacao);

        menuManutencao.setText("Manutenção");

        menuFuncionarios.setText("Funcionários");
        menuManutencao.add(menuFuncionarios);

        menuPrestadores.setText("Prestadores");
        menuManutencao.add(menuPrestadores);

        menuProcedimentos.setText("Procedimentos");
        menuManutencao.add(menuProcedimentos);

        jMenuBar1.add(menuManutencao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSistema().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuInicio;
    private javax.swing.JDesktopPane jDesktopPaneSistema;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAnaliseMedica;
    private javax.swing.JMenu menuDigitacao;
    private javax.swing.JMenuItem menuFuncionarios;
    private javax.swing.JMenu menuManutencao;
    private javax.swing.JMenuItem menuPrestadores;
    private javax.swing.JMenuItem menuProcedimentos;
    private javax.swing.JMenuItem menuProdDigitadores;
    private javax.swing.JMenuItem menuProducaoMedica;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuTrocarUsuario;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JMenuItem getMenuProducaoMedica() {
        return menuProducaoMedica;
    }

    public void setMenuProducaoMedica(javax.swing.JMenuItem menuProducaoMedica) {
        this.menuProducaoMedica = menuProducaoMedica;
    }

    public javax.swing.JMenuItem getMenuFuncionarios() {
        return menuFuncionarios;
    }

    public void setMenuFuncionarios(javax.swing.JMenuItem menuFuncionarios) {
        this.menuFuncionarios = menuFuncionarios;
    }

    public javax.swing.JMenuItem getMenuPrestadores() {
        return menuPrestadores;
    }

    public void setMenuPrestadores(javax.swing.JMenuItem menuPrestadores) {
        this.menuPrestadores = menuPrestadores;
    }

    public javax.swing.JMenuItem getMenuProcedimentos() {
        return menuProcedimentos;
    }

    public void setMenuProcedimentos(javax.swing.JMenuItem menuProcedimentos) {
        this.menuProcedimentos = menuProcedimentos;
    }

    public javax.swing.JMenuItem getMenuProdDigitadores() {
        return menuProdDigitadores;
    }

    public void setMenuProdDigitadores(javax.swing.JMenuItem menuProdDigitadores) {
        this.menuProdDigitadores = menuProdDigitadores;
    }

    public javax.swing.JMenuItem getMenuSair() {
        return menuSair;
    }

    public void setMenuSair(javax.swing.JMenuItem menuSair) {
        this.menuSair = menuSair;
    }

    public javax.swing.JMenuItem getMenuTrocarUsuario() {
        return menuTrocarUsuario;
    }

    public void setMenuTrocarUsuario(javax.swing.JMenuItem menuTrocarUsuario) {
        this.menuTrocarUsuario = menuTrocarUsuario;
    }

    public javax.swing.JDesktopPane getjDesktopPaneSistema() {
        return jDesktopPaneSistema;
    }

    public void setjDesktopPaneSistema(javax.swing.JDesktopPane jDesktopPaneSistema) {
        this.jDesktopPaneSistema = jDesktopPaneSistema;
    }

    public javax.swing.JMenu getMenuInicio() {
        return MenuInicio;
    }

    public void setMenuInicio(javax.swing.JMenu MenuInicio) {
        this.MenuInicio = MenuInicio;
    }

    public javax.swing.JMenu getMenuAnaliseMedica() {
        return menuAnaliseMedica;
    }

    public void setMenuAnaliseMedica(javax.swing.JMenu menuAnaliseMedica) {
        this.menuAnaliseMedica = menuAnaliseMedica;
    }

    public javax.swing.JMenu getMenuDigitacao() {
        return menuDigitacao;
    }

    public void setMenuDigitacao(javax.swing.JMenu menuDigitacao) {
        this.menuDigitacao = menuDigitacao;
    }

    public javax.swing.JMenu getMenuManutencao() {
        return menuManutencao;
    }

    public void setMenuManutencao(javax.swing.JMenu menuManutencao) {
        this.menuManutencao = menuManutencao;
    }
    
       
}
