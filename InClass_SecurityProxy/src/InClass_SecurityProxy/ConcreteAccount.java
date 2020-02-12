package InClass_SecurityProxy;// Dr. Yoder. MSOE. 09 February 2017

import java.util.Comparator;

public class ConcreteAccount implements Account {
    private String name;

    private int pennies;

    public ConcreteAccount(String name, int pennies) {
        this.name = name;
        this.pennies = pennies;
    }

    public ConcreteAccount(String name) {
        this(name,0);
    }

    public String getName(){
        return name;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    public static class SortByName implements Comparator<Account> {
        @Override
        public int compare(Account c1, Account c2) {
            return c1.getName()
                    .compareTo(c2.getName());
        }
    }

    public static class SortByPennies implements Comparator<Account> {
        @Override
        public int compare(Account c1, Account c2) {
            return c2.getPennies()
                    - c1.getPennies();
        }
    }
}
