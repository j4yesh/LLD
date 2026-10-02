
import java.util.*;

enum ElevatorDir {
    idle, up, down
}

interface ElevatorStrategy {

    int getNextFloor(int noOfFloor,
            int curFloor,
            ElevatorDir elevatorDir,
            Queue<ElevatorReq> reqQueue);
}

interface ElevatorObserver {

}

class ElevatorReq {

    public int floor;
    public ElevatorDir direction;

    public ElevatorReq(int floor, ElevatorDir direction) {
        this.floor = floor;
        this.direction = direction;
    }
}

class Elevator implements Runnable {

    ElevatorStrategy elevatorStrategy;
    List<ElevatorObserver> elevatorObserver;
    int noOfFloor;
    int curFloor;
    boolean isRunning = true;
    ElevatorDir elevatorDir;
    Queue<ElevatorReq> reqQueue;

    Elevator(int noOfFloor, int curFloor) {
        this.noOfFloor = noOfFloor;
        this.elevatorDir = ElevatorDir.idle;
        this.reqQueue = new LinkedList<>();
    }

    void addObserver(ElevatorObserver elevatorObserver) {
        this.elevatorObserver.add(elevatorObserver);
    }

    void removeObserver(ElevatorObserver elevatorObserver) {
        this.elevatorObserver.remove(elevatorObserver);
    }

    void setElevatorStrategy(ElevatorStrategy elevatorStrategy) {
        this.elevatorStrategy = elevatorStrategy;
    }

    void addRequest(ElevatorReq elevatorReq) {
        this.reqQueue.add(elevatorReq);
    }

    @Override
    public void run() {
        // we have to make this thread safe
        while (isRunning) {
            int nextFloor = this.elevatorStrategy.getNextFloor(noOfFloor,
                    curFloor,
                    elevatorDir,
                    reqQueue);
            this.notifyGoingFromTo(curFloor, elevatorDir, nextFloor);
            Thread.sleep(3000);
            this.curFloor = nextFloor;
            this.notifyArrival(this.curFloor);
        }
    }

}

class ElevatorSystem {

    public static void main(String[] jayesh) {
        // strategy for lift schedulling
        // observer for the display
        // command for the request
        // multithreading 

    }
}
