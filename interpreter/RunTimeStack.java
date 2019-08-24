package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {

        //Marks Starting point of frame
        int start = 0;
        //Marks ending point of frame
        int finish;

        for (int i = 0; i < framePointer.size(); i++) {

            //New String builder in every loop to create dump output
            StringBuilder output=new StringBuilder();

            //Append open bracket of frame
            output.append("[");

            //Statement to check if frame pointer stack has next value
            if (i < framePointer.size()-1) {
                //sets finish value to the frame pointers next value
                finish = framePointer.get(i + 1);
            } else {
                //sets finish value to runtime Stack size
                finish = runTimeStack.size();
            }
            //Loop prints the runtime Stack to console
            for (int x = start; x < finish; x++) {
                //Inserts the runtime stack value without appending a comma ','
                if (x == start) {
                    output.append(runTimeStack.get(x));
                } else {
                    //append with a comma
                    output.append(","+runTimeStack.get((x)));
                    //set the next start value to the current finish to print next frame
                    start = finish;
                }
            }
            //Append closing value
            output.append("]");
            //Print output
            System.out.print(output);
        }
        //Leave line after dumping runtime stack
        System.out.println();
    }


    public int peek () {
        //To avoid out of bound exception
        if (runTimeStack.isEmpty()) {
            return 0;
        }
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public int pop () {
        //To avoid out of bound exception
        if (runTimeStack.isEmpty()) {
            return 0;
        }
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    public void newFrameAt ( int offset){
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame () {
        int returnValue = peek();
        int topFrame = framePointer.pop();
        //To prevent popping past the frame boundary
        while (runTimeStack.size() > topFrame) {
            pop();
        }
        push(returnValue);
    }

    public int store ( int offset){
        int storeValue = pop();

        //Store value at offset in current frame
        runTimeStack.set(framePointer.peek() + offset, storeValue);

        return storeValue;

    }

    public int load ( int offset){
        int loadValue = runTimeStack.get(framePointer.peek() + offset);
        push(loadValue);
        return loadValue;
    }

    public Integer push (Integer val){
        runTimeStack.add(val);
        return val;
    }
}