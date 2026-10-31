public class LeetCode037_AlternatePrint {
    private static final Object lock = new Object();
    private static volatile boolean digitTurn = true;
    private static final int MAX = 26;

    public static void main(String[] args) {
        Thread digitThread = new Thread(() -> {
            for (int i = 1; i <= MAX; i++) {
                synchronized (lock) {
                    while (!digitTurn) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    }
                    System.out.print(i);
                    digitTurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread letterThread = new Thread(() -> {
            for (char c = 'A'; c <= 'Z'; c++) {
                synchronized (lock) {
                    while (digitTurn) {
                        try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    }
                    System.out.print(c);
                    digitTurn = true;
                    lock.notifyAll();
                }
            }
        });

        digitThread.start();
        letterThread.start();
    }
}
