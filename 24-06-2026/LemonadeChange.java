public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 5, 20};

        System.out.println(lemonadeChange(bills));
    }

    private static boolean lemonadeChange(int[] bills) {
        int fiveBills = 0;
        int tenBills = 0;

        for (int num : bills) {
            if (num == 5) {
                fiveBills++;
            } else if (num == 10) {
                if (fiveBills == 0)
                    return false;
                fiveBills--;
                tenBills++;
            } else {
                if (tenBills > 0 && fiveBills > 0) {
                    tenBills--;
                    fiveBills--;
                } else if (fiveBills >= 3) {
                    fiveBills -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}