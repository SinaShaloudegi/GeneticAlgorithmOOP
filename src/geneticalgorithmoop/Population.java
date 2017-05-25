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
public class Population {

    int m;
    Instance[] instances;

    public Population(int m) {
        this.m = m;
        instances = new Instance[m];
    }

    void fit() {

        //TODO calculate fitness for all instances in a population
        for (int i = 0; i < m; i++) {
            instances[i].fit();
        }
    }

    public int getM() {
        return m;
    }

    public Instance[] getInstances() {
        return instances;
    }

    void init() {
        System.out.println("p1 init");

        //TODO randomly assign values to population
        for (int i = 0; i < m; i++) {
            double random = Math.random();
            if (random < 0.5) {
                random = 0;
            } else {
                random = 1;
            }
            this.instances[i] = new Instance((int) random);
            System.out.println("random" + random);

        }

    }

    int best() {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (this.instances[i].getValue() < min) {
                min = this.instances[i].getValue();
            }
        }
        return min;
    }

}
