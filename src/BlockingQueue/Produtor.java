
package BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * Classe para Produtor, onde serão contidos valores e métodos para o mesmo.
 * 
 * @author Brener Augusto de Oliveira
 * @author Bruno Butka
 */

public class Produtor extends Thread {
    
    private final BlockingQueue<String> fazenda;
    private final String produto;
    private final String nome;
    private final Integer tempoEspera;
    private final Integer qtdExecucoes;
    
    /**
     * Método construtor que recebe a fila, nome do protudo, o nome do produtor, 
     * o tempo de espera e a quantidade de execuções.
     * 
     * @param fazenda - Fila para inserção de protudos.
     * @param produto - Nome do produto a ser inserido na fila.
     * @param nome - Nome do protudor do produto.
     * @param tempoEspera - Tempo para que outra ação do consumidor seja realizada.
     * @param qtdExecucoes - Quantidade de vezes que será executado o metodo run.
     */
    public Produtor(BlockingQueue<String> fazenda, String produto, String nome, Integer tempoEspera, Integer qtdExecucoes) {
        this.fazenda = fazenda;
        this.produto = produto;
        this.nome = nome;
        this.tempoEspera = tempoEspera;
        this.qtdExecucoes = qtdExecucoes;
    }
    
    /**
     * Método em que o produtor faz a inserção do produto da fila, após um determinado
     * tempo de espera, ele poderá realizar a inserção novamente.
     * O método e executado n vezes, sendo n a o parâmetro qtdExecucoes. Após, o sistema
     * é encerrado.
     */
    public void run() {
        int cont = 0;
        while(cont < qtdExecucoes) {
            try {
                if(fazenda.size() == 1) {
                    System.out.println("A " + nome + " esperando a fazenda ter espaço");
                }
                else {
                    System.out.println("A " + nome + " produziu " + this.produto + " na fazenda");
                    this.fazenda.put(produto);
                }
                Produtor.sleep(tempoEspera);

                cont++;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            cont++;
        }
        System.exit(0);      
    }   
}