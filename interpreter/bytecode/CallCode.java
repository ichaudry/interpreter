package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.List;

/**
CALL <funcname> - transfer control to the indicated function.
 E.G.
 CALL f CALL f<<3>> Note:  CALL f and
 Call f<<3>> are executed in the same way.
 */
public class CallCode extends BranchCode {

    //Argument used for function call
    private int args;

    @Override
    public void init(List<String> args) {
        setLabel(args.get(1));
    }

    @Override
    public void execute(VirtualMachine vm) {
        //peek argument from runtime stack.For Dumping.
        args = vm.peek();
        vm.setPc(getAddress() - 1);
    }


    /**
     * For Dumping with label and args if exists
     * @return
     */
    @Override
    public String toString() {
        //Keep on the alphabet part of function call. e.g continue<<3>> becomes continue
        String label= getLabel().replaceAll("[^A-Za-z]+", "");

        if(args==0){
            return "CALL " +label+"   "+label+"()";
        }
        return "CALL " +label+"   "+label+"("+args+")";
    }
}
