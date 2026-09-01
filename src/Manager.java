import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager {

//    ArrayList commands = new ArrayList();
    Map<String, Command> commands = new HashMap<>();
    static String dir = "C:\\";
    static String defaultDir = "C:\\";



    void run(String str){

//        while(true){
        String input = str.split(" ")[0];
        commands.put("ls", new FileList());
        commands.put("pwd", new pwdCommand());
        commands.put("cd", new MoveDir());
        commands.put("mkdir", new makeDirCommand());

        if(commands.containsKey(input)){
            CommandParser cp = new CommandParser();
            try{
                commands.get(input).execute(cp.Parser(str));
            } catch(CommandNotCorrectException e){
                System.out.println("\""+input+ "\": " + e);
            }
        } else {
            System.out.println("ELSE");
        }
//        }

    }

    public static String getDir(){
        return dir;
    }

    public static void setDir(String input){
        String temp = dir;
        dir = input;
    }

    public static String getDefault(){

        return defaultDir;
    }



}
