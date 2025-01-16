/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Liliana Dhaliwal
 */

public class WeatherPatterns {
    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        int count;
        int longestCount = 0;
        int lastTemp;

        // Stores the longest run up to that index, corresponding to temp at that same index in temperatures
        int[] longestRun = new int[temperatures.length];

        // Iterates through all the temperatures
        for (int i = 0; i < temperatures.length; i++) {
            lastTemp = temperatures[i];

            count = 0;

            // Looks at every count up to that point
            for (int j = 0; j <= i; j++) {
                if (temperatures[j] < lastTemp && longestRun[j] > count) {
                    count = longestRun[j];
                }
            }

            // Set the longest run value at the current index
            longestRun[i] = count + 1;

            // Update longest count
            if (longestRun[i] > longestCount) {
                longestCount = longestRun[i];
            }
        }
        // Returns the longest run
        return longestCount;
    }
}
