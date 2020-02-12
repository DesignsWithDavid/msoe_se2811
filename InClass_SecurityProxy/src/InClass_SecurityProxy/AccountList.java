package InClass_SecurityProxy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class AccountList {

    private ArrayList<Account> accounts = new ArrayList<Account>();;

    public void add(Account cls) {
        accounts.add(cls);
    }

    public void sort(Comparator<Account> comparator) {
        ArrayList<Account> newList = new ArrayList<>();
        for(int oldIndex = 0; oldIndex < accounts.size(); oldIndex++) {
            int newIndex = 0;
            Account newAccount = accounts.get(oldIndex);
            while (newIndex < newList.size()
                    && comparator.compare(newList.get(newIndex), newAccount) <= 0) {
                newIndex++;
            }
            newList.add(newIndex, newAccount);
        }
        accounts = newList;
    }

    public Account find(Comparator<Account> comparator, Account target) {
        int index = 0;
        while (index < accounts.size()
                && comparator.compare(accounts.get(index), target) != 0) {
            index++;
        }
        return accounts.get(index);
    }

    public void printAll() {
        DecimalFormat formatter = new DecimalFormat("$#,###.00");
        for(Account account: accounts) {
            // TODO: Can you find a value for pennies that causes this to print the wrong number?
            System.out.println(account.getName()+ " " +
                    formatter.format(account.getPennies()/100));
        }
    }
}
