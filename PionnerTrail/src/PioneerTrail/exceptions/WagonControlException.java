/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.exceptions;

/**
 *
 * @author Elías
 */
public class WagonControlException extends Exception{

    public WagonControlException() {
    }

    public WagonControlException(String message) {
        super(message);
    }

    public WagonControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public WagonControlException(Throwable cause) {
        super(cause);
    }

    public WagonControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
