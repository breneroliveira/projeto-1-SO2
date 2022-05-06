
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
        
        Produtor produtor1 = new Produtor(fazenda, "Mel", "Abelha");
        Consumidor consumidor1 = new Consumidor(fazenda, "Brener");
        Consumidor consumidor2 = new Consumidor(fazenda, "Bruno");
        
        produtor1.start();
        consumidor1.start();
        consumidor2.start(); // Teste
;
    }
    
}
