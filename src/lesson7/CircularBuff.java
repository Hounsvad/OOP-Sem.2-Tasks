/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author erso Created on 08-02-2010, 09:33:34
 */
public class CircularBuff {

    private Integer[] buf;
    private int size;
    int putIndex = 0;
    int getIndex = 0;
    private Lock lock;
    private Condition getCondition;
    private Condition setCondition;

    public CircularBuff(int size) {
        buf = new Integer[size];
        this.size = size;
        lock = new ReentrantLock();
        getCondition = lock.newCondition();
        setCondition = lock.newCondition();
    }

    // Implementer get() metoden
    public Integer get() {
        try {
            lock.lock();
            if (buf[putIndex % size] != null) {
                getIndex++;
                setCondition.signal();
                return buf[getIndex % size];
            } else {
                try {
                    getCondition.await();
                    getIndex++;
                    setCondition.signal();
                    return buf[putIndex % size];
                } catch (InterruptedException ex) {
                    System.out.println("Exception: " + ex + " on con.await()");
                }
            }

        } catch (Exception e) {
            System.out.println("An error occured in set: " + e);
        } finally {
            buf[getIndex % size] = null;
            System.out.println(this.toString());
            lock.unlock();
        }
        return null;
    }

    // Implementer put() metoden
    public void put(Integer input) {
        try {
            lock.lock();
            if (buf[putIndex % size] == null) {
                buf[putIndex % size] = input;
                putIndex++;
                getCondition.signal();
            } else {
                try {
                    setCondition.await();
                    buf[putIndex % size] = input;
                    putIndex++;
                    getCondition.signal();
                } catch (InterruptedException ex) {
                    System.out.println("Exception: " + ex + " on con.await()");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured in get: " + e);
        } finally {
            System.out.println(this.toString());
            lock.unlock();
        }
    }

    public String toString() {
        return "Buff: " + Arrays.toString(buf);
    }
}
