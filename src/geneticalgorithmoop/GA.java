/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithmoop;

import java.util.Arrays;

/**
 * @author sina
 */
public class GA {

    int counter;
    //number of initial population
    int m;
    Population p1;
    Population p2;


    public GA(int m, int counter) {

        this.counter = counter;
        this.m = m;
        System.out.println("GA Constructor => " + "number of initial populatoin : " + this.m);
        System.out.println("number of iteration : " + this.counter);
        p1 = new Population(m);
        //assigns random values to p1
        p1.init();

    }

    public double start() {

        for (int i = 0; i < counter; i++) {
            System.out.println("Iteration # :" + i);
            p1.fit();
            //TODO Cross Over ro benvissss
            //   p2 = crossOver(p1);
            //////////////////////////////////////TODO in do khat pak shavad
            p2 = new Population(m);
            p2.init();
            //////////////////////////////////////
            p2.fit();

            p1 = select(p1, p2);
        }
        Instance result = p1.best();
        System.out.println("instances " + result.getFitness().fitness);
        return result.getValue();
    }

    private Population crossOver(Population p1) {
        Population p = null;
        int pivot = randPivot();
/*        Instance resultA[] = new Instance[m];
        Instance resultB[] = new Instance[m];
        Instance tempA[];
        Instance tempB[];
        tempA = Arrays.copyOf(p1.getInstances(), pivot);
        tempB = Arrays.copyOf(p2.getInstances(), pivot);
        System.arraycopy(p1.getInstances(), 0, resultA, 0, m / 2);
        System.arraycopy(tempA, m / 2, resultA, m / 2, m - m / 2);
        System.arraycopy(p1.getInstances(), 0, resultB, 0, m / 2);
        System.arraycopy(tempB, m / 2, resultB, m / 2, m - m / 2);*/
        return p1;
    }

    private int randPivot() {
        int popCount = m;
        int pivot;
        double temp = Math.random();
        temp *= --popCount;
        pivot = (int) temp;
        pivot++;
        return pivot;
    }

    private Population select(Population p1, Population p2) {
        Population p = new Population(m);


        Instance[] result = select2(p1.getInstances(), p2.getInstances());
        p.setInstances(result);

        return p;
    }

    private Instance[] select2(Instance[] instances, Instance[] instances1) {
        Instance[] result = new Instance[2 * m];
        for (int i = 0, j = 0; i < result.length; i += 2, j++) {
            result[i] = instances[j];
            result[i + 1] = instances1[j];
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j < m; j++) {
                if (result[i].getFitness().fitness > result[j].getFitness().fitness) {
                    Instance temp;
                    temp = result[j];
                    result[j] = result[i];
                    result[i] = temp;

                }
            }
        }
        return result;
    }

    private void deleteMin(Instance[] temp, Instance minInstance) {
        for (int j = 0; j < temp.length; j++) {
            if (minInstance.equals(temp[j])) {
                temp[j].getFitness().fitness = Double.MAX_VALUE;
            }
        }
    }

    private Instance minFitness(Instance[] temp) {
        double min = Double.MAX_VALUE;
        Instance instance = null;
        for (Instance temp1 : temp) {
            if (temp1.getFitness().fitness < min) {
                min = temp1.getFitness().fitness;
                instance = temp1;
            }
        }
        return instance;
    }

}
