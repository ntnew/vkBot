package core.modules;

import java.util.Random;

public class RandomId {
    public  static int setRandomId() {
        return new Random().nextInt();
    }
}
