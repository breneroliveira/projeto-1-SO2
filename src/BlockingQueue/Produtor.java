
package BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author 20201PF.CC0033
 */

public class Produtor extends Thread {
    
    private final BlockingQueue<String> fazenda;
    private final String produto;
    private final String nome;
    private final Integer tempoEspera;
    private final Integer qtdExecucoes;
    
    public Produtor(BlockingQueue<String> fazenda, String produto, String nome, Integer tempoEspera, Integer qtdExecucoes) {
        this.fazenda = fazenda;
        this.produto = produto;
        this.nome = nome;
        this.tempoEspera = tempoEspera;
        this.qtdExecucoes = qtdExecucoes;
    }
    
    public void run() {
        int cont = 0;
      while (cont < qtdExecucoes) {
        try {
            if(fazenda.size()==1){
                System.out.println("A " + nome + " esperando a fazenda ter espaço");
            }
            else{
                System.out.println("A " + nome + " produziu " + this.produto + " na fazenda");
                this.fazenda.put(produto);
            }
            Produtor.sleep(tempoEspera);
            
            //System.out.println("A " + nome + " irá produzir novamente");
            
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
