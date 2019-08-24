package interpreter.bytecode;
import interpreter.VirtualMachine;
import java.util.List;

/**
 * LabelCode marks the beginning of functions and is useed by branch codes to  branch to
 */
public class LabelCode extends ByteCode{
    //Stores label
    private String label;

    /**
     * Initializes label
     * @param args
     */
    @Override
    public void init(List<String> args) {
        this.label=args.get(1);
    }

    /**
     * For resolving addresses
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     * No execution required for this label
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
    }

    /**
     * For Dumping
     * @return
     */
    @Override
    public String toString() {
        return "LABEL "+getLabel();
    }
}
