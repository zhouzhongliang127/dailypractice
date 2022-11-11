package com.teamproject.service;

/**
 * @author zzl
 * @Description
 * @date 2021/10/3 - 9:53
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993124549948L;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public TeamException() {
    }

    public TeamException(String msg){
        super(msg);
    }
}
