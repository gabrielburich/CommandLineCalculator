package br.univali.kob.commandLine;

import br.univali.kob.calculator.Calculator;
import br.univali.kob.commandLine.console.Console;
import br.univali.kob.commandLine.strategy.Commands;

import java.util.HashMap;
import java.util.Map;

/**
 * A Command line calculator
 *
 */
public class CommandLineCalculator {

    private Calculator calculator;
    private Console console;


    private final String OPEN_PARENTHESES = "(";
    private final String CLOSE_PARENTHESES = ")";

    private final String VALUE = "value";
    private final String COMMAND = "command";

    private final String CLOSE_COMMAND = "exit";


    /**
     * Default class Constructor
     */
    public CommandLineCalculator() {
        this.calculator = new Calculator();
        this.console = new Console();
    }

    /**
     * Menu loop
     */
    public void runCalculator() {
        Boolean menuReturn;

        do {
            console.print("calc> : ");
            menuReturn = litemCommand();
        } while (menuReturn);
    }

    /**
     * Call calculate methods
     * @return boolean, control while
     */
    private boolean litemCommand() {

        String commandFull = console.readString();
        Map commandValue = extractValues(commandFull.replaceAll("\\s+",""));

        try {
            var valueReturn = Commands.valueOf(((String) commandValue.get(COMMAND)).toUpperCase())
                    .exec(this.calculator, (Integer) commandValue.get(VALUE));

            valueReturn.ifPresent(value -> console.println(value));
        } catch (IllegalArgumentException exception) {
            console.println("Invalid Command, type \"help\" to show commands");
        }

        return !commandValue.get(COMMAND).equals(CLOSE_COMMAND);
    }


    private Map extractValues(String command) {
         var values = new HashMap<String, Object>();

        if (command.contains(OPEN_PARENTHESES)) {
            var indexStart = command.indexOf(OPEN_PARENTHESES);
            var indexEnd = command.indexOf(CLOSE_PARENTHESES);

            var valueString = command.substring(indexStart + 1, indexEnd);
            var commandString = command.substring(0, indexStart);

            values.put(VALUE, Integer.valueOf(valueString));
            values.put(COMMAND, commandString);;

            return values;
        }

        values.put(COMMAND, command);

        return values;
    }




}

