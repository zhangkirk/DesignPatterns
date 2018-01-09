package com.compiler;

/**
 * Created by Administrator on 2017/7/21.
 */
public class CompilerException extends  KitNestException{
    private static final long serialVersionUID = -1150970837696947831L;

    public CompilerException() {

        super();
    }

    public CompilerException(String arg0, Throwable arg1) {

        super(arg0, arg1);
    }

    public CompilerException(String arg0) {

        super(arg0);
    }

    public CompilerException(Throwable arg0) {

        super(arg0);
    }
}
