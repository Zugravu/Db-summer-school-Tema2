import java.util.concurrent.Semaphore;

public class Road extends Thread{
    private Semaphore semaphore;
    private String direction;
    private Integer noCars;

    public Road(Semaphore semaphore, String direction, Integer noCars) {
        this.semaphore = semaphore;
        this.direction = direction;
        this.noCars = noCars;
    }

    public void crossRoad() {
        System.out.println(direction + " cars getting ready to cross");
        try {
            System.out.println("Yellow light");
            Thread.sleep(600);
            semaphore.acquire(); // Give permission to the semaphore
            System.out.println("Cars preparing to go");
            Thread.sleep(600);
            System.out.println("Green light");
            while(noCars>0){ //
                System.out.println("Car number " + noCars + " is crossing the road");
                Thread.sleep(600); // I used this function so that the cars won't pass instantly
                noCars--;
            }
            System.out.println("Red light");
            semaphore.release(); // Exit the semaphore
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
