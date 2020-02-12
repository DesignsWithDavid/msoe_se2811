package InClass_SecurityProxy;// Dr. Yoder. MSOE. 09 February 2017

import java.text.DecimalFormat;
import java.util.Scanner;

public class ClientPlugin {
    private DecimalFormat formatter = new DecimalFormat("$#,###,##0.00");
    public void getAccountInfo(Account account) {
        System.out.println(account.getName()+"'s account has "
                +formatter.format((double)account.getPennies()/100)
                +" in it.");

        System.out.println("Now hacking the bank...");
        account.setPennies(account.getPennies()+1000000);

        System.out.println(account.getName()+"'s account has "
                +formatter.format((double)account.getPennies()/100)
                +" in it.");
    }
}
