public class Resultados {
    private final long[] valores;
    private final boolean[] listo;

    Resultados(int n) {
        this.valores = new long[n + 1];
        this.listo = new boolean[n + 1];

        if (n >= 0){
            valores[0] = 0;
            listo[0] = true;
        }

        if (n >= 1) {
            valores[1] = 1;
            listo[1] = true;
        }
    }

    synchronized long esperar(int k) throws InterruptedException {
        while (!listo[k]) {
            wait();
        }
        return valores[k];
    }

    synchronized void publicar(int k, long valor) {
        valores[k] = valor;
        listo[k] = true;
        notifyAll();
    }
}
