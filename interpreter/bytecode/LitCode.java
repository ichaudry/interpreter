package interpreter.bytecode;


import interpreter.VirtualMachine;
import java.util.List;

/**
 LIT n – load the literal value n LIT 0 i – this form of Lit was generated to load 0
 on the stack to initialize the variable i to the value 0 and reserve space on the
 runtime stack for i.
 E.G. LIT 5
 LIT 0 i
 */
public class LitCode extends ByteCode{
    //Integer to load onto Stack
    private int litValue;
    //Id for dumping
    private String id;


    /**
     * Initialzes variables litValue and id using arguments
     * @param args
     */
    @Override
    public void init(List<String> args) {
        litValue=Integer.parseInt(args.get(1));
        if (args.size()>2){
            id=args.get(1);
        }
    }

    /**
     * Pushes litValue onto Runtime Stack
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        vm.push(litValue);
    }

    /**
     * Used for dumping
     * @return
     */
    @Override
    public String toString() {
        if(id==null){
            return "LIT "+litValue;
        }
        return "LIT "+litValue+" "+id;
    }
}
