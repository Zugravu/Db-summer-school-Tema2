import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Integer carsNS = 7; // Number of cars that have to pass the intersection from North to South
        Integer carsWE = 10; // Number of cars that have to pass the intersection from West to East
        Road roadNS = new Road(semaphore,"NS", carsNS); // Created the North-South road
        Road roadWE = new Road(semaphore,"WE", carsWE); // Created the West-East road

        roadNS.crossRoad();
        roadNS.join();
        roadWE.crossRoad();
        roadWE.join();
    }
}
