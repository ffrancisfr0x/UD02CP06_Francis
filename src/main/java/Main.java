import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de Fibonacci a calcular: ");
        int n = sc.nextInt();

        Resultados resultados = new Resultados(n);
        List<Thread> hilos = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            Thread hilo = new Thread(new Fibonacci(i, resultados));
            hilos.add(hilo);
            hilo.start();
        }

        try {
            for (Thread h : hilos) {
                h.join();
            }

            System.out.println("*****************************************");
            System.out.println("FIBONACCI " + n + ": " + resultados.esperar(n));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
