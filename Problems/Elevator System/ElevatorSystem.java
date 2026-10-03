
import java.util.*;

enum ElevatorDir {
    idle, up, down
}

class ElevatorReq {

    public int floor;
    public ElevatorDir direction;

    public ElevatorReq(int floor, ElevatorDir direction) {
        this.floor = floor;
        this.direction = direction;
    }
}


interface ElevatorStrategy extends Runnable{
    void submitReq(ElevatorReq elevatorReq);
    void setElevator(Elevator e);
}

class Display{
    private static volatile Display instance;

    public static Display getInstance() {
        if(instance ==null){
            synchronized (Display.class) {
                if(instance == null){
                    instance = new Display();
                }
            }
            return instance;
        }
        return instance;
    }

    public void notifySignal(String msg){
        System.out.println(msg);
    }

    public void notifyGoingFromTo(int curFloor,ElevatorDir elevatorDir,int nextFloor){
    
            this.notifySignal("Currently at "+curFloor+" Going "+elevatorDir+" "+"for the "+nextFloor+" floor");
        
    }
    public void notifyArrival(int curFloor,ElevatorDir elevatorDir){
            this.notifySignal("Arrived at the "+curFloor+ " ,direction"+elevatorDir);
        
    }

    public void notifyReqReceived(ElevatorReq elevatorReq){
            this.notifySignal("Just received the request for floor : "+elevatorReq.floor+" ,Dir. "+elevatorReq.direction);
    }

    public void notifyIdle(int floor){
                 this.notifySignal("Elevator is Idle at floor : "+floor);
    }
}


class FCFSstrategy implements ElevatorStrategy{
    Elevator elevator;

    public void setElevator(Elevator elevator){
        this.elevator = elevator;
    }

    @Override
    public void run() {
        while (elevator.isRunning) {
            ElevatorReq req;

            synchronized (this) {
                while (elevator.reqQueue.isEmpty() && elevator.isRunning) {
                    try {
                        Display.getInstance().notifyIdle(elevator.curFloor);
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (!elevator.isRunning) {
                    return;
                }

                req = elevator.reqQueue.poll();
            }

            // Lock released: accept new requests while moving.
            Display.getInstance().notifyGoingFromTo(
                elevator.curFloor, req.direction, req.floor
            );

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            elevator.curFloor = req.floor;
            elevator.elevatorDir = req.direction;

            Display.getInstance().notifyArrival(
                elevator.curFloor, elevator.elevatorDir
            );
        }
    }

    public void submitReq(ElevatorReq elevatorReq){
        synchronized (this) {
            elevator.reqQueue.add(elevatorReq);
            notify();
        }
        Display.getInstance().notifyReqReceived(elevatorReq);
    }
}

class Elevator {
    ElevatorStrategy elevatorStrategy;
    int noOfFloor;
    int curFloor;
    volatile boolean isRunning = true;
    ElevatorDir elevatorDir;
    Queue<ElevatorReq> reqQueue;

    Elevator(int noOfFloor, int curFloor) {
        this.noOfFloor = noOfFloor;
        this.curFloor = curFloor;
        this.elevatorDir = ElevatorDir.idle;
        this.reqQueue = new LinkedList<>();
    }

    void submitReq(ElevatorReq elevatorReq){
        this.elevatorStrategy.submitReq(elevatorReq);
    }

    void setElevatorStrategy(ElevatorStrategy elevatorStrategy) {
        this.elevatorStrategy = elevatorStrategy;
        this.elevatorStrategy.setElevator(this);
        new Thread(this.elevatorStrategy).start();
    }

}


class ElevatorSystem {

    public static void main(String[] jayesh) {
        // command for the request Done
        // singletone for the display Done
        // strategy for lift scheduling -> Lets get with FCFS -> FCFS Done
        // strategy for lift scheduling -> LOOK
        // Request submission , will put in same shared Queue
        // multithreading 
        Elevator elevator = new Elevator(10,2);
        ElevatorStrategy elevatorStrategy = new FCFSstrategy();
        elevator.setElevatorStrategy(elevatorStrategy);
        // elevator.submitReq(new ElevatorReq(8,ElevatorDir.up));
        // elevator.submitReq(new ElevatorReq(5,ElevatorDir.up));
        // elevator.submitReq(new ElevatorReq(7,ElevatorDir.up));
        Scanner sc = new Scanner(System.in);
        while(true){
            int floor = sc.nextInt();
            String direction = sc.next();
            if (floor < 0 || floor > elevator.noOfFloor) {
                System.out.println("Invalid floor");
                continue;
            }

            if (direction.equalsIgnoreCase("up")) {
                elevator.submitReq(new ElevatorReq(floor, ElevatorDir.up));
            } else if (direction.equalsIgnoreCase("down")) {
                elevator.submitReq(new ElevatorReq(floor, ElevatorDir.down));
            } else {
                System.out.println("Invalid direction. Use up or down.");
            }
        }
    }
}
