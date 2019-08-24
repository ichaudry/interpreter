package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.List;

/**
 * Used to jump to a label
 * e.g GOTO <label>
 */
public class GotoCode extends BranchCode {

    /**
     * Sets label to branch to. Used to resolving address.
     * @param args
     */
    @Override
    public void init(List<String> args) {
        setLabel(args.get(1));
    }

    /**
     * Branches to the address at label
     * @param vm
     */
    @Override
    public void execute (VirtualMachine vm){
        vm.setPc(getAddress()-1);
    }


    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString () {
        return "GOTO "+getLabel();
    }
}
