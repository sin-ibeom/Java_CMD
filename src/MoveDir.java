import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MoveDir implements Command{


    @Override
    public void execute(ArrayList<String> arrayList) throws CommandNotCorrectException {
        if(arrayList.size() == 2){
            if(!(arrayList.get(1).isEmpty())){
                String moveDir = arrayList.get(1).toString().trim();

                switch (moveDir){
                    case "..":
                        if(Manager.getDir().equals("C:\\")) break;
                        File temp = new File(Manager.getDir());
                        System.out.println(temp.getParent());
                        Manager.setDir(temp.getParent().toString());
                        break;
                    case "~":
                        Manager.setDir(Manager.getDefault());
                        break;

                    default:
                        if(!(Manager.getDir().charAt(Manager.getDir().length() - 1) == '\\')){
                            String temp4 = "\\" + moveDir;
                            moveDir = temp4;
                        }

                        String temp1 = Manager.getDir() + moveDir;
                        moveDir = temp1;
                        System.out.println("default");
                        System.out.println(moveDir);

                        try{

                            File f = new File(moveDir);
                            if(f.isDirectory()){
                                Manager.setDir(moveDir);
                            } else {
                                throw new FileNotFoundException();
                            }
                        }catch(FileNotFoundException e){
                            System.out.println("폴더 경로가 올바르지 않습니다.");
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                        break;
                }
                if(moveDir.equals("..")){

                }
                if(moveDir.equals('~')){

                }
            }

        } else if(arrayList.size() == 1) {
            if(arrayList.get(0).equals("cd")){
                Manager.setDir(Manager.getDefault());
            }
        } else {
            throw new CommandNotCorrectException();
        }

    }
}
