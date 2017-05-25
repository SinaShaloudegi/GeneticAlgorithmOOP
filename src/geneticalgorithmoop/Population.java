/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithmoop;

/**
 * @author sina
 */
public class Population {

    int m;

    public void setInstances(Instance[] instances) {
        this.instances = instances;
    }

    Instance[] instances;

    public Population(int m) {
        this.m = m;
        instances = new Instance[m];
        System.out.println("Population Constructor => instances number :" + instances.length);
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
        System.out.println("Initial Population == ");

        //TODO randomly assign values to population
        for (int i = 0; i < m; i++) {
            Instance insInstance = new Instance();
            this.instances[i] = insInstance.randomInstance();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(this.instances[i].getValue() + ",");

        }
        System.out.println("\n");

    }

    Instance best() {
        int j = 0;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (this.instances[i].getFitness().fitness < min) {
                min = this.instances[i].getFitness().fitness;
                j=i;
            }
        }
        return this.instances[j];
    }

}
