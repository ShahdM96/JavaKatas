package katas.exercises;


import java.util.LinkedList;
import java.util.List;

public class RoundRobinLoadBalancer {
    /**
     * In distributed systems, a load balancer is responsible for distributing incoming requests to multiple server instances.
     * A round-robin load balancer assigns requests to server instances in a circular order.
     *
     * You need to implement a RoundRobinLoadBalancer class that:
     *
     *  - Adds a server instance to the pool of available instances.
     *  - Removes a server instance from the pool of available instances.
     *  - Routes incoming requests to server instances in a round-robin manner.
     *  - Return null when no servers are available.
     */

    private  List<IP> servers;
    private int currentIndex;

    /**
     * Constructor to initialize the load balancer.
     */
    public RoundRobinLoadBalancer() {
        this.servers = new LinkedList<>();
        this.currentIndex = -1;
    }

    /**
     * Adds a server instance to the load balancer.
     *
     * @param server the IP object representing the server to add
     */
    public void addServer(IP server) {
        this.servers.add(server);
        if(this.currentIndex == -1) {
            this.currentIndex = this.servers.size() - 1;
        }
    }

    /**
     * Removes a server instance from the load balancer.
     *
     * @param server the IP object representing the server to remove
     */
    public void removeServer(IP server) {
        int i = this.servers.indexOf(server);
        if(i==this.currentIndex) {
            if (this.servers.size() == 1) {
                this.currentIndex = -1;
            } else if (i == this.servers.size() - 1) {
                this.currentIndex = 0;
            }
        }else if(i<this.currentIndex) {
            this.currentIndex-=1;
        }
        this.servers.remove(server);
    }

    /**
     * Routes a request to the next server in round-robin order.
     *
     * @return the IP object of the server handling the request
     */
    public IP routeRequest() {
        if(this.currentIndex == -1) return null;
        int i = this.currentIndex;
        if(this.servers.size() == 1){
            this.currentIndex = -1;
        }else if(this.currentIndex == this.servers.size()-1){
            this.currentIndex = 0;
        }else{
            this.currentIndex +=1;
        }
        return this.servers.get(i);

    }

    public static void main(String[] args) {
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(new IP("192.168.0.1"));
        loadBalancer.addServer(new IP("192.168.0.2"));
        loadBalancer.addServer(new IP("192.168.0.3"));

        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());

        loadBalancer.removeServer(new IP("192.168.0.1"));

        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
        System.out.println("Routing to: " + loadBalancer.routeRequest());
    }

    /**
     * Represents an IP address.
     */
    static class IP {
        private final String address;

        /**
         * Constructor to initialize an IP address.
         *
         * @param address the IP address as a string
         */
        public IP(String address) {
            if (!isValidIP(address)) {
                throw new IllegalArgumentException("Invalid IP address: " + address);
            }
            this.address = address;
        }

        /**
         * Validates an IPv4 address.
         *
         * @param address the IP address to validate
         * @return true if the address is valid, false otherwise
         */
        private static boolean isValidIP(String address) {
            String[] arr = address.split("\\.");
            return arr.length == 4;
        }

        @Override
        public String toString() {
            return address;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            IP ip = (IP) obj;
            return address.equals(ip.address);
        }

        @Override
        public int hashCode() {

            return address.hashCode();// using String hashCode
        }
    }

}


