/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    public Produtor(BlockingQueue<String> fazenda, String produto, String nome) {
        this.fazenda = fazenda;
        this.produto = produto;
        this.nome = nome;
    }
    
    public void run() {
        int cont = 0;
      while (true) {
        try {
            if(fazenda.size()==1){
                System.out.println("A " + nome + " esperando a fazenda ter espaço");
            }
            else{
                System.out.println("A " + nome + " produziu " + this.produto + " na fazenda");
                this.fazenda.put(produto);
            }
            Produtor.sleep(1000);
            
            System.out.println("A " + nome + " irá produzir novamente");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        cont++;
      }
        //System.exit(0);      
    }
    
}
