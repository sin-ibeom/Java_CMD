import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manager {

//    ArrayList commands = new ArrayList();
    Map<String, Command> commands = new HashMap<>();

    void run(){

        while(true){
            commands.put("ls", new FileList());
            commands.get("ls").execute();
        }

    }

}
