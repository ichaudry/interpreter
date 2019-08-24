package interpreter;

import interpreter.bytecode.BranchCode;
import interpreter.bytecode.ByteCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    private HashMap<String,Integer> labelAddressMap=new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    //Function to add bytecode to the array list
    public void addByteCode(ByteCode byteCode){
        this.program.add(byteCode);
    }

    //Function to add label addresses to hash map
    public void mapAddresses(String label, int address){
        labelAddressMap.put(label,address);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-structure bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */

    public void resolveAddrs() {
        //Loops through the program array
        for(int i = 0; i < program.size(); i++){
            //Check if the bytecode is a branch code
            if(program.get(i) instanceof BranchCode){
                BranchCode bc = (BranchCode) program.get(i);
                String label = bc.getLabel();
                //Find address of label in map
                int jumpAddress = labelAddressMap.get(label);
                //Store address in bytecode object
                bc.setAddress(jumpAddress);
            }
        }
    }
}
