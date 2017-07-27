package org.academiadecodigo.bootcamp.persistence;

/**
 * Created by codecadet on 24/07/2017.
 */
public class TransactionException extends RuntimeException{

    public TransactionException(Throwable cause){
        super(cause);
    }

}
