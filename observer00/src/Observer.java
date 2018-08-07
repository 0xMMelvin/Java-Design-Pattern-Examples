import java.util.Scanner;

abstract class Observer {
    protected TheSubject subj;

    public abstract void update();
}

class HexObserver extends Observer {
    public HexObserver(TheSubject s) {
        subj = s;
        subj.attach(this);
    }

    public void update() {
        System.out.print(" " + Integer.toHexString(subj.getState()));
    }
} // Observers "pull" information

class OctObserver extends Observer {
    public OctObserver(TheSubject s) {
        subj = s;
        subj.attach(this);
    }

    public void update() {
        System.out.print(" " + Integer.toOctalString(subj.getState()));
    }
} // Observers "pull" information

class BinObserver extends Observer {
    public BinObserver(TheSubject s) {
        subj = s;
        subj.attach(this);
    } // Observers register themselves

    public void update() {
        System.out.print(" " + Integer.toBinaryString(subj.getState()));
    }
}

class TheSubject {
    private Observer[] observers = new Observer[9];
    private int totalObs = 0;
    private int state;

    public void attach(Observer o) {
        observers[totalObs++] = o;
    }

    public int getState() {
        return state;
    }

    public void setState(int in) {
        state = in;
        notifyObservers();
    }

    private void notifyObservers() {
        for (int i = 0; i < totalObs; i++) {
            observers[i].update();
        }
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        TheSubject sub = new TheSubject();
        // Client configures the number and type of Observers
        new HexObserver(sub);
        new OctObserver(sub);
        new BinObserver(sub);
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a number: ");
            sub.setState(scan.nextInt());
        }
    }
}
