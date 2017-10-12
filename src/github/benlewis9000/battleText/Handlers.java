package github.benlewis9000.battleText;

public class Handlers {

    public static void delay(int milliseconds){
        int m = milliseconds;

        try {
            Thread.sleep(m);
        } catch (InterruptedException e){

            System.out.println("Sleep failed for: " + String.valueOf(m) + "ms");
            System.out.println(e.getMessage());

        }
    }
}