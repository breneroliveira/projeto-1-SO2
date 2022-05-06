
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
    
    public Consumidor(BlockingQueue<String> fazenda, String nome) {
        this.fazenda = fazenda;
        this.nome = nome;
    }
    
    public void run() {
        int cont = 0;
      while (true) {
        try {
            System.out.println("Fazendeiro " + nome + " esperando o produto na fazenda");
            
            this.produto = fazenda.take();
            
            System.out.println("Fazendeiro " + nome + " pegou o produto: " + produto);
            
            Consumidor.sleep(5000);
            
            System.out.println("Fazendeiro " + nome + " entregou o produto: " + produto);     
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        cont++;
      }
        //System.exit(0);
    }
    
}
