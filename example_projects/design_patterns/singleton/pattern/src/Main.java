import worker.Worker;

public class Main {
    public static void main(String[] args) {
        Worker workerOne = new Worker();
        Worker workerTwo = new Worker(); // uses same database

        for (int i = 0; i < 5; i++) {
            workerOne.writeToDatabase(Integer.toString(i));
            workerTwo.writeToDatabase(Integer.toString(i + 110));
        }
    }
}
