package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.*;

/**
 * Represents a command that can be executed with given input arguments.
 * Implementing classes define the specific behavior of the command.
 */
public interface Command {
    /**
     * Executes the command with the provided input arguments.
     *
     * @param input the array of input arguments for the command
     * @throws BookNotFoundException            if a book required by the command is not found
     * @throws InvalidCommandArgumentsException if the input arguments are invalid
     * @throws AccessDeniedException            if the user does not have permission to execute the command
     * @throws UserNotFoundException            if the specified user is not found
     * @throws NoDataException                  if required data is missing or unavailable
     * @throws FileStateException               if there is an error related to file state
     * @throws BadDataException                 if the provided data is malformed or incorrect
     */
    void runCommand(String[] input) throws BookNotFoundException, InvalidCommandArgumentsException, AccessDeniedException, UserNotFoundException, NoDataException, FileStateException, BadDataException;
}
