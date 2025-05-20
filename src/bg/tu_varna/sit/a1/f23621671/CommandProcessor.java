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

/**
 * Processes user commands in a command-line interface.
 * <p>
 * Maintains a mapping of available commands and executes them based on user input.
 * Handles command validation, access control, and argument parsing, including support for quoted arguments.
 * </p>
 */
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

    /**
     * Runs the command processing loop, reading commands from the user and executing them.
     * <p>
     * Continuously prompts for user input, parses commands with support for quoted arguments,
     * validates commands and argument counts, checks access levels, and executes the corresponding command.
     * Errors during command processing are caught and displayed without terminating the loop.
     * </p>
     *
     * @throws AccessDeniedException            if the current user does not have permission to execute a command
     * @throws NoDataException                  if required data (e.g., books) is not loaded when needed
     * @throws InvalidCommandArgumentsException if command arguments are invalid or missing
     * @throws InvalidCommandException          if the command is unknown or malformed
     */
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
                    else if (argCount != commandType.getArgCount() && (commandType.equals(CommandEnums.BOOKS_SORT) && argCount - 1 != commandType.getArgCount()))
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

    /**
     * Splits an input string into arguments, respecting quoted substrings.
     * <p>
     * Supports arguments enclosed in double quotes ("") or single quotes (''),
     * treating quoted text as a single argument even if it contains spaces.
     * </p>
     *
     * @param input the input command line string
     * @return an array of argument strings parsed from the input
     */
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