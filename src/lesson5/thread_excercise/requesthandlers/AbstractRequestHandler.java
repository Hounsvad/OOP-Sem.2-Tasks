/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5.thread_excercise.requesthandlers;

import java.net.Socket;

/**
 *
 * @author erso
 */
public abstract class AbstractRequestHandler implements Runnable{
    
    protected Socket socket;

    public AbstractRequestHandler(Socket socket) {
        this.socket = socket;
    }
    
    
}
