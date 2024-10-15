import java.util.*;

public class ProduceAndConsume {

    private final int bottom;
    private final int top;
    private int i = 0;
    List<Integer>Container;
    private static final Object lock = new Object();

    // Intiallizing top & bot values
    public ProduceAndConsume(int top, int bottom)
    {
        this.top = top;
        this.bottom = bottom;
        this.Container = new ArrayList<Integer>();
    }


    // Handling the Synchoronusization of Produce function
    public void Produce()
    {
        synchronized(lock)
        {
            while(true)
            {

                if(Container.size() <= top)
                {
                    System.out.println("Produced one more element, Element no: " + i);
                    Container.add(i++);
                    lock.notify();
                }

                else
                {
                    System.out.println("Max Top is reached, No more add and waiting for Consumption");

                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }


    // Handling the Synchoronusization of Consume function

    public void Consume()
    {
        synchronized(lock)
        {
            while (true)
            {
                if(Container.size() > bottom)
                {
                    System.out.println(Container.removeFirst() + " Removed :)");
                    lock.notify();
                }

                else
                {
                    System.out.println("Bottom is reached, No more remove and waiting for Production");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                try {
                    Thread.sleep(1500);
                }
                catch (InterruptedException e) {}
            }
        }
    }

}
