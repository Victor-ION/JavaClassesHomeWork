package Task8___28_11_2017;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    private Deque<Double> operands = new ArrayDeque<>();
    private Deque<String> commands = new ArrayDeque<>();

    public String calculate(String expr){
        expr = addOuterPar(expr);

        System.out.println(expr);

        char[] arr = expr.toCharArray();

        System.out.println("Operands: " + printDeque(operands));
        System.out.println("Commands: " + printDeque(commands));

        for (int i = 0; i < arr.length; i++){
            StringBuilder sb = new StringBuilder();
            char c = arr[i];

            System.out.println("See= "+ c);


            sb.append(c);

            //if operand
            if (sb.toString().matches("[0-9]")){
                while (Character.toString(c = arr[++i]).matches("[0-9.]")){
                    sb.append(c);
                }
                // to include last char in next cycle
                i--;
                double d = Double.parseDouble(sb.toString());
                operands.push(d);
            }
            // if some operators
            else if (sb.toString().matches("[-+/*]")){
                commands.push(sb.toString());
                tryToPop();
            }
            // if cos and sin
            else if (sb.toString().matches("[sc]")){
                sb.append(arr[++i]);
                sb.append(arr[++i]);
                sb.append(arr[++i]);
                String operator = sb.toString();
                if (operator.equals("sin(")){
                    commands.push(operator);
                } else if (operator.equals("cos(")){
                    commands.push(operator);
                } else throw new IllegalArgumentException("illegal letters!");
            }
            // if '('
            else if (sb.toString().equals("(")){
                commands.push(sb.toString());
            }
            // if ')'
            else if (sb.toString().equals(")")){
                commands.push(sb.toString());
                tryToPop();
            }
            else if (Character.isSpaceChar(c)){}
            else throw new IllegalArgumentException("can't parse expression!");

            System.out.println("Operands: " + printDeque(operands));
            System.out.println("Commands: " + printDeque(commands));
        }
        return operands.pop().toString();
    }

    public void tryToPop() {
        String currCommand = commands.pop();
        if (currCommand.equals(")")){
            while (!(currCommand = commands.pop()).equals("(") & !currCommand.equals("sin(") &
                    !currCommand.equals("cos(")){
                Command.getMap().get(currCommand).makeOperation(operands);
            }
            if (currCommand.equals("sin(") | currCommand.equals("cos(")){
                Command.getMap().get(currCommand).makeOperation(operands);
            }
        }
        else {
            String tmp;
            // should return '(' or no
            boolean wasBroke = false;
            while (!(tmp = commands.pop()).equals("(") & !tmp.equals("sin(") & !tmp.equals("cos(")){
                if (Command.getMap().get(currCommand).getPriority() >= Command.getMap().get(tmp).getPriority()){
                    Command.getMap().get(tmp).makeOperation(operands);
                } else {
                  commands.push(tmp);
                  commands.push(currCommand);
                  wasBroke = true;
                  break;
                }
            }
            if (!wasBroke){
                commands.push(tmp);
                commands.push(currCommand);
            }
        }

    }

    public String addOuterPar(String expr) {
        return '(' + expr + ')';
    }

    public String printDeque(Deque deque){
        StringBuilder sb = new StringBuilder("[ ");
        for (Object obj : deque){
            sb.append(obj.toString());
            sb.append(" | ");

        }
        if (sb.length()>3) {
            sb.delete(sb.length()-2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }
}
