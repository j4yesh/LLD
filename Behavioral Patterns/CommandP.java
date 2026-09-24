
interface Command {

    public void execute();
}

class TV {

    public void turnOn() {
        System.out.println("TV is turning On...");
    }
}

class TurnOnCommand implements Command {

    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

class Remote {

    private Command cmd;

    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    public void executeCommand() {
        this.cmd.execute();
    }
}

class CommandP {

    public static void main(String[] jayesh) {
        TV tv = new TV();
        TurnOnCommand turnOn = new TurnOnCommand(tv);
        Remote remote = new Remote();
        remote.setCommand(turnOn);
        remote.executeCommand();
    }
}
