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

        int count = 0;
        int longestCount = 0;
        int lastTemp;
        int lastTempIndex;

        for (int i = 0; i < temperatures.length; i++){
            lastTemp = temperatures[i];
            lastTempIndex = i;

            count = 1;
            for (int j = 0; j < temperatures.length; j++){
                if (temperatures[j] > lastTemp && lastTempIndex < j){
                    count++;
                    lastTemp = temperatures[j];
                    lastTempIndex = j;
                }
            }
            if (count > longestCount){
                longestCount = count;
            }
        }
        return longestCount;
    }

    // Have another recursive method
    // Start from the back of the tempuratures and move backwards'



}
