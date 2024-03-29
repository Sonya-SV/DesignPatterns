
public class CommandApp {
    public static void main(String[] args) {
        Comp c = new Comp();
        User user = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();

    }
}

interface Command {
    void execute();
}

class Comp {
    void start() {
        System.out.println("start");
    }

    void stop() {
        System.out.println("stop");
    }

    void reset() {
        System.out.println("reset");
    }
}

class StartCommand implements Command {
    Comp computer;

    public StartCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}
class StopCommand implements Command {
    Comp computer;

    public StopCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements Command {
    Comp computer;

    public ResetCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

//Invoker
class User {
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }
}