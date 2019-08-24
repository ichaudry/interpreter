package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDump=true;


    protected VirtualMachine(Program program) {
        this.program = program;
    }


    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(isDump) {
                System.out.println(code.toString());
                runStack.dump();
            }
            pc++;
        }
    }

    //Halts the execution of program
    public void setRunning(boolean running) {
        isRunning = running;
    }

    //Sets the current value of pc
    public void setPc(int pc) {
        this.pc = pc;
    }

    //Sets the state of dump
    public void setDump(boolean dump) {
        isDump = dump;
    }

    //Push current pc onto return address stack
    public void pushReturnAddress(){returnAddrs.push(pc);}

    //Pop the return address from the stack
    public int popReturnAddress(){
        return (Integer)returnAddrs.pop();
    }

    //calls peek from runtime stack
    public int peek(){
        return runStack.peek();
    }

    //calls pop from runtime stack
    public int pop(){
        return runStack.pop();
    }

    //calls newframeat function from runtime stack
    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }

    //calls popframe function from runtime stack
    public void popFrame(){
        runStack.popFrame();
    }

    //calls store function from runtime Stack
    public int store(int offset){
        return runStack.store(offset);
    }

    //calls load function from runtime stack
    public int load(int offset){
        return runStack.load(offset);
    }

    //calls push function from runtime stack
    public Integer push(Integer val){
        return runStack.push(val);
    }
}