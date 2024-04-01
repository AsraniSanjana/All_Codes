import java.util.*;
class Site implements Comparable<Site> {

    int id;
        int timestamp;
        Queue<Integer> requestQueue;

        Site(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
            this.requestQueue = new LinkedList<>();
        }

        void requestCS(Site[] sites) {
            for (Site site : sites) {
                if (site.id != id) {
                    site.receiveRequest(timestamp, id);
                }
            }
            requestQueue.add(timestamp);
        }

        void receiveRequest(int timestamp, int senderId) {
            requestQueue.add(timestamp);
            if (timestamp < this.timestamp || (timestamp == this.timestamp && senderId < this.id)) {
                System.out.println("p" + id + " <- REQ <- P" + senderId);
                // Respond to the sender with an OK message
                System.out.println("p" + id + " <- OK <- p" + senderId);
            }
        } // Added closing curly brace

        void enterCS(){ 
            System.out.println("p" + id + " gets access to CR");
        }

        void releaseCS(Site[] sites) {
            requestQueue.poll();
            for (Site site : sites) {
                if (site.id != id) {
                    site.receiveRelease(id);
                }
            }
        }    

        void receiveRelease(int senderId) {
            System.out.println("p" + id + "<- REL <- p" + senderId);
        }

        @Override
        public int compareTo(Site other) {
            if (this.timestamp != other.timestamp) {
                return Integer.compare(this.timestamp, other.timestamp);
            }
            else {
            return Integer.compare(this.id, other.id);
            }
        }
    }

public class DistributedMutualExclusion {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out. print("Enter number of Processes: ");
        int n = scanner.nextInt();

        Site[] sites = new Site[n];

        // Initialize sites with timestamps
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Timestamp of process " + (i + 1) + " (100 for NI): ");
            int timestamp = scanner.nextInt();
            sites[i] = new Site(i + 1, timestamp);
        }
        // Sort sites based on timestamps
        Arrays. sort(sites) ;

        scanner.close();

        // Request critical section for each site
        for (Site site: sites) {
            site.requestCS(sites);
        }
        // Enter critical section for each site
        for (Site site : sites) {
            site.enterCS();
            site.releaseCS(sites);
        }
    }
}