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

            //Calculating debts
            if (borrowerExists) {
                Long newValue = balance.get(borrower) - value;
                balance.put(borrower, newValue);
            } else {
                Long newValue = 0 - value;
                balance.put(borrower, newValue);
            }

            //Calculating credits
            if (lenderExists) {
                Long newValue = balance.get(borrower) + value;
                balance.put(lender, newValue);
            } else {
                balance.put(lender, value);
            }
        });

        //remove positive balances
        for (Map.Entry<String, Long> entry : balance.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();

            if (value >= 0) {
                balance.remove(key);
            }
        }

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

        return negativeBalance.stream().sorted().collect(Collectors.toList());
    }
}
