package fireDrillThree;

public class LogisticsCalculator {

    public int calculateDelivery(int successfulDeliveries) {
        int expectedResult = 0;
        if (successfulDeliveries < 50) {
             expectedResult = (successfulDeliveries * 160) + 5000;
        }

        if (successfulDeliveries > 50 && successfulDeliveries <= 59) {
             expectedResult = (successfulDeliveries * 200)+ 5000;
        }
        if (successfulDeliveries > 60 && successfulDeliveries <= 69) {
             expectedResult = (successfulDeliveries * 250)+ 5000;
        }
        if (successfulDeliveries >= 70) {
            expectedResult = (successfulDeliveries * 500) + 5000;
        }
        return expectedResult;
    }

}
