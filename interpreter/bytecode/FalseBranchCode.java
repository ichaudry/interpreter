package interpreter.bytecode;


import interpreter.VirtualMachine;
import java.util.List;


/**
 * FALSEBRANCH <label> pop the top of the stack; if it is false (0)
 then branch to <label> else execute the next bytecode
 E.G FALSEBRANCH XYZ<<3>> */
public class FalseBranchCode extends BranchCode{

    /**
     * Sets label to branch to. Used to resolving address.
     * @param args
     */
    @Override
    public void init(List<String> args) {
        setLabel(args.get(1));
    }

    /**
     * Branches to label if 0 is popped from runtime stack
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        if(vm.pop()==0){
            vm.setPc((getAddress()-1));
        }
    }

    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString() {
        return "FALSEBRANCH "+getLabel();
    }
}
