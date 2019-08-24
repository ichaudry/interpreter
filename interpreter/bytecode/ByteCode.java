package interpreter.bytecode;


import interpreter.VirtualMachine;

import java.util.List;

public abstract class ByteCode {

    /**
     * Initializes bytecodes using arguments from a list
     * @param ags
     */
    public abstract void init(List<String> ags);

    /**
     *Perform bytecode specific execution while program is running.
     * @param vm
     */
    public abstract void execute(VirtualMachine vm);

    /**
     * Used for dumping
     * @return
     */
    public abstract String toString();
}

