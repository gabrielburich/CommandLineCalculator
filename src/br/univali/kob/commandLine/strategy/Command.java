package br.univali.kob.commandLine.strategy;

import br.univali.kob.calculator.Calculator;

import java.util.Optional;

public interface Command {

    Optional<Object> exec(Calculator calculator, Integer value);
}
