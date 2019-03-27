/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author erso Created on 08-02-2010, 09:33:34
 */
public class CircularBuff {

    private Integer [] buf;
    private int size;
    int putIndex = 0;
    int getIndex = 0;
    private Lock lock;
    private Condition con;

    public CircularBuff(int size){
        buf = new Integer[size];
        this.size = size;
        con = new AbstractQueuedSynchronizer.ConditionObject();
}
    }

    // Implementer get() metoden
    public Integer get(){
                return 1;
    }
    // Implementer put() metoden
    public void put(Integer input){
        if(buf[putIndex%size] != null){
            
        }else{
            try {
                con.await();
            } catch (InterruptedException ex) {
                System.out.println("Exception: " +  + " on con.await()");
            }
        }
    }

    public String toString(){
        return "Buff: "+Arrays.toString(buf);
    }
}

