package cofre;

import java.util.ArrayList;

public class Cofrinho {
	
    public ArrayList<Moeda> listagemMoeda = new ArrayList<Moeda>(); //cria uma Array de moedas;

    public Cofrinho() {
    }

    public void adicionarMoeda(Moeda m) {
        listagemMoeda.add(m); 
    }

    public boolean removerMoeda(Moeda m) {
        for (int i = 0; i < listagemMoeda.size(); i++) {
            Moeda moedaAtual = listagemMoeda.get(i);				
            if (moedaAtual.getValor() == m.getValor()) { // Verifica se moeda atual tem o mesmo valor da moeda que o usuário deseja remover.
                listagemMoeda.remove(i);                
                return true; // Moeda encontrada e removida;
            }
        }
        return false; // Moeda não encontrada;
    }


    public void listagemMoedas() {
        	if (listagemMoeda.isEmpty()) { 
        		System.out.println("Cofrinho Vazio!"); } //condição caso a lista estiver vazia;
        	
        		else {
        		      System.out.println("Moedas no cofrinho: ");
        		        for (Moeda m : listagemMoeda) {
        		        	m.info(); //evoca as moedas adicionadas;        			
        		}
        	}        	
    }
    public double totalConvertido() {
        double total = 0;
        for (Moeda m : listagemMoeda) {
            if (m instanceof Real) {
                total += m.getValor(); //real não precisa ser convertido;
            } else if (m instanceof Dolar) {
                total += m.getValor() * 4.8; // valor do câmbio no período em que esse código foi escrito;
            } else if (m instanceof Euro) {
                total += m.getValor() * 5.3; //  valor do câmbio no período em que esse código foi escrito;
            }
        }
        return total;
    }
}