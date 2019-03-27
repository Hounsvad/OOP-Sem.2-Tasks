/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lesson7;

/**
 *
 * @author erso Created on 08-02-2010, 09:35:50
 */
public class PCFixed {
   public static void main(String args[]) throws InterruptedException {
      CircularBuff q = new CircularBuff(5);
      new Producer(q, 0);
      new Producer(q, 1);

      new Consumer(q, 0);
      new Consumer(q, 1);
      new Consumer(q, 2);

   }
}
