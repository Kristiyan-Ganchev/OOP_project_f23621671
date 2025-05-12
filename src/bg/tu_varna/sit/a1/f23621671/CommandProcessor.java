package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Commands.*;

import java.util.*;

public class CommandProcessor {
    private static final Map<CommandEnums, Command> commandMap=new HashMap<>();
    static {
        commandMap.put(CommandEnums.EXIT,new ExitCommand());
        commandMap.put(CommandEnums.OPEN, new OpenCommand());
        commandMap.put(CommandEnums.CLOSE, new CloseCommand());
        commandMap.put(CommandEnums.SAVE, new SaveCommand());
        commandMap.put(CommandEnums.SAVE_AS, new SaveAsCommand());
        commandMap.put(CommandEnums.HELP, new HelpCommand());
        commandMap.put(CommandEnums.LOGIN, new LoginCommand());
        commandMap.put(CommandEnums.LOGOUT, new LogoutCommand());
        commandMap.put(CommandEnums.BOOKS_ALL, new BooksAllCommand());
        commandMap.put(CommandEnums.BOOKS_INFO, new BooksInfoCommand());
        commandMap.put(CommandEnums.BOOKS_FIND, new BooksFindCommand());
        commandMap.put(CommandEnums.BOOKS_SORT, new BooksSortCommand());
        commandMap.put(CommandEnums.BOOKS_ADD, new BooksAddCommand());
        commandMap.put(CommandEnums.BOOKS_REMOVE, new BooksRemoveCommand());
        commandMap.put(CommandEnums.USERS_ADD, new UsersAddCommand());
        commandMap.put(CommandEnums.USERS_REMOVE, new UsersRemoveCommand());
    }
    public static void run() {
        System.out.print("> ");
        Scanner commandLine= new Scanner(System.in);
        String input = commandLine.nextLine().trim().replaceAll("\\s+", " ").toLowerCase();
        String[] splitInput=input.trim().split("\\s+");

        String[] argumentsArr;
        CommandEnums commandType=CommandEnums.getCommandEnum(splitInput);

        if (commandType != null) {
            String cmdText=(commandType.getCommandText());
            String arguments=input.length() > cmdText.length()
                    ? input.substring(cmdText.length()).trim()
                    : "";
            Command command = commandMap.get(commandType);
            int argCount=arguments.trim().isEmpty() ? 0 : arguments.trim().split("\\s+",commandType.getArgCount()).length;
            if(argCount!=commandType.getArgCount())
                System.out.println("Not right amount of arguments!\nCommand help: "+commandType.getDescText());
            else if(commandType.isNeedsBooks()&&Library.getInstance().getBooks().isEmpty())
                System.out.println("No books loaded!");
            else if(commandType.hasAccess(CurrentData.getInstance().getCurrentUser().getAccessLevel())){
                argumentsArr = arguments.split("\\s+",commandType.getArgCount());
                command.runCommand(argumentsArr);
            }
        }
        else {
            System.out.println("No such command!");
        }
        run();
    }
}