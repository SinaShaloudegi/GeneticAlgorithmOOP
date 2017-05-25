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
public class GA {

    int counter;
    int m;
    Population p1;
    private Population p2;

    public GA(int m, int i) {
        System.out.println("GA Constructor ");

        this.counter = i;
        this.m = m;
        p1 = new Population(m);
        //assigns random values to p1
        p1.init();
        System.out.println("p1 len " + p1.m);

    }

    public int start() {

        //TODO at the end of counter calculate the minimum of p1 and return it ( p1.best )
        for (int i = 0; i < counter; i++) {
            System.out.println("Iteration # " + i);
            p1.fit();
            System.out.println("p1.instances = " + p1.instances[8].getValue());
            p2 = crossOver(p1);
            p2.fit();
            p1 = select(p1, p2);
        }
        int result = p1.best();

        return result;
    }

    private Population crossOver(Population p1) {
        Population p = null;
        //TODO Cross Over and return p2
        return p1;
    }

    private Population select(Population p1, Population p2) {
        Population p = new Population(m);

//        //TODO it selects m instances based on p1.fitness and p2.fitness and return p1
//        Instance[] temp = new Instance[2 * m];
//        Instance[] minTemp = new Instance[m];
//
//        System.arraycopy(p1.instances, 0, temp, 0, m);
//        System.arraycopy(p2.instances, m - 1, temp, m - 1, 2 * m - (m - 1));
//
//        for (int i = 0; i < m; i++) {
//            Instance minInstance = minFitness(temp);
//            minTemp[i] = minInstance;
//            deleteMin(temp, minInstance);
//        }
        return p1;
    }

    private void deleteMin(Instance[] temp, Instance minInstance) {
        for (int j = 0; j < temp.length; j++) {
            if (minInstance.equals(temp[j])) {
                temp[j].fitness.fitness = Double.MAX_VALUE;
            }
        }
    }

    private Instance minFitness(Instance[] temp) {
        double min = Double.MAX_VALUE;
        Instance instance = null;
        for (Instance temp1 : temp) {
            if (temp1.fitness.fitness < min) {
                min = temp1.fitness.fitness;
                instance = temp1;
            }
        }
        return instance;
    }

}
