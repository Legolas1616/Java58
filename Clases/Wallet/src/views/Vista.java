package views;

import model.Wallet;
public class Vista {
    public static void main3(String[] args) throws Exception {
        Wallet wallet1 = new Wallet();
        System.out.println(wallet1.getSaldo());
        System.out.println(wallet1.saveMoney(200000));

    }
}
