package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

/**
 This bytecode is used to set the state of dumping in the virtual machine.
 When dump is on, after the execution of each bytecode, the state of the runtime stack is dumped to the console.
 E.G.
 DUMP ON
 DUMP OFF
 */
public class DumpCode extends ByteCode{
    private Boolean dumpState;


    /**
     * Sets the dumpstate to True if ON is passed as argument and false if OFF is passed.
     * @param args
     */
    @Override
    public void init(List<String> args) {
        if (args.get(1).matches("ON")) {
            dumpState = true;
        }
        if(args.get(1).matches("OFF")){
            dumpState=false;
        }
    }

    /**
     * Set dump in virtual machine to dumpState
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.setDump(dumpState);
    }

    @Override
    public String toString() {
        //Dump doesn't dump itself
        return null;
    }
}
