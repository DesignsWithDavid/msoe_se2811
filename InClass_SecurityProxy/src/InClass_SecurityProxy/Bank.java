package InClass_SecurityProxy;

public class Bank {
    public static void main(String[] args) {
        AccountList list = new AccountList();

        list.add(new ConcreteAccount("Bob", 100000));
        list.add(new ConcreteAccount("Alice", 200000));
        list.add(new ConcreteAccount("Trudy", 500));

        list.printAll();
        // TODO: Replace SortByX with lambda
        list.sort(new ConcreteAccount.SortByName());
        System.out.println();
        list.printAll();

        // TODO: Replace SortByX with lambda
        Account trudysAccount = list.find(new ConcreteAccount.SortByName(),
                new ConcreteAccount("Trudy"));
        ClientPlugin clientPlugin = new ClientPlugin();
        clientPlugin.getAccountInfo(trudysAccount);

        list.printAll();
        // TODO: Replace SortByX with lambda
        list.sort(new ConcreteAccount.SortByPennies());
        System.out.println();
        list.printAll();
    }
}
