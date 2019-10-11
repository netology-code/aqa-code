package ru.netology.unit;

public class Main {
    public static void main(String[] args) {
        BonusService service = new BonusService();
        {
            System.out.println("It should return 0 for 1000");
            int result = service.calculateBonus(1000);
            System.out.println(0 == result);
        }
        {
            System.out.println("It should return 10 for 2000");
            int result = service.calculateBonus(2000);
            System.out.println(10 == result);
        }
    }
}
