package Exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        //список ходов 1 игрока
        List<Action> actionList1 = new ArrayList<Action>();

        actionList1.add(Action.NOJNICI);
        actionList1.add(Action.BUMAGA);
        actionList1.add(Action.NOJNICI);

        //список ходов 2 игрока
        List<Action> actionList2 = new ArrayList<>();

        actionList2.add(Action. BUMAGA);
        actionList2.add(Action.KAMEN);
        actionList2.add(Action.KAMEN);

        new BestFriend("Anna",exchanger,actionList1);
        new BestFriend("Nina",exchanger,actionList2);
    }
}

enum Action {
    KAMEN, NOJNICI, BUMAGA
}

class BestFriend extends Thread {
    private String name;
    private Exchanger<Action> exchanger;
    private List<Action> myAction;

    public BestFriend(String name, Exchanger<Action> exchanger, List<Action> myAction) {
        this.name = name;
        this.exchanger = exchanger;
        this.myAction = myAction;
        this.start();
    }

    private void whoWins(Action myAction, Action friendAction) {
        if ((myAction == Action.KAMEN && friendAction == Action.NOJNICI)
                || (myAction == Action.NOJNICI && friendAction == Action.BUMAGA)
                || (myAction == Action.BUMAGA && friendAction == Action.KAMEN)){
            System.out.println(name + " wins");
        }
    }

    @Override
    public void run() {
        Action reply;

        for (Action action:myAction){
            try {
                reply = exchanger.exchange(action);
                whoWins(action,reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


