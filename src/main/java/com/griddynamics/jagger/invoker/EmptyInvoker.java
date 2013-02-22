package com.griddynamics.jagger.invoker;

/**
 * Created with IntelliJ IDEA.
 * User: kgribov
 * Date: 2/21/13
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmptyInvoker implements Invoker {
    @Override
    public Object invoke(Object o, Object o1) throws InvocationException {
        return new String("Empty response");
    }
}
