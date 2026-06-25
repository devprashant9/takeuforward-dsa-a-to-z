import java.util.Arrays;

public class MinPlatforms {

    public static void main(String[] args) {
        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(brute(arrival, departure));
        System.out.println(optimal(arrival, departure));
    }

    private static int brute(int[] arrival, int[] departure) {
        int n = arrival.length;

        int ans = 1;
        for (int i = 0; i < n; i++) {

            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {

                    if ((arrival[i] >= arrival[j] && departure[j] >= arrival[i])) {
                        count++;
                    }
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    private static int optimal(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int stations = 1;
        int maxStations = 1;
        int i = 1;
        int j = 0;

        while (i < arrival.length && j < departure.length) {
            if (arrival[i] <= departure[j]) {
                stations++;
                i++;
            } else {
                stations--;
                j++;
            }
            maxStations = Math.max(maxStations, stations);
        }
        return maxStations;
    }
}