package interpreter.bytecode;


import interpreter.VirtualMachine;
import java.util.List;

/**
 STORE N <id> - pops the top of the stack; stores the value into the offset n from
 the start of the frame; <id> is used as a comment and for dumping, it’s the variable
 name where the data is stored.
 E.G.    STORE 3 i
 STORE 2
 */
public class StoreCode extends ByteCode {
    private int offset;
    private String id;

    /**
     * Initializes offset and id from arguments
     * @param args
     */
    @Override
    public void init(List<String> args) {
        offset=Integer.parseInt(args.get(1));
        if (args.size()>2){
            id=args.get(1);
        }
    }

    /**
     * Executes the store function using the offset
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    /**
     * Used for dumping with offset and id if exists
     * @return
     */
    @Override
    public String toString() {
        if(id==null){
            return "STORE "+offset;
        }
        return "LIT "+offset+" "+id;
    }
}
