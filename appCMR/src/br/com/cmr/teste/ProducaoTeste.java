/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.teste;


import br.com.cmr.controller.ProducaoController;
import br.com.cmr.model.entity.Producao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class ProducaoTeste {

    public static void main(String[] args) {
        Producao producao = new Producao();
        producao.setFuncionario("Bruno");
        producao.setPrestador("HAM");
        producao.setProcedimento("ONCO");
        producao.setData(new Date(2013,11,20));
        producao.setDataEntrada(new Date(2013,11,20));
        producao.setDataDigitacao(new Date(2013,11,20));
        producao.setQuantidade("13");
        
        new ProducaoController().salvarProducao(producao);
        
        
            System.out.println(new ProducaoController().listarProducao());
        
        
        
        
//        List<Producao> list = new ArrayList<>();
//        for (Producao producao1 : list) {
//            System.out.println(producao1.getFuncionario());
//        }
        
    }
    
    
}
