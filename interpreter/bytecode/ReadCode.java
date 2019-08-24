package interpreter.bytecode;


import interpreter.VirtualMachine;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 READ; Read an integer; prompt the user for input and push the value to the stack.
 Makes sure the input is validated.
 e.g.
 READ
 */
public class ReadCode extends ByteCode {
    private int input;

    /**
     * No init required
     * @param args
     */
    @Override
    public void init(List<String> args) {}

    /**
     * Prompts user for input and validates that integer is read
     * @param vm
     */
    @Override
    public void execute(VirtualMachine vm) {
        boolean isRead=false;
        while(isRead==false){
            Scanner scanner= new Scanner(System.in);
            try{
                System.out.print("Enter an Integer:");
                input=scanner.nextInt();
                vm.push(input);
                isRead=true;
            }
            catch(InputMismatchException exception){
                System.out.print("This is not an integer please enter a valid integer value...");
            }
        }
    }

    /**
     * Used for dumping
     * @return
     */
    @Override
    public String toString() {
        return "READ";
    }
}
