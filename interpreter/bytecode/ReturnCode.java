package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.List;

/**
 RETURN <funcname>; Return from the current function;
 <funcname> is used as a comment to indicate the current function.
 RETURN is generated for intrinsic functions.
 E.G.
 RETURN f<<2>> RETURN
 Note: returns with labels functions EXECUTE THE same as returns without labels.
 */
public class ReturnCode extends ByteCode {
    private String funcName;
    //Stores return value for dumping
    private int returnValue;


    /**
     * Initializes funcName to return to
     * @param args
     */
    @Override
    public void init(List<String> args) {
        if (args.size()>1){
            funcName=args.get(1);
        }
    }

    /**
     * Jumps to return address popped from returnAddress stack.
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        returnValue=vm.peek();
        vm.popFrame();
        vm.setPc(vm.popReturnAddress()+1);
    }

    /**
     * Used for dumping with function name or return value if exist
     * @return
     */
    @Override
    public String toString() {
        if(funcName==null){
            return "RETURN";
        }
        //Keep on the alphabet part of function call. e.g continue<<3>> becomes continue
        String exitID= funcName.replaceAll("[^A-Za-z]+", "");
        return "RETURN "+exitID+"   "+"exit "+exitID+": "+returnValue;
    }
}
