import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {

        ProduceAndConsume trx = new ProduceAndConsume(5, 0);

        // Creating The Thread of Production
        Thread ProdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                trx.Produce();
            }
        });

        // Creating The Thread of Consuming
        Thread ConsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                trx.Consume();
            }
        });

        ProdThread.start();
        ConsThread.start();


    }
}