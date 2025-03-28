package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Commands.*;

import java.util.*;

public class CommandProcessor {
    public static String currentFile="";
    public static StringBuilder content=new StringBuilder();
    private static final Map<String, Command> commandMap=new HashMap<>();
    static {
        commandMap.put("exit",new ExitCommand());
        commandMap.put("open",new OpenCommand());
        commandMap.put("close",new CloseCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("saveas", new SaveAsCommand());
        commandMap.put("help", new HelpCommand());
    }
    public static void run(){
        System.out.print ("> ");
        Scanner command= new Scanner(System.in);
        String[] commandTokens = command.nextLine().toLowerCase().split(" ");
        System.out.println(commandTokens[0]);
        Command cmnd= commandMap.get(commandTokens[0]);
        if(cmnd!=null){
            cmnd.runCommand(commandTokens.length > 1 ? commandTokens[1] : "");
            run();
        }
        else{
            System.out.println("No such command!");
            run();
        }
    }
    public static Set<Map.Entry<String, Command>> getCommandEntries() {
        return Collections.unmodifiableSet(commandMap.entrySet());
    }
}
