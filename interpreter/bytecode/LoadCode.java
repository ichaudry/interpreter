package interpreter.bytecode;


import interpreter.VirtualMachine;
import java.util.List;

/**
 LOAD n <id> ; push the value in the slot which is offset n from
 the start of the frame onto the top of the stack; <id> is used as a
 comment and for dumping, it’s the variable name where the data is loaded.
 E.G. LOAD 3
 LOAD 2 i
 */
public class LoadCode extends ByteCode{
    //Offset to load from
    private int offset;
    //Id used for dumping
    private String id;

    /**
     * Initializes offset and id using arguments
     * @param args
     */
    @Override
    public void init(List<String> args) {
        offset=Integer.parseInt(args.get(1));

        if(args.size()>2){
            id=args.get(2);
        }
    }

    /**
     * Push value at offset in stack on to top  of stack
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    /**
     * Used for dumping. With or without id.
     * @return
     */
    @Override
    public String toString() {if(id==null){
        return "LOAD "+offset;
    }
        return "LOAD "+offset+" "+id;
    }
}
