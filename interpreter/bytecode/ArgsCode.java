package interpreter.bytecode;
import interpreter.VirtualMachine;
import java.util.List;

/**
 Used prior to calling a function.
 This instruction is immediately followed by the CALL instruction;
 the function has n args so ARGS n instructs the interpreter to set up a new frame
 n down from the top of the runtime stack.This will include the arguments in the new frame for the function.
 E.G
 ARGS 4
 ARGS 0
 ARGS 2
 */
public class ArgsCode extends ByteCode{

    //Variable stores number of arguments will pass into function
    private int numberOfArgs;

    @Override
    public void init(List<String> args) {
        //Sets the number of arguments needed for calling function
        numberOfArgs=Integer.parseInt(args.get(1));
    }

    @Override
    public void execute(VirtualMachine vm) {
        //Stores addresses to return to after called function is finished executing
        vm.pushReturnAddress();
        //Creates new frame using number of args as perimeter
        vm.newFrameAt(numberOfArgs);
    }

    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString() {
        return "ARGS "+numberOfArgs;
    }
}
