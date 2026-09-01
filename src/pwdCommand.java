import java.util.ArrayList;

public class pwdCommand implements Command{


    @Override
    public void execute(ArrayList<String> arrayList) throws CommandNotCorrectException {

        System.out.println(Manager.getDir());

    }
}
