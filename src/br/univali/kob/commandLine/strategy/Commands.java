package br.univali.kob.commandLine.strategy;

import br.univali.kob.calculator.Calculator;

import java.util.Optional;

public enum Commands implements Command {

    CLEAR {
        @Override
        public Optional exec(Calculator calculator, Integer value) {
             calculator.initialValues();
             return Optional.empty();
        }
    },

    SUM {
        @Override
        public Optional exec(Calculator calculator, Integer value) {
            calculator.sum(value);
            return Optional.empty();
        }
    },

    SUBTRACT {
        @Override
        public Optional exec(Calculator calculator, Integer value) {
            calculator.subtract(value);
            return Optional.empty();
        }
    },

    LASTSTEPS {
        @Override
        public Optional exec(Calculator calculator, Integer value) {
            return Optional.of(calculator.getLastSteps());
        }
    },

    RESULT {
        @Override
        public Optional exec(Calculator calculator, Integer value) {
            return Optional.of(calculator.getResult());
        }
    },

    HELP {
        @Override
        public Optional<Object> exec(Calculator calculator, Integer value) {

               var helpMessage =  "=== Command Line calculator ===\n"
                        + "clear { initialize an arithmetic expression }\n"
                        + "sum(value) { sum value with arithmetic expression value }\n"
                        + "subtract(value) { subtracts value from arithmetic expression value }\n"
                        + "laststeps { displays the values of each portion of the arithmetic expression }\n"
                        + "result { displays the result of the evaluation of the arithmetic expression }\n"
                        + "exit { Close program }\n";

            return Optional.of(helpMessage);
        }
    },

    EXIT {
        @Override
        public Optional<Object> exec(Calculator calculator, Integer value) {
            return Optional.of("Thank you");
        }
    };

}
