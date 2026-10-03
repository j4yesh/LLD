
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

class ElevatorRes {

    public int floor;
    public ElevatorDir direction;

    public ElevatorRes(int floor, ElevatorDir direction) {
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
    public void run(){
        while (elevator.isRunning) {
            try {
                synchronized (this) {
                    if(elevator.reqQueue.isEmpty()){
                        Display.getInstance().notifyIdle(elevator.curFloor);
                        wait();
                    }
                    ElevatorReq elevatorReq = elevator.reqQueue.poll();
                    Display.getInstance().notifyGoingFromTo(elevator.curFloor, elevatorReq.direction, elevatorReq.floor);
                    int time=5;
                    while(time-->0){
                        Thread.sleep(1000);
                        // Display.getInstance().notifySignal(time+"sec remaining");
                    }
                    this.elevator.curFloor=elevatorReq.floor;
                    this.elevator.elevatorDir = elevatorReq.direction;
                }

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
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
            elevator.submitReq(new ElevatorReq(floor,direction.equals("up")?ElevatorDir.up:ElevatorDir.down));
        }
    }
}
