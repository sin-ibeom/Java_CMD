public class ConsoleView {
    public static void run(){
        String ANSI_GREEN = "\u001B[92m";
        String ANSI_BLUE = "\u001b[34;1m";
        String ANSI_WHITE = "\u001b[37;1m";
        String ANSI_RESET = "\u001B[0m";


        System.out.print(ANSI_GREEN + "java@DESKTOP" + ANSI_WHITE + ":" +  ANSI_BLUE + Manager.getDir().substring(2) + ANSI_WHITE + "$ " + ANSI_RESET);
    }

}
