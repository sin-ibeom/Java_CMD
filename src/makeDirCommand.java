import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class makeDirCommand implements Command{

    @Override
    public void execute(ArrayList<String> arrayList) throws CommandNotCorrectException {
//        String fileName = "";
        System.out.println(arrayList.get(1));

        Path fileName = Paths.get(arrayList.get(1));
        if(arrayList.size() == 2) {
            File f = new File(Manager.getDir() + "\\" + fileName);
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
