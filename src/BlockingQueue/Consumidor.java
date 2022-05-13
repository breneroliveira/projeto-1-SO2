
package BlockingQueue;

import java.util.concurrent.BlockingQueue;

/** 
 * Classe para Consumidor, onde serão contidos valores e métodos para o mesmo.
 *
 * @author Brener Augusto de Oliveira
 * @author Bruno Butka
 */
public class Consumidor extends Thread {
    
    private final BlockingQueue<String> fazenda;
    private String produto;
    private final String nome;
    private final Integer tempoEspera;

    /**
     * Método construtor que recebe a fila, nome e tempo de espera.
     * 
     * @param fazenda - Fila de retirada dos protudos.
     * @param nome - Nome do consumidor que irá retirar o produto.
     * @param tempoEspera - Tempo para que outra ação do consumidor seja realizada.
     */
    public Consumidor(BlockingQueue<String> fazenda, String nome, Integer tempoEspera) {
        this.fazenda = fazenda;
        this.nome = nome;
        this.tempoEspera = tempoEspera;
    }
    
    /**
     * Método em que o fazendeiro faz a retirada do produto da fila, após um determinado
     * tempo de espera, ele poderá realizar a retirada novamente.
     * Também, o loop será encerrado quando a classe Produtor chegar ao fim do seu loop.
     */
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