// Task Scheduler
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks array declaration
        int[] frequencies = new int[26];
        // use a for each loop to iterate through the tasks array
        for (int t : tasks) {
        // for each iteration make the value at the index of the Array
        // equal to t minus the character A
        // incremented by one
            frequencies[t - 'A']++;
        }
        // after the loop sort the array
        Arrays.sort(frequencies);

        // max frequency integer declaration with the value at index 25 of frequencies (the last)
        // it's at the index of 25 because it's sorted in ascending order
        int f_max = frequencies[25];
        // also declare an integer equal to (max frequency minus one) times n
        int idle_time = (f_max - 1) * n;
        // now iterate through while the index is greater than or equal to zero
        // and also the idle_time variable is greater than zero
        for (int i = frequencies.length - 2; i >= 0 && idle_time > 0; --i) {
          // on each iteration make the idle time equal to itself minus
          // the minimum value between max frequency minus one and the
          // value at frequencies at i
            idle_time -= Math.min(f_max - 1, frequencies[i]);
        }
        // now make idle_time equal to the max value between zero and itself
        // to eliminate having a negative value
        idle_time = Math.max(0, idle_time);
        // now the sum of idle_time and the length of the tasks array is the leastInterval
        return idle_time + tasks.length;
    }
