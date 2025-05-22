// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // code here
         Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < n; i++) free.add(i);
        int[] count = new int[n];

        for (int[] m : meetings) {
            int start = m[0], end = m[1];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                long[] b = busy.poll();
                free.add((int)b[1]);
            }
            if (!free.isEmpty()) {
                int room = free.pollFirst();
                busy.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] b = busy.poll();
                long newStart = b[0], room = b[1];
                busy.offer(new long[]{newStart + (end - start), room});
                count[(int)room]++;
            }
        }

        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }
        return res;
        
    }
}