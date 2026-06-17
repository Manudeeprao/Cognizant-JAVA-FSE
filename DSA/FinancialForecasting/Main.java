public class Main {
    
    public static void main(String[] args) {
        double currentValue = 10000;
        double growthRate = 0.10;
        int years = 5;
        
        System.out.println("\n╔═══ FINANCIAL FORECASTING - RECURSION DEMONSTRATION ═══╗\n");
        System.out.println("Investment: $" + currentValue + " at " + (growthRate * 100) + "% for " + years + " years\n");
        
        System.out.println("1. RECURSIVE APPROACH - O(n) time, O(n) space:");
        double resultRecursive = FinancialForecast.futureValue(currentValue, growthRate, years);
        System.out.println("   Result: $" + String.format("%.2f", resultRecursive) + "\n");
        
        System.out.println("2. ITERATIVE APPROACH - O(n) time, O(1) space:");
        double resultIterative = FinancialForecast.futureValueIterative(currentValue, growthRate, years);
        System.out.println("   Result: $" + String.format("%.2f", resultIterative) + "\n");
        
        System.out.println("3. OPTIMAL APPROACH - O(1) time, O(1) space:");
        double resultOptimal = FinancialForecast.futureValueOptimal(currentValue, growthRate, years);
        System.out.println("   Result: $" + String.format("%.2f", resultOptimal) + "\n");
        
        boolean allEqual = Math.abs(resultRecursive - resultIterative) < 0.01 &&
                          Math.abs(resultIterative - resultOptimal) < 0.01;
        System.out.println("✓ All results match: " + (allEqual ? "PASS" : "FAIL"));
        
        double gain = resultRecursive - currentValue;
        double gainPercent = (gain / currentValue) * 100;
        System.out.println("\nGain: $" + String.format("%.2f", gain) + " (" + String.format("%.2f", gainPercent) + "%)\n");
        
        System.out.println("═════════ COMPARISON TABLE ═════════");
        System.out.printf("%-12s | %-10s | %-10s%n", "Approach", "Time", "Space");
        System.out.println("-".repeat(38));
        System.out.printf("%-12s | %-10s | %-10s%n", "Recursive", "O(n)", "O(n)");
        System.out.printf("%-12s | %-10s | %-10s%n", "Iterative", "O(n)", "O(1)");
        System.out.printf("%-12s | %-10s | %-10s%n", "Optimal", "O(1)", "O(1)");
        System.out.println("\n═════════════════════════════════\n");
    }
}
