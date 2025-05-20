package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.AccessDeniedException;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum representing all available commands in the system along with their metadata.
 * Each command includes its text, number of arguments, description, required access level, and whether it requires loaded books.
 */
public enum CommandEnums {
    /**
     * Command to exit the program.
     */
    EXIT("exit", 0, "exit                                                                             exists the program", AccessLevel.NONE, false),
    /**
     * Command to open a file.
     */
    OPEN("open", 1, "open <file>                                                                      opens <file>", AccessLevel.NONE, false),
    /**
     * Command to close the currently opened file.
     */
    CLOSE("close", 0, "close                                                                            closes currently opened file", AccessLevel.NONE, true),
    /**
     * Command to save the currently open file.
     */
    SAVE("save", 0, "save                                                                             saves the currently open file", AccessLevel.NONE, true),
    /**
     * Command to save the currently open file under a new name.
     */
    SAVE_AS("save as", 1, "save as <file>                                                                   saves the currently open file in <file>", AccessLevel.NONE, true),
    /**
     * Command to display information about all commands.
     */
    HELP("help", 0, "help                                                                             prints information about all commands", AccessLevel.NONE, false),
    /**
     * Command to log in a user.
     */
    LOGIN("login", 0, "login                                                                            asks user for their username and password and logs them in", AccessLevel.NONE, false),
    /**
     * Command to log out the current user or administrator.
     */
    LOGOUT("logout", 0, "logout                                                                           logs current user or administrator out", AccessLevel.USER, false),
    /**
     * Command to print short information for each book.
     */
    BOOKS_ALL("books all", 0, "books all                                                                        prints short information for each book", AccessLevel.USER, true),

    /**
     * Command to print detailed information about a book given its ISBN.
     */
    BOOKS_INFO("books info", 1, "books info <isbn_value>                                                          prints detailed information about book with isbn: <isbn_value>", AccessLevel.USER, true),
    /**
     * Command to find and print books based on author, title or tag.
     */
    BOOKS_FIND("books find", 2, "books find <option> <option_string>                                              finds and prints books with <option> being either author,title or tag and <option_string being their value>", AccessLevel.USER, true),

    /**
     * Command to print books sorted by specified criteria in ascending or descending order.
     */
    BOOKS_SORT("books sort", 1, "books sort <option> [asc|desc]                                                   prints books sorted by <option>, which is either title,author,year or rating with ascending order by default unless specified", AccessLevel.USER, true),
    /**
     * Command to add a new book.
     */
    BOOKS_ADD("books add", 8, "books add <author> <title> <genre> <isbn> <description> <year> <rating> <tags>   adds a new book with these values", AccessLevel.ADMINISTRATOR, false),
    /**
     * Command to remove a book by ISBN.
     */
    BOOKS_REMOVE("books remove", 1, "books remove <isbn_value>                                                        removes book with isbn: <isbn_value>", AccessLevel.ADMINISTRATOR, true),

    /**
     * Command to add a new user.
     */
    USERS_ADD("users add", 2, "users add <user> <password>                                                      adds new user with name <user> and password <password>", AccessLevel.ADMINISTRATOR, false),
    /**
     * Command to remove a user.
     */
    USERS_REMOVE("users remove", 1, "users remove <user>                                                              removes user with name <user>", AccessLevel.ADMINISTRATOR, false);

    private final String commandText;
    private final int argCount;
    private final String descText;
    private final AccessLevel accessLevel;
    private final boolean needsBooks;

    /**
     * Constructor for CommandEnums.
     *
     * @param commandText the textual representation of the command
     * @param argCount    the number of arguments the command expects
     * @param descText    the description of the command
     * @param accessLevel the required access level to run the command
     * @param needsBooks  whether the command requires loaded books in the library
     */
    CommandEnums(String commandText, int argCount, String descText, AccessLevel accessLevel, boolean needsBooks) {
        this.commandText = commandText;
        this.argCount = argCount;
        this.descText = descText;
        this.accessLevel = accessLevel;
        this.needsBooks = needsBooks;
    }

    /**
     * Gets the textual command representation.
     *
     * @return command text
     */
    public String getCommandText() {
        return commandText;
    }

    /**
     * Gets the expected argument count for the command.
     *
     * @return number of arguments
     */
    public int getArgCount() {
        return argCount;
    }

    /**
     * Gets the description text of the command.
     *
     * @return description text
     */
    public String getDescText() {
        return descText;
    }

    /**
     * Gets the access level required to execute this command.
     *
     * @return access level
     */
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * Indicates whether this command requires books to be loaded.
     *
     * @return true if books are needed, false otherwise
     */
    public boolean isNeedsBooks() {
        return needsBooks;
    }

    private static final Map<String, CommandEnums> commandLookup = new HashMap<>();

    static {
        for (CommandEnums command : values()) {
            commandLookup.put(command.commandText, command);
        }
    }

    /**
     * Retrieves the CommandEnums instance matching the input command text.
     * Supports commands consisting of one or two words.
     *
     * @param commandText array of command words
     * @return matching CommandEnums or null if none found
     */
    public static CommandEnums getCommandEnum(String[] commandText) {
        if (commandText.length > 1 && commandLookup.containsKey(commandText[0] + " " + commandText[1]))
            return commandLookup.get(commandText[0] + " " + commandText[1]);
        else if (commandLookup.containsKey(commandText[0]))
            return commandLookup.get(commandText[0]);
        return null;
    }

    /**
     * Checks if a user with the specified access level has permission to execute this command.
     *
     * @param userAccessLevel the user's access level
     * @return true if access is allowed
     * @throws AccessDeniedException if the user does not have permission
     */
    public boolean hasAccess(AccessLevel userAccessLevel) throws AccessDeniedException {
        if (userAccessLevel.equals(AccessLevel.ADMINISTRATOR) || this.getAccessLevel().equals(AccessLevel.NONE))
            return true;
        else if (userAccessLevel.equals(this.getAccessLevel())) {
            return true;
        }
        throw new AccessDeniedException("You need to be " + (this.getAccessLevel() == AccessLevel.NONE ? "logged out" : "a " + this.getAccessLevel()) + " to use command!");
    }
}
