package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Exceptions.*;

public interface Command {
      void runCommand(String input[]) throws BookNotFoundException, InvalidCommandArgumentsException, AccessDeniedException, UserNotFoundException, NoDataException, FileStateException;
}
