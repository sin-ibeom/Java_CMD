import java.io.File;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        String dir = "";
        // ConsoleView 클래스 : 콘솔에 리눅슥처럼 찍어주는 역할
        // CommandParser 명령어 해석기 클래스 : 명령어마다 있는 arg를 해석
        // Command : 커멘드 인터페이스로 다양성
        // Manager : 커맨드 인터페이스로 만들어진 명령어(클래스) 실행
        Scanner sc = new Scanner(System.in);
        String str = File.listRoots()[0].toString();
        System.out.println(str);

        while(true) {
            ConsoleView.run();
            Manager mg = new Manager();
            String input = sc.nextLine();
            if(input.equals("exit")) break;
            mg.run(input);
        }
        sc.close();
    }
}
