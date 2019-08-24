package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

/**BOP <binary op> , pop top 2 levels of the stack and perform the indicated operation ,
 operations are + - / * == != <= > >= < | &  | and & are logical operators not
 bitwise operators. Lower level is the secondLevel operand: Eg: <topLevel-level> + <top-level>
 E.G.
 BOP +
 BOP -
 BOP /
 */
public class BopCode extends ByteCode{
    //Operator that needs to be executed
    private String operator;

    /**
     * Sets the operator that will be used in execute function
     * @param args
     */
    @Override
    public void init(List<String> args) {
        operator= args.get(1);
    }

    /**
     *Pops two levels of the runtime stack and performs an operation on them depending on what operator is passed in.
     * Switch case is used to perform the operator specific operation.
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {

        int topLevel = vm.pop();
        int secondLevel= vm.pop();

        int result = 0;
        switch(operator) {
            case "+":
                result = secondLevel+topLevel;
                break;
            case "-":
                result = secondLevel-topLevel;
                break;
            case "*":
                result=secondLevel*topLevel;
                break;
            case "/":
                result=secondLevel/topLevel;
                break;
            case "==":
                result=secondLevel==topLevel?1:0;
                break;
            case "!=":
                result=secondLevel!=topLevel?1:0;
                break;
            case "<":
                result=secondLevel<topLevel?1:0;
                break;
            case "<=":
                result=secondLevel<=topLevel?1:0;
                break;
            case ">":
                result=secondLevel>topLevel?1:0;
                break;
            case ">=":
                result=secondLevel>=topLevel?1:0;
                break;
            case "|":
                result=(secondLevel!=0)||(topLevel!=0)?1:0;
                break;
            case "&":
                result=(secondLevel!=0)&&(topLevel!=0)?1:0;
        }

        vm.push(result);
    }

    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString() {
        return "BOP "+operator;
    }
}
