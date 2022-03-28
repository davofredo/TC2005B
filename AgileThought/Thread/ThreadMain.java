public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        MiClaseTarea h1 = new MiClaseTarea("Thread 1");
        Thread h2 = new Thread(new MiClaseTareaRunnable());

        h1.start();
        h2.start();

        System.out.println("Estado actual del hilo 1: " + h1.getState());
        System.out.println("Estado actual del hilo 2: " + h2.getState());

        Thread.sleep(5000);

        System.out.println("Estado actual del hilo 1: " + h1.getState());
        System.out.println("Estado actual del hilo 2: " + h2.getState());
    }
}