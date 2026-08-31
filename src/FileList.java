import com.sun.tools.javac.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileList implements Command{

    @Override
    public void execute(ArrayList<String> arrayList) throws CommandNotCorrectException {
        // 0번은 "ls" 명령어 친거
        // 1번은 파라미터
//        System.out.println(arrayList.get(0));
        if(arrayList.size() == 2){
            if(!(arrayList.get(1).isEmpty())){
                String dir = arrayList.get(1).toString();
                File f = new File(dir);
                try{
                    if(f.isDirectory() || f.isFile()){
//                        for (String fileLs : f.list()){
//                            System.out.println(fileLs);
//                        }
                        String[] strList = f.list();
                        int isprint = 0;
                        ArrayList fileList = new ArrayList(Arrays.asList(strList));
                        for(int i = 0; i < fileList.size(); i++){
                            File temp2 = new File("");
                            if(!(Manager.getDir().charAt(Manager.getDir().length() - 1) == '\\')){
                                temp2 = new File(Manager.getDir() + "\\" + fileList.get(i));
                            } else {
                                temp2 = new File(Manager.getDir() + fileList.get(i));
                            }
                            if(temp2.isHidden()){
                                continue;
                            } else if(temp2.isFile()){
                                System.out.printf("%-35s", "\u001b[34;1m" + fileList.get(i));
                            } else if(temp2.isDirectory()){
                                System.out.printf("%-35s", "\u001b[37;1m" + fileList.get(i));
                            }
                            isprint++;

                            if(isprint % 3 == 0){
                                System.out.println("");
                            }
                        }
                        System.out.println();

                    } else {
                        throw new FileNotFoundException();
                    }
                } catch(FileNotFoundException fe){
                    System.out.println(fe);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if(arrayList.size() == 1){
            File f = new File(Manager.getDir());
            try{
                if(f.isDirectory() || f.isFile()){
                    String[] strList = f.list();
                    int isprint = 0;
                    ArrayList fileList = new ArrayList(Arrays.asList(strList));
                    for(int i = 0; i < fileList.size(); i++){
                        File temp2 = new File("");
                        if(!(Manager.getDir().charAt(Manager.getDir().length() - 1) == '\\')){
                            temp2 = new File(Manager.getDir() + "\\" + fileList.get(i));
                        } else {
                            temp2 = new File(Manager.getDir() + fileList.get(i));
                        }
                        if(temp2.isHidden()){
                            continue;
                        } else if(temp2.isFile()){
                            System.out.printf("%-35s", "\u001b[34;1m" + fileList.get(i));
                        } else if(temp2.isDirectory()){
                            System.out.printf("%-35s", "\u001b[37;1m" + fileList.get(i));
                        }
                        isprint++;

                        if(isprint % 3 == 0){
                            System.out.println("");
                        }
                    }

                    System.out.println();
                } else {
                    throw new FileNotFoundException();
                }
            } catch(FileNotFoundException fe){
                System.out.println(fe);
            } catch (Exception e){
                System.out.println(e);
            }
        } else {
            throw new CommandNotCorrectException();
        }
    }
}
