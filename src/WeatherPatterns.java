import java.util.ArrayList;

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
        int tempLen = temperatures.length;

        int count;
        int longestCount = 0;
        ArrayList<Integer>[] adjacentList = new ArrayList[tempLen];

        for (int i = 0; i < tempLen; i++){
            adjacentList[i] = new ArrayList<>();
        }

        // Fill adjacency list
        for (int i = 0; i < tempLen; i++){
            for (int j = i; j < tempLen; j++){
                if (temperatures[j] > temperatures[i]){
                    adjacentList[j].add(i);
                }
            }
        }

        // Stores the longest run up to that index, corresponding to temp at that same index in temperatures
        int[] longestRun = new int[tempLen];


        for (int i = 0; i < tempLen; i++){
            count = longestPathTo(adjacentList, i, longestRun);
            longestRun[i] = count;

            if (count > longestCount) {
                longestCount = count;
            }
        }

        // Returns the longest run
        return longestCount;
    }

    public static int longestPathTo(ArrayList<Integer>[] adjacentList, int node, int[] longestRun){
        int len = 0;

        // Base case: returns early if
        if(longestRun[node] != 0){
            return longestRun[node];
        }

        for (int leadingNode : adjacentList[node]){
            len = Integer.max(len, longestPathTo(adjacentList, leadingNode, longestRun));
        }

        longestRun[node] = 1 + len;

        return 1 + len;
    }
}
