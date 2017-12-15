package Task8___28_11_2017;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public enum Command {
    MULTIPLY{
        @Override
        public void makeOperation(Deque<Double> d){
            d.push( d.pop()*d.pop() );
        }

        @Override
        public int getPriority() {
            return 1;
        }
    },

    DIVIDE{
        @Override
        public void makeOperation(Deque<Double> d){
            Double d2 = d.pop();
            Double d1 = d.pop();
            d.push(d1/d2 );
        }

        @Override
        public int getPriority() {
            return 1;
        }
    },

    PLUS{
        @Override
        public void makeOperation(Deque<Double> d){
            d.push(d.pop()+d.pop() );
        }

        @Override
        public int getPriority() {
            return 2;
        }
    },
    MINUS{
        @Override
        public void makeOperation(Deque<Double> d){
            Double d2 = d.pop();
            Double d1 = d.pop();
            d.push(d1-d2 );
        }
        @Override
        public int getPriority() {
            return 2;
        }
    },
    SIN{
        @Override
        public void makeOperation(Deque<Double> d){
            d.push( Math.sin(d.pop()) );
        }

        @Override
        public int getPriority() {
            return -1;
        }
    },
    COS{
        @Override
        public void makeOperation(Deque<Double> d){
            d.push( Math.cos(d.pop()) );
        }

        @Override
        public int getPriority() {
            return -1;
        }
    };

    public void makeOperation(Deque<Double> deque){}

    public int getPriority(){return 0;}


    public static Map<String, Command> getMap() {
        return map;
    }

    public static Map<String, Command> map = new HashMap<>();
    static {
        map.put("*", Command.MULTIPLY);
        map.put("/", Command.DIVIDE);
        map.put("+", Command.PLUS);
        map.put("-", Command.MINUS);
        map.put("sin(", Command.SIN);
        map.put("cos(", Command.COS);
    }
}
