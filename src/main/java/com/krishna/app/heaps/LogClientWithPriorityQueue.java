package com.krishna.app.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LogClientWithPriorityQueue {

    private static PriorityQueue<ProcessStats> logStatsPriorityQueue = new PriorityQueue<>(new Comparator<ProcessStats>() {
        @Override
        public int compare(ProcessStats o1, ProcessStats o2) {
            return (int) (o1.startTime - o2.startTime);
        }
    });

    Map<String, ProcessStats> processStatsMap = new HashMap<>();

    void start(String processId) {
        processStatsMap.put(processId, new ProcessStats(processId, System.currentTimeMillis()));
    }

    void end(String processId) {
        ProcessStats processStats = processStatsMap.get(processId);
        processStats.setEndTime(System.currentTimeMillis());
        logStatsPriorityQueue.add(processStats);
        processStatsMap.remove(processId);
    }

    void poll() {
        System.out.println(logStatsPriorityQueue.poll());
    }

    private void peek() {
        System.out.println(logStatsPriorityQueue.peek());
    }

    public static void main(String[] args) throws InterruptedException {
        LogClientWithPriorityQueue logClientWithPriorityQueue = new LogClientWithPriorityQueue();
        logClientWithPriorityQueue.start("P3");//Started at 10:07s
        Thread.sleep(2000);
        logClientWithPriorityQueue.start("P2");//Started at 10:08s
        Thread.sleep(2000);
        logClientWithPriorityQueue.end("P2");//Ended at 10:12s
        logClientWithPriorityQueue.start("P1");//Started at 10:12s
        System.out.println("============@10:12s==========");
        logClientWithPriorityQueue.peek();
        Thread.sleep(2000);
        logClientWithPriorityQueue.end("P1");//Ended at 10:15s
        System.out.println("============@10:15s==========");
        logClientWithPriorityQueue.peek();
        Thread.sleep(2000);
        logClientWithPriorityQueue.end("P3");//Ended at 10:19s
        Thread.sleep(2000);
        System.out.println("============@10:19s==========");
        logClientWithPriorityQueue.poll();
        logClientWithPriorityQueue.poll();
        logClientWithPriorityQueue.poll();
        /*int oldCapacity = 96;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        System.out.println(newCapacity);*/
    }



    public class ProcessStats implements  Comparable<ProcessStats> {
        public String processId;
        public long startTime;
        public long endTime;

        public ProcessStats(String processId, long startTime) {
            this.processId = processId;
            this.startTime = startTime;
        }

        public String getProcessId() {
            return processId;
        }

        public void setProcessId(String processId) {
            this.processId = processId;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ProcessStats logstats) {
            return (int) (this.startTime - logstats.startTime);
        }

        @Override
        public String toString() {
            return "ProcessStats{" +
                    "processId='" + processId + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
