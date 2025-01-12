package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundRobinLoadBalancerTest {
    @Test
    public void testRoundRobinLoadBalancer() {

        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.2"));
        loadBalancer.addServer(new RoundRobinLoadBalancer.IP("192.168.0.3"));
        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.1"),loadBalancer.routeRequest());
        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.2"),loadBalancer.routeRequest());
        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.3"),loadBalancer.routeRequest());
        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.1"),loadBalancer.routeRequest());


        loadBalancer.removeServer(new RoundRobinLoadBalancer.IP("192.168.0.1"));

        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.2"),loadBalancer.routeRequest());
        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.3"),loadBalancer.routeRequest());
        assertEquals(new RoundRobinLoadBalancer.IP("192.168.0.2"),loadBalancer.routeRequest());

    }


}
