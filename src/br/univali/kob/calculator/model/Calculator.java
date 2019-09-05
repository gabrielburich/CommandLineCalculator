package br.univali.kob.calculator.model;

import br.univali.kob.stack.model.Stack;

import java.util.Objects;

public class Calculator {

    private Stack<Integer> lastSteps;
    private Integer result;

    /**
     * Default class constructor
     */
    public Calculator() {
        InitialValues();
    }

    /**
     * Clear stack and result
     */
    public void InitialValues() {
        this.lastSteps = new Stack<Integer>();
        this.result = null;
    }


    /**
     * Get the value resulting from the last sub-operations
     * @return Stack Last steps
     */
    public Stack<Integer> getLastSteps() {
        return lastSteps;
    }

    /**
     * Get the operations result
     * @return result
     */
    public Integer getResult() {
        return result;
    }



    /**
     * sum an integer with a value already stored in result variable
     * @param  value int to sum
     */
    public void sum(int value) {
        // first value isn't save on stack
        // result == null mean new calculation
        if (this.result == null) {
            this.result = value;
        } else {
            this.result += value;
            this.lastSteps.insert(this.result);
        }
    }


    /**
     * subtract an integer with a value already stored in result variable
     * @param value int to subtract
     */
    public void subtract(int value) {
        // first value isn't save on stack
        // result == null mean new calculation
        if (this.result == null) {
            this.result = -value;
        } else {
            this.result -= value;
            this.lastSteps.insert(this.result);
        }
    }

    @Override
    public String toString() {
        return "Calculator [lastSteps=" + lastSteps + ", result=" + result + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(lastSteps, that.lastSteps) &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastSteps, result);
    }
}

