import java.util.*;
import java.util.stream.Collectors;

public class Challenge {

    public static List<String> getSmallestNegativeBalance(List<List<String>> debts) {

        Map<String, Long> balance = new HashMap<>();

        debts.forEach(debt -> {

            String borrower = debt.get(0); //decrease from
            String lender = debt.get(1); //inscrease from
            Long value = Long.parseLong(debt.get(2)); //value

            boolean borrowerExists = balance.containsKey(borrower);
            boolean lenderExists = balance.containsKey(lender);
            Long currentValue;
            Long newValue;

            //Calculating debts
            currentValue = balance.get(borrower) == null ? 0L : balance.get(borrower);
            newValue = currentValue - value;
            balance.put(borrower, newValue);

            //Calculating credits
            currentValue = balance.get(lender) == null ? 0L : balance.get(lender);
            newValue = currentValue + value;
            balance.put(lender, newValue);
        });

        balance.entrySet().removeIf(e -> e.getValue() >= 0);

        System.out.println("negative balance: " + balance);

        if (balance.size() == 0) {
            return Arrays.asList("Nobody has a negative balance");
        }

        //get lowest value
        Long lowestValue = 0L;
        for (Map.Entry<String, Long> entry : balance.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (value < lowestValue) {
                lowestValue = value;
            }
        }



        //get the lowest value
        List<String> negativeBalance = new ArrayList<>();
        for (Map.Entry<String, Long> entry : balance.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();


            if (value == lowestValue) {
                negativeBalance.add(key);
            }
        }

        System.out.println("before sorting: " + negativeBalance);
        negativeBalance = negativeBalance.stream().sorted().collect(Collectors.toList());

        System.out.println("after sorting: " + negativeBalance);

        return negativeBalance;
    }
}
