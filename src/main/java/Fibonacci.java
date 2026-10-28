public class Fibonacci implements Runnable {
    private final int i;
    private final Resultados resultados;

    public Fibonacci(int i, Resultados resultados) {
        this.i = i;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        try {
            long term1 = resultados.esperar(i - 1);
            long term2 = resultados.esperar(i - 2);

            long resultado = term1 + term2;

            System.out.println("Fibonacci " + i + ": " + resultado);

            resultados.publicar(i, resultado);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
