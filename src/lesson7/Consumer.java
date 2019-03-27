/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7;

/**
 *
 * @author erso Created on 08-02-2010, 09:35:14
 */
public class Consumer implements Runnable {

    private CircularBuff q;

    public Consumer(CircularBuff q, int number) {
        this.q = q;
        new Thread(this, "Consumer_"+number).start();
    }

    public void run() {
        while (true) {
            q.get();
            try {
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}

