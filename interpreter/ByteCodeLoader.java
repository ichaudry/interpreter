package interpreter;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {

        //Create a new program object
        Program program=new Program();

        //List of Strings to load arguments from line
        List<String> args;

        //Code is placed inside try and catch statement to handle exceptions
        try {
            String code;

            //Loop reads all lines from the file
            while ((code=byteSource.readLine())!=null){

                //Trim String to get rid of leading and trailing whitespaces
                code.trim();

                //Split String into tokens by using whitespace as a delimiter
                String[] tokens= code.split("\\s+");

                //Convert array to list. More dynamic as compared to simple array
                args= Arrays.asList(tokens);

                //Using the string, retrieve the class name from the CodeTable.
                String className = CodeTable.getClassName(args.get(0));

                // With the class name, retrieve the Class blueprint object.
                Class c = Class.forName("interpreter.bytecode." + className);

                //Initialize a new byte code object from the blueprint
                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();

                //Pass tokens to the bytecode for initialization
                bc.init(args);

                //Load file bytecode objects in array list
                program.addByteCode(bc);

                //Map the addresses of label code in a hashmap
                if(bc instanceof LabelCode){
                    program.mapAddresses(((LabelCode) bc).getLabel(),(program.getSize()-1));
                }
            }
            program.resolveAddrs();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return program;
    }
}
