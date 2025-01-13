/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // TODO: Write your code here!
        int count = 1;
        int longestCount = 1;

        for (int i = 0; i < temperatures.length; i++){
            int lastTemp = temperatures[i];
            count = 1;
            for (int j = 0; j < temperatures.length; j++){
                if (temperatures[j] > lastTemp){
                    count++;
                    lastTemp = temperatures[j];
                }
            }
            if (count > longestCount){
                longestCount = count;
            }
        }
        return longestCount;
    }
}
