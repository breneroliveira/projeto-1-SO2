
package BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * Consumidor é a entidade usada para fazer a retirada de itens da fila.
 *
 * @author Brener Augusto de Oliveira
 * @author Bruno Butka
 * 
 */

public class Consumidor extends Thread {
    
    /**
    * Estrutura privada que armazena os itens inserios pela classe Produtor.
    */
    private final BlockingQueue<String> fazenda;
    private String produto;
    private final String nome;
    private final Integer tempoEspera;
    
    public Consumidor(BlockingQueue<String> fazenda, String nome, Integer tempoEspera) {
        this.fazenda = fazenda;
        this.nome = nome;
        this.tempoEspera = tempoEspera;
    }
    
    public void run() {
        while(true) {
            try {
                System.out.println("Fazendeiro " + nome + " esperando o produto na fazenda");

                this.produto = fazenda.take();

                System.out.println("Fazendeiro " + nome + " pegou o produto: " + produto);

                Consumidor.sleep(tempoEspera);            
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}