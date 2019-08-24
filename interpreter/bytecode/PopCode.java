package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

/**
 * Pop levels  of Stack. E.G POP 1 pops one level of stack
 */
public class PopCode extends ByteCode {

    //Number of levels to pop in runtime stack
    private int popCount;

    /**
     * Initializes popCount using arguments
     * @param args
     */
    @Override
    public void init(List<String> args) {
        popCount=Integer.parseInt(args.get(1));
    }

    /**
     * Calls pop function in virtual machine
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        //Use copy without altering the main variable which used for dumping
        int count=popCount;
        while(count!=0){
            vm.pop();
            count--;
        }
    }

    /**
     * Used for dumping
     * @return
     */
    @Override
    public String toString() {
        return "POP " + popCount;
    }
}
