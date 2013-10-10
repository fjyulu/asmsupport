package jw.asmsupport.exception;

import jw.asmsupport.clazz.AClass;
import jw.asmsupport.clazz.ArrayClass;

/**
 * 
 * @author 温斯群(Joe Wen)
 *
 */
public class ArrayStoreException extends RuntimeException {

    private static final long serialVersionUID = -5812116933256731752L;

    public ArrayStoreException(ArrayClass acls, AClass valueCls) {
        super("cannot store value " + valueCls + " to array " + acls);
    }

}