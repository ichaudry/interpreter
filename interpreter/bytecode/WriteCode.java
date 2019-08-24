package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.List;

/**
 Writes the value of the top of the stack to output. Leave the value on the top of the stack
 E.G.
 WRITE
 */
public class WriteCode extends ByteCode {

    /**
     * no initialization required
     * @param args
     */
    @Override
    public void init(List<String> args) {}


    /**
     *Prints the top of the stack to console
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Result is: "+ vm.peek());
    }

    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString() {
        return "WRITE";
    }
}
