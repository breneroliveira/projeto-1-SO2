
package BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author 20201PF.CC0033
 */

public class Consumidor extends Thread {
    
    private final BlockingQueue<String> fazenda;
    private String produto;
    private final String nome;
    private final Integer tempoEspera;
    //private final Integer qtdExecucoes;
    
    public Consumidor(BlockingQueue<String> fazenda, String nome, Integer tempoEspera) {
        this.fazenda = fazenda;
        this.nome = nome;
        this.tempoEspera = tempoEspera;
        //this.qtdExecucoes = qtdExecucoes;
    }
    
    public void run() {
      while (true) {
        try {
            System.out.println("Fazendeiro " + nome + " esperando o produto na fazenda");
            
            this.produto = fazenda.take();
            
            System.out.println("Fazendeiro " + nome + " pegou o produto: " + produto);
            
            Consumidor.sleep(tempoEspera);
            
            //System.out.println("Fazendeiro " + nome + " entregou o produto: " + produto);     
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      }
        //System.exit(0);
    }
    
}
