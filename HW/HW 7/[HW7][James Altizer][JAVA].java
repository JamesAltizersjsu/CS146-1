//We read the number of intervals and the intervals themselves.
//We sort the intervals based on their start times.
//We use a min heap (priority queue) to keep track of the end times of currently running jobs.
//For each interval, we check if there’s an available server. If so, we update its end time; otherwise, we allocate a new server.
//The size of the heap at the end represents the minimum number of servers needed.
import java.util.Arrays;
import java.util.PriorityQueue;

public class ServerAllocation {

    public int minMeetingRooms(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Initialize a min heap to track end times of running jobs
        PriorityQueue<Integer> servers = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            // Check if there's an available server
            while (!servers.isEmpty() && servers.peek() <= start) {
                servers.poll();
            }

            // Allocate a new server
            servers.offer(end);
        }

        // The size of the heap represents the minimum servers needed
        return servers.size();
    }

    public static void main(String[] args) {
        // Example usage
        int[][] intervals = {{1, 3}, {2, 5}, {3, 6}, {4, 7}};
        ServerAllocation serverAllocation = new ServerAllocation();
        System.out.println(serverAllocation.minMeetingRooms(intervals));  // Output: 2
    }
}
