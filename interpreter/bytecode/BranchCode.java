package interpreter.bytecode;

/**
 * This abstract class is extended by all instances of branch codes
 * e.g FalseBranch, Call, Goto
 * The two variables 'label' and 'address' are important in resolving addresses and  making jump calls.
 */

public abstract class BranchCode extends ByteCode {

    //Label to branch to
    private String label;

    //Address of label. Set by resolve address function in 'program' class
    private int Address;

    //Getter functions
    public String getLabel(){ return label;}
    public int getAddress(){return Address;}

    //Setter functions
    public void setLabel(String label){this.label=label;}
    public void setAddress(int Address){ this.Address = Address; }
}
