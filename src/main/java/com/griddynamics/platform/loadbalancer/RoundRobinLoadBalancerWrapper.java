package com.griddynamics.platform.loadbalancer;

import com.griddynamics.jagger.invoker.QueryPoolLoadBalancer;
import com.griddynamics.jagger.invoker.RoundRobinLoadBalancer;
import com.griddynamics.jagger.util.Pair;

import java.util.Iterator;


/**
 * New implementation of the {@link RoundRobinLoadBalancer} for Apollo:
 * it caches pool of queries and provides synchronized iterator for that pool
 * for all Jagger tests consumers.
 *
 * @author pvasilyev
 */
public class RoundRobinLoadBalancerWrapper<Q, E> extends QueryPoolLoadBalancer<Q, E> {

    private final Iterator<Pair<Q, E>> synchronizedCachedIterator;

    private final RoundRobinLoadBalancer<Q, E> delegateBalancer;

    public RoundRobinLoadBalancerWrapper(final RoundRobinLoadBalancer<Q, E> loadBalancer) {
        this.delegateBalancer = loadBalancer;
        final Iterator<Pair<Q, E>> delegatedIterator = loadBalancer.provide();
        this.synchronizedCachedIterator = new Iterator<Pair<Q, E>>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public synchronized Pair<Q, E> next() {
                return delegatedIterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        };
    }

/*
    @Override
    public Iterator<Pair<Q, E>> iterator() {
        return provide();
    }
*/

    @Override
    public Iterator<Pair<Q, E>> provide() {
        return synchronizedCachedIterator;
    }

    @Override
    public int querySize() {
        return delegateBalancer.querySize();
    }

    @Override
    public int endpointSize() {
        return delegateBalancer.endpointSize();
    }

    @Override
    public String toString() {
        return "RoundRobinLoadBalancerWrapper";
    }
}
