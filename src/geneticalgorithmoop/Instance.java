/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithmoop;

/**
 *
 * @author sina
 */
public class Instance {

    //base 10 value
    private final int value;
    private final char[] base2;
    Fitness fitness;

    public Fitness getFitness() {
        return fitness;
    }

    Fitness fit() {

        //TODO calculate fitness for all instances in a population
        fitness=new Fitness();
        double x = getValue();
        fitness.setFitness((x * x) - (4 * x) + 4);
        fitness.setI(this);
        return this.getFitness();
    }

    public void setFitness(Fitness fitness) {
        this.fitness = fitness;
    }

    public Instance(int value) {
        this.value = value;
        this.base2 = toBase2(value);
    }

    private char[] toBase2(int value) {

        String stringValue = Integer.toBinaryString(value);

        return stringValue.toCharArray();
    }

    public int getValue() {
        return value;
    }

    public char[] getBase2() {
        return base2;
    }
}
