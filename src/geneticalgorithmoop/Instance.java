/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithmoop;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author sina
 */
public class Instance {

    //base 10 value
    private int value;
    private byte[] base2;
    private Fitness fitness;

    public Fitness getFitness() {
        return fitness;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setBase2(byte[] base2) {
        this.base2 = base2;
    }

    Fitness fit() {

        //TODO calculate fitness for all instances in a population
        fitness = new Fitness();
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
        this.base2 = new byte[4];
        this.base2 = toBase2(value);


    }



    private byte[] toBase2(int value) {

        byte base2Byte[] = new byte[4];
        Arrays.fill(base2Byte, (byte) 0);

        for (int i = base2Byte.length - 1; i >= 0; i--) {

            if (value / 2 > 0) {
                base2Byte[i] = (byte) (value % 2);
                value /= 2;

            } else {
                base2Byte[i] = (byte) (value);
                break;
            }


        }
        return base2Byte;
    }

    public Instance randomInstance() {
        byte[] temp = new byte[4];
        for (int i = 0; i < 4; i++) {
            double random = Math.random();
            random *= 100;
            random %= 2;
            if (random < 0.5) {
                temp[i] = 0;
            } else {
                temp[i] = 1;
            }

        }
        return new Instance(toBase10(temp));
    }

    public Instance() {
    }

    private int toBase10(byte[] temp) {
        int value = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 1) {
                value += Math.pow(2, 3 - i);
            }
        }
        return value;
    }

    public int getValue() {
        return value;
    }

    public byte[] getBase2() {
        return base2;
    }
}
