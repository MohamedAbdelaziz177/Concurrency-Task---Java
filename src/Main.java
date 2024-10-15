import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProduceAndConsume trx = new ProduceAndConsume(5, 0);

        Thread ProdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                trx.Produce();
            }
        });

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