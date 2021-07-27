package views;

import model.Wallet;
public class Vista {
    public static void main(String[] args) throws Exception {
        Wallet wallet1 = new Wallet();
        Wallet wallet2 = new Wallet();
        System.out.println(wallet1.getSaldo());
        System.out.println(wallet1.saveMoney(200000));
        System.out.println(wallet2.getSaldo());
        System.out.println(wallet2.saveMoney(200000));
        System.out.println(wallet2.establecerMeta(1000000));
        System.out.println(wallet1.establecerMeta(1900000));

    }
}
