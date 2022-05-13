
package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author 20201PF.CC0033
 */

public class Main {
    
    public static void main(String[] args) {
        BlockingQueue<String> fazenda = new ArrayBlockingQueue<>(1);
        
        Integer qtdExecucoes = 20;
        
        Produtor produtor1 = new Produtor(fazenda, "Mel", "Abelha", 1000, qtdExecucoes);
        Consumidor consumidor1 = new Consumidor(fazenda, "Brener", 5000);
        Consumidor consumidor2 = new Consumidor(fazenda, "Bruno", 5000);
        Consumidor consumidor3 = new Consumidor(fazenda, "João", 5000);
        
        produtor1.start();
        consumidor1.start();
        consumidor2.start();
        consumidor3.start();

    }
    
}
