package bg.tu_varna.sit.a1.f23621671;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Commands.*;
import bg.tu_varna.sit.a1.f23621671.Exceptions.AccessDeniedException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.InvalidCommandArgumentsException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.InvalidCommandException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandProcessor {
    private static final Map<CommandEnums, Command> commandMap = new HashMap<>();

    static {
        commandMap.put(CommandEnums.EXIT, new ExitCommand());
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

    public static void run() throws AccessDeniedException, NoDataException, InvalidCommandArgumentsException, InvalidCommandException {
        while (true) {
            try {
                System.out.print("> ");
                Scanner commandLine = new Scanner(System.in);
                String input = commandLine.nextLine().trim().replaceAll("\\s+", " ").toLowerCase();
                String[] splitInput = splitArgumentsRespectingQuotes(input);
                if (splitInput.length == 0) {
                    throw new InvalidCommandException("Empty command!");
                }
                String[] argumentsArr;
                CommandEnums commandType = CommandEnums.getCommandEnum(splitInput);

                if (commandType != null) {
                    String cmdText = (commandType.getCommandText());
                    String arguments = input.length() > cmdText.length()
                            ? input.substring(cmdText.length()).trim()
                            : "";
                    argumentsArr = arguments.isEmpty()
                            ? new String[0]
                            : splitArgumentsRespectingQuotes(arguments);
                    int argCount = argumentsArr.length;
                    Command command = commandMap.get(commandType);
                    commandType.hasAccess(CurrentData.getInstance().getCurrentUser().getAccessLevel());
                    if (commandType.isNeedsBooks() && Library.getInstance().getBooks().isEmpty())
                        throw new NoDataException("No books loaded!");
                    else if (argCount != commandType.getArgCount()&&(commandType.equals(CommandEnums.BOOKS_SORT)&&argCount-1!=commandType.getArgCount()))
                        throw new InvalidCommandArgumentsException("Argument count not right! help with command: " + commandType.getDescText().replaceAll("\\s+", " "));
                    else {
                        command.runCommand(argumentsArr);
                    }
                } else {
                    throw new InvalidCommandException("No such command!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static String[] splitArgumentsRespectingQuotes(String input) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("\"([^\"]*)\"|'([^']*)'|\\S+").matcher(input);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1));
            } else if (matcher.group(2) != null) {
                tokens.add(matcher.group(2));
            } else {
                tokens.add(matcher.group());
            }
        }
        return tokens.toArray(new String[0]);
    }
}