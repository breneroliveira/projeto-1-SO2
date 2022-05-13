
package BlockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Brener Augusto de Oliveira
 * @author Bruno Butka
 * 
 */

public class Produtor extends Thread {
    
    /**
    * Estrutura privada que armazena os itens inserios pela classe Produtor.
    */
    private final BlockingQueue<String> fazenda;
    private final String produto;
    private final String nome;
    
    public Produtor(BlockingQueue<String> fazenda, String produto, String nome) {
        this.fazenda = fazenda;
        this.produto = produto;
        this.nome = nome;
    }
    
    public void run() {
        int cont = 0;
        while(true) {
            try {
                if(fazenda.size() == 1){
                    System.out.println("A " + nome + " esperando a fazenda ter espaço");
                }
                else{
                    System.out.println("A " + nome + " produziu " + this.produto + " na fazenda");
                    this.fazenda.put(produto);
                }
                Produtor.sleep(1000);

                System.out.println("A " + nome + " irá produzir novamente");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            cont++;
        }
        //System.exit(0);      
    }   
}