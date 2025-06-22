public class FinancialForecasting {

    
    public static double calculateFutureValueRecursive(double initialAmount, double annualGrowthRate, int totalYears) {
        if (totalYears == 0) {
            return initialAmount;
        }
        return calculateFutureValueRecursive(initialAmount, annualGrowthRate, totalYears - 1) * (1 + annualGrowthRate);
    }

   
    public static double calculateFutureValueIterative(double initialAmount, double annualGrowthRate, int totalYears) {
        double futureAmount = initialAmount;
        for (int year = 0; year < totalYears; year++) {
            futureAmount *= (1 + annualGrowthRate);
        }
        return futureAmount;
    }

    
    public static void main(String[] args) {
        double initial = 10000;
        double rate = 0.05;
        int years = 5;

        double resultRecursive = calculateFutureValueRecursive(initial, rate, years);
        double resultIterative = calculateFutureValueIterative(initial, rate, years);

        System.out.printf("Recursive result: Rs. %.2f%n", resultRecursive);
        System.out.printf("Iterative result: Rs. %.2f%n", resultIterative);
    }
}
