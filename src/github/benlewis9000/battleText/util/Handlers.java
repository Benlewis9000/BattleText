package github.benlewis9000.battleText.util;

public class Handlers {
	public static void delay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.println("Sleep failed for: " + String.valueOf(milliseconds) + "ms");
			System.out.println(e.getMessage());
		}
	}
}