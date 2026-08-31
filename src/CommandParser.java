import java.util.ArrayList;

public class CommandParser {

    ArrayList Parser(String str){
        ArrayList<String> result = new ArrayList<>();

        for( int i = 0; i < str.split(" ").length; i++ ){
            result.add(str.split(" ")[i]);
        }


        return  result;
    }

}
;