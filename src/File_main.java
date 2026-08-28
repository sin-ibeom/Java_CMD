import java.io.File;
import java.util.ArrayList;

public class File_main {

    private String path = "C:\\";

    public void setFilePath(String str){
        this.path = str;
    }

    public String getFilePath(){
        return this.path;
    }

    public void input(String user_input){
        String cdregex = "^cd.*";
        boolean isRun = false;

        if(user_input.equals("ls")){
            isRun = true;
            file_search().forEach(file -> {System.out.println(file);});
        }

        if(user_input.equals("pwd")){
            isRun = true;
            System.out.println(getFilePath());
        }

        if(user_input.matches(cdregex)){
            isRun = true;

            String path_input = user_input.substring(2).trim();
            File f = new File(path_input);
            if(f.exists()){
                System.out.printf(String.valueOf(f.exists()));
                setFilePath(path_input);
            } else {
                System.out.println("지정된 경로를 찾을 수 없다.");
            }
        }

        if(!(isRun)){
            System.out.println("\""+user_input +"\" "+ "은/는 올바르지 않은 명령이에오");
        }




        }

    public ArrayList<String> file_search(){
        ArrayList<String> result = new ArrayList<String>();

        try{
            File f = new File(getFilePath());
            for( int i = 0; i < f.list().length - 1; i++){
                if( f.list()[i] != null){
                    result.add(f.list()[i]);
                }
            }
        } catch   (Exception e){
            e.printStackTrace();
        }


        return result;
    }
}
