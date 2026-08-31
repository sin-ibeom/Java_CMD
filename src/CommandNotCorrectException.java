public class CommandNotCorrectException extends Exception{

    CommandNotCorrectException(){
        super("해당 명령문을 찾ㅣ 못했습니다.");
    }

    CommandNotCorrectException(String str){
        super(str);
    }

}
