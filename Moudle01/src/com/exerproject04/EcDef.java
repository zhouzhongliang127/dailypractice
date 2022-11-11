package com.exerproject04;

/**
 * @author zzl
 * @Description
 * @date 2021/10/2 - 22:54
 */
public class EcDef extends  Exception{
    static final long serialVersionUID = -3387516993124249948L;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public EcDef() {
    }

    public EcDef(String msg){
        super(msg);
    }

}
