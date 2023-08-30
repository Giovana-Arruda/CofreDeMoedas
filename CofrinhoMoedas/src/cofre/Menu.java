package cofre;
import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private Cofrinho cofrinho;

    public Menu() {
        sc = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("Bem-Vindo(a) ao Cofrinho de Moedas");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar");
            System.out.println("4. Mostrar valor convertido para Real");
            System.out.println("5. Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1: //caso o usuário escolha a opção de adicionar moeda;
                    while (true) { //o programa terá um loop para que o usuário consiga adicionar quantas moedas quiser;
                        int tipoMoeda;
                        System.out.println("Que moeda deseja adicionar?");
                        System.out.println("1. Real \n2. Dólar \n3. Euro \n4. Voltar ao Menu Principal");
                        tipoMoeda = sc.nextInt();

                        if (tipoMoeda == 4) {
                            break; //quebra o loop e volta para o menu;
                        }
                        System.out.println("Qual é o valor?");
                        String valorEmString = sc.next();
                        valorEmString = valorEmString.replace(",", ".");
                        double valor = Double.valueOf(valorEmString);
                        //nesse bloco de código, atribui o valor em string e depois converti para não dar erro de exceção
                        //caso o usuário adicione o número com ponto.;

                        Moeda moeda = null;
                        if (tipoMoeda == 1) {
                            moeda = new Real(valor);
                        } else if (tipoMoeda == 2) {
                            moeda = new Dolar(valor);
                        } else if (tipoMoeda == 3) {
                            moeda = new Euro(valor);
                        } else {
                            System.out.println("Moeda inválida. Tente novamente.");
                            continue; // Reinicia o loop para escolher uma moeda válida;
                        }

                        cofrinho.adicionarMoeda(moeda);
                        System.out.println("Deseja acrescentar mais um valor?");
                        System.out.println("1. Sim \n2. Não \n3. Voltar ao Menu Principal");
                        int opcao1 = sc.nextInt();

                        if (opcao1 == 2) {
                            System.out.println("Programa finalizado com sucesso!");
                            return;
                        } else if (opcao1 == 3) {
                            break;
                        }
                    }
                    break;

                case 2: //o usuário quer retirar moedas do cofre;
                    int tipoMoeda;
                    do {
                        System.out.println("Selecione o tipo da moeda:");
                        System.out.println("1 - Real");
                        System.out.println("2 - Euro");
                        System.out.println("3 - Dolar");
                        tipoMoeda = sc.nextInt();
                    } while (tipoMoeda > 3 || tipoMoeda <= 0);

                    Moeda moedas = null;
                    if (tipoMoeda == 1) {
                        System.out.println("Qual é o valor da moeda: ");
                        String valorEmString = sc.next();
                        valorEmString = valorEmString.replace(",", ".");
                        double valor = Double.valueOf(valorEmString);
                        moedas = new Real(valor);
                    } else if (tipoMoeda == 2) {
                        System.out.println("Qual é o valor da moeda: ");
                        String valorEmString = sc.next();
                        valorEmString = valorEmString.replace(",", ".");
                        double valor = Double.valueOf(valorEmString);                        
                        moedas = new Euro(valor);
                    } else if (tipoMoeda == 3) {
                        System.out.println("Qual é o valor da moeda: ");
                        String valorEmString = sc.next();
                        valorEmString = valorEmString.replace(",", ".");
                        double valor = Double.valueOf(valorEmString);
                        moedas = new Dolar(valor);
                    }

                    // Verifica se a moeda existe na lista antes de tentar remover
                    boolean moedaRemovida = cofrinho.removerMoeda(moedas);
                    if (moedaRemovida) {
                        System.out.println("Moeda removida com sucesso!");
                    } else {
                        System.out.println("Moeda não encontrada no cofrinho.");
                    }
                    break;


                case 3: //o usuário escolheu listar todas as moedas;
                    cofrinho.listagemMoedas();
                    break;

                case 4:
                    double valorConvertido = cofrinho.totalConvertido(); //soma todos os valores das moedas e converte pra real;
                    System.out.println("O valor total convertido em reais é de: " + valorConvertido);
                    break;

                case 5: 
                    System.out.println("Programa finalizado com sucesso!");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
