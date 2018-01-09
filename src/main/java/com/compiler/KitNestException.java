package com.compiler;

import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2017/7/21.
 */
public class KitNestException extends RuntimeException{
    private static final long serialVersionUID = 2486491445505536970L;

    public KitNestException() {

    }

    public KitNestException(String arg0, Throwable arg1) {

        super(arg0, arg1);
    }

    public KitNestException(String arg0) {

        super(arg0);
    }

    public KitNestException(Throwable arg0) {

        super(arg0);
    }

    @Override
    public String getMessage() {

        Throwable cause = getCause();
        String msg = super.getMessage();
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            if (this.getStackTrace() != null && this.getStackTrace().length > 0) {
                sb.append(this.getStackTrace()[0]).append("\t");
                if (!StringUtils.isEmpty(msg)) {
                    sb.append(msg);
                    sb.append("; ");
                }
                sb.append("内联异常信息：").append(cause);
            }

            return sb.toString();
        } else {
            return msg;
        }
    }
}
