package interpreter.bytecode;


/**
 * Halts the execution of a program
 */

import interpreter.VirtualMachine;
import java.util.List;

public class HaltCode extends ByteCode {

    /**
     * Doesn't need initializing
     * @param args
     */
    @Override
    public void init(List<String> args) {}

    /**
     * Sets the program to a false running state and stops execution of program
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.setRunning(false);
    }

    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString() {
        return "HALT";
    }
}
