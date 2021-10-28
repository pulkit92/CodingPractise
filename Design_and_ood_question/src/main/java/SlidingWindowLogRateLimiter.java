import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;

/*Last 1 sec should not have received more than 3 requests.
        Last 10 secs should not have receieved more than 20 requests.
        Last 1 min should not have received more than 60 requests.*/
public class SlidingWindowLogRateLimiter {
    public static void main(String args[]) {
        List<Integer> a = new ArrayList<>(List.of(1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 5, 6, 5, 5, 5, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 20, 20, 20, 35, 35, 35, 36, 36, 36, 37, 38, 40));
        SlidingWindowLogRateLimiter slidingWindowLogRateLimiter = new SlidingWindowLogRateLimiter();
        System.out.println(slidingWindowLogRateLimiter.droppedRequests(a));
    }

    public int droppedRequests(List<Integer> requestTime) {
        SlidingWindowLog sw1 = new SlidingWindowLog(1, 3);
        SlidingWindowLog sw2 = new SlidingWindowLog(10, 20);
        SlidingWindowLog sw3 = new SlidingWindowLog(60, 60);

        int counter = 0;

        for (int i = 0; i < requestTime.size(); i++) {
            int ts = requestTime.get(i);
            boolean sw1Result = sw1.isAllowed(ts);
            boolean sw2Result = sw2.isAllowed(ts);
            boolean sw3Result = sw3.isAllowed(ts);

            if (!sw1Result || !sw2Result || !sw3Result) {
                counter++;
            }
        }

        return counter;
    }

}

class SlidingWindowLog {
    int maxCap;
    int winddwSize;

    PriorityQueue<Integer> log = new PriorityQueue<Integer>((t1, t2) -> (int) (t1 - t2)); //can be a normal linkedlist too achieve O(1). I user min heap first and changed it to LL later

    public SlidingWindowLog(int maxCap, int winddwSize) {
        this.maxCap = maxCap;
        this.winddwSize = winddwSize;
    }

    public boolean isAllowed(int timeStamp) {
        int cT = timeStamp;
        int startWindow = cT - winddwSize;

        while (!log.isEmpty() && log.peek() <= startWindow) {
            log.poll();
        }
        log.offer(timeStamp);//O(log N)
        boolean result = log.size() <= this.maxCap;
        return result;
    }
}
