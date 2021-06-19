import java.util.Random;
import java.util.Scanner;

public class Comparacoes {

    public void copia(int[] arrayOriginal, int[] arrayCopia) {
        System.arraycopy(arrayOriginal, 0, arrayCopia, 0, arrayOriginal.length);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Comparacoes c = new Comparacoes();

        System.out.println("Insira o tamanho da array:");
        int tamanho = input.nextInt();

        int[] arrayDesordenado = new int[tamanho];
        int[] gravaDesordenado = new int[tamanho];

        int[] arrayDecrescente = new int[tamanho];
        int[] gravaDecrescente = new int[tamanho];

        int[] arrayQuaseOrdenado = new int[tamanho];
        int[] gravaQuaseOrdenado = new int[tamanho];

        //Inserção no array Desordenado
        Random r = new Random();
        long inicioNumerosDesordenados = System.nanoTime();
        for(int i = 0; i < tamanho; i++) {
            arrayDesordenado[i] = r.nextInt(tamanho * 100);
        }
        long finalizaNumerosDesordenados = System.nanoTime();
        double insercaoDesordenados = (finalizaNumerosDesordenados - inicioNumerosDesordenados);
        insercaoDesordenados = insercaoDesordenados / 1000000000;

        c.copia(arrayDesordenado, gravaDesordenado);

        //Inserção no array decrescente
        long inicioNumerosDecrescentes = System.nanoTime();
        int cont = 0;
        for (int i = tamanho; i > 0; i--) {
            arrayDecrescente[cont] = i;
            cont++;
        }
        long finalizaNumerosDecrescentes = System.nanoTime();
        double insercaoDecrescente = finalizaNumerosDecrescentes - inicioNumerosDecrescentes;
        insercaoDecrescente = insercaoDecrescente / 1000000000;

        c.copia(arrayDecrescente, gravaDecrescente);

        //Inserção no array quase Ordenado
        long inicioQuaseOrdenado = System.nanoTime();
        int porcentagem = (tamanho * 30) / 100;
        for(int i = 0; i < tamanho; i++) {
            if(i % porcentagem == 0 && i != 0) {
                arrayQuaseOrdenado[i] = arrayQuaseOrdenado[i - 1];
                arrayQuaseOrdenado[i - 1] = i;
            }
            else {
                arrayQuaseOrdenado[i] = i;
            }
        }
        long finalizaQuaseOrdenado = System.nanoTime();
        double insercaoQuaseOrdenado = finalizaQuaseOrdenado - inicioQuaseOrdenado;
        insercaoQuaseOrdenado = insercaoQuaseOrdenado / 1000000000;

        c.copia(arrayQuaseOrdenado, gravaQuaseOrdenado);

        Algoritmos ordena = new Algoritmos();

        //QuickSort
        //Ordenando um array totalmente Desordenado
        long inicioDesordenadoQuick = System.nanoTime();
        ordena.quickSort(arrayDesordenado, 0, arrayDesordenado.length - 1);
        long finalizaDesordenadoQuick = System.nanoTime();
        double numDesordenadoQuick = finalizaDesordenadoQuick - inicioDesordenadoQuick;
        numDesordenadoQuick = numDesordenadoQuick / 1000000000;

        c.copia(gravaDesordenado, arrayDesordenado);
        //Ordenando um array decresente
        long inicioDecrescenteQuick = System.nanoTime();
        ordena.quickSort(arrayDecrescente, 0, arrayDecrescente.length - 1);
        long finalizaDecrescenteQuick = System.nanoTime();
        double numDecrescenteQuick = finalizaDecrescenteQuick - inicioDecrescenteQuick;
        numDecrescenteQuick = numDecrescenteQuick/ 1000000000;

        c.copia(gravaDecrescente, arrayDecrescente);
        //Ordenando uma array quase Ordenado
        long inicioQuaseOrdenadoQuick = System.nanoTime();
        ordena.quickSort(arrayQuaseOrdenado, 0, arrayQuaseOrdenado.length - 1);
        long finalizaQuaseOrdenadoQuick = System.nanoTime();
        double numQuaseOrdenadoQuick = finalizaQuaseOrdenadoQuick - inicioQuaseOrdenadoQuick;
        numQuaseOrdenadoQuick = numQuaseOrdenadoQuick / 1000000000;

        c.copia(gravaQuaseOrdenado, arrayQuaseOrdenado);


        //MergeSort
        //Ordenando uma array desordanada
        long inicioDesordenadoMerge = System.nanoTime();
        ordena.mergeSort(arrayDesordenado, 0, arrayDesordenado.length);
        long finalizaDesordenadoMerge = System.nanoTime();
        double numDesordenadoMerge = finalizaDesordenadoMerge - inicioDesordenadoMerge;
        numDesordenadoMerge = numDesordenadoMerge / 1000000000;

        c.copia(gravaDesordenado, arrayDesordenado);
        //Ordenando uma array decrescente
        long inicioDecrescenteMerge = System.nanoTime();
        ordena.mergeSort(arrayDecrescente, 0, arrayDecrescente.length);
        long finalizaDecrescenteMerge = System.nanoTime();
        double numDecrescenteMerge = finalizaDecrescenteMerge - inicioDecrescenteMerge;
        numDecrescenteMerge = numDecrescenteMerge / 1000000000;

        c.copia(gravaDecrescente, arrayDecrescente);
        //Ordenando uma array quase Ordenado
        long inicioQuaseOrdenadoMerge = System.nanoTime();
        ordena.mergeSort(arrayQuaseOrdenado, 0, arrayQuaseOrdenado.length);
        long finalizaQuaseOrdenadoMerge = System.nanoTime();
        double numQuaseOrdenadoMerge = finalizaQuaseOrdenadoMerge - inicioQuaseOrdenadoMerge;
        numQuaseOrdenadoMerge = numQuaseOrdenadoMerge / 1000000000;

        c.copia(gravaQuaseOrdenado, arrayQuaseOrdenado);


        //ShellSort
        //Ordenando array totalmente Desordenado
        long inicioDesordenadoShell = System.nanoTime();
        ordena.shellSort(arrayDesordenado);
        long finalizaDesordenadoShell = System.nanoTime();
        double numDesordenadoShell = finalizaDesordenadoShell - inicioDesordenadoShell;
        numDesordenadoShell = numDesordenadoShell / 1000000000;

        c.copia(gravaDesordenado, arrayDesordenado);
        //Ordenando array decrescente
        long inicioDecrescenteShell = System.nanoTime();
        ordena.shellSort(arrayDecrescente);
        long finalizaDecrescenteShell = System.nanoTime();
        double numDecrescenteShell = finalizaDecrescenteShell - inicioDecrescenteShell;
        numDecrescenteShell = numDecrescenteShell / 1000000000;

        c.copia(gravaDecrescente, arrayDecrescente);
        //Ordenando array decrescente
        long inicioQuaseOrdenadoShell = System.nanoTime();
        ordena.shellSort(arrayQuaseOrdenado);
        long finalizaQuaseOrdenadoShell = System.nanoTime();
        double numQuaseOrdenadoShell = finalizaQuaseOrdenadoShell - inicioQuaseOrdenadoShell;
        numQuaseOrdenadoShell = numQuaseOrdenadoShell / 1000000000;

        c.copia(gravaQuaseOrdenado, arrayQuaseOrdenado);

        //HeapSort
        //Ordenando uma array totalmente Desordenado
        long inicioDesordenadoHeap = System.nanoTime();
        ordena.heapSort(arrayDesordenado);
        long finalizaDesordenadoHeap = System.nanoTime();
        double numDesordenadoHeap = finalizaDesordenadoHeap - inicioDesordenadoHeap;
        numDesordenadoHeap = numDesordenadoHeap / 1000000000;

        c.copia(gravaDesordenado, arrayDesordenado);
        //Ordenando uma array decrescente
        long inicioDecrescenteHeap = System.nanoTime();
        ordena.heapSort(arrayDecrescente);
        long finalizaDecrescenteHeap = System.nanoTime();
        double numDecrescenteHeap = finalizaDecrescenteHeap - inicioDecrescenteHeap;
        numDecrescenteHeap = numDecrescenteHeap / 1000000000;

        c.copia(gravaDecrescente, arrayDecrescente);
        //Ordenando uma array quase Ordenado
        long inicioQuaseOrdenadoHeap = System.nanoTime();
        ordena.heapSort(arrayQuaseOrdenado);
        long finalizaQuaseOrdenadoHeap = System.nanoTime();
        double numQuaseOrdenadoHeap = finalizaQuaseOrdenadoHeap - inicioQuaseOrdenadoHeap;
        numQuaseOrdenadoHeap = numQuaseOrdenadoHeap / 1000000000;

        c.copia(gravaQuaseOrdenado, arrayQuaseOrdenado);


        //SelectionSort

        //Ordenando uma array totalmente Desordenado
        long inicioDesordenadoSelect = System.nanoTime();
        ordena.selectionSort(arrayDesordenado, 0);
        long finalizaDesordenadoSelect = System.nanoTime();
        double numDesordenadoSelect = finalizaDesordenadoSelect - inicioDesordenadoSelect;
        numDesordenadoSelect = numDesordenadoSelect / 1000000000;

        c.copia(gravaDesordenado, arrayDesordenado);
        //ordenando uma list decrescente
        long inicioDecrescenteSelect = System.nanoTime();
        ordena.selectionSort(arrayDecrescente, 0);
        long finalizaDecrescenteSelect = System.nanoTime();
        double numDecrescenteSelect = finalizaDecrescenteSelect - inicioDecrescenteSelect;
        numDecrescenteSelect = numDecrescenteSelect / 1000000000;

        c.copia(gravaDecrescente, arrayDecrescente);
        //Ordenando um array quase Ordenado
        long inicioQuaseOrdenadoSelect = System.nanoTime();
        ordena.selectionSort(arrayQuaseOrdenado, 0);
        long finalizaQuaseOrdenadoSelect = System.nanoTime();
        double numQuaseOrdenadoSelect = finalizaQuaseOrdenadoSelect - inicioQuaseOrdenadoSelect;
        numQuaseOrdenadoSelect = numQuaseOrdenadoSelect / 1000000000;

        c.copia(gravaQuaseOrdenado, arrayQuaseOrdenado);

        //InsertionSort
        //Ordenando um array totalmente Desordenado
        long inicioDesordenadoInsertion = System.nanoTime();
        ordena.insertionSort(arrayDesordenado);
        long finalizaDesordenadoInsertion = System.nanoTime();
        double numDesordenadoInsertion = finalizaDesordenadoInsertion - inicioDesordenadoInsertion;
        numDesordenadoInsertion = numDesordenadoInsertion / 1000000000;

        c.copia(gravaDesordenado, arrayDesordenado);
        //Ordenando um array decrescente
        long inicioDecrescenteInsertion = System.nanoTime();
        ordena.insertionSort(arrayDecrescente);
        long finalizaDecrescenteInsertion = System.nanoTime();
        double numDecrescenteInsertion = finalizaDecrescenteInsertion - inicioDecrescenteInsertion;
        numDecrescenteInsertion = numDecrescenteInsertion / 1000000000;

        c.copia(gravaDecrescente, arrayDecrescente);
        //Ordenando um array quase Ordenado
        long inicioQuaseOrdenadoInsertion = System.nanoTime();
        ordena.insertionSort(arrayQuaseOrdenado);
        long finalizaQuaseOrdenadoInsertion = System.nanoTime();
        double numQuaseOrdenadoInsertion = finalizaQuaseOrdenadoInsertion - inicioQuaseOrdenadoInsertion;
        numQuaseOrdenadoInsertion = numQuaseOrdenadoInsertion / 1000000000;

        c.copia(gravaQuaseOrdenado, arrayQuaseOrdenado);


        //Somando tempos:
        //Quick
        double quickDesordenado = insercaoDesordenados + numDesordenadoQuick;
        double quickDecresente = insercaoDecrescente + numDecrescenteQuick;
        double quickQuaseOrdenado = insercaoQuaseOrdenado + numQuaseOrdenadoQuick;

        //Merge
        double mergeDesordanada = insercaoDesordenados + numDesordenadoMerge;
        double mergeDecrescente = insercaoDecrescente + numDecrescenteMerge;
        double mergeQuaseOrdenado = insercaoQuaseOrdenado + numQuaseOrdenadoMerge;

        //ShellSort
        double shellDesordenado = insercaoDesordenados + numDesordenadoShell;
        double shellDecrescente = insercaoDecrescente + numDecrescenteShell;
        double shellQuaseOrdenado = insercaoQuaseOrdenado + numQuaseOrdenadoShell;

        //HeapSort
        double heapDesordenado = insercaoDesordenados + numDesordenadoHeap;
        double heapDecrescente = insercaoDecrescente + numDecrescenteHeap;
        double heapQuaseOrdenado = insercaoQuaseOrdenado + numQuaseOrdenadoHeap;

        //SelectionSort
        double selectionDesordenado = insercaoDesordenados + numDesordenadoSelect;
        double selectionDecrescente = insercaoDecrescente + numDecrescenteSelect;
        double selectionQuaseOrdenado = insercaoQuaseOrdenado + numQuaseOrdenadoSelect;

        //Insertion
        double insertionDesordenado = insercaoDesordenados + numDesordenadoInsertion;
        double insertionDecrescente = insercaoDecrescente + numDecrescenteInsertion;
        double insertionQuaseOrdenado = insercaoQuaseOrdenado + numQuaseOrdenadoInsertion;


        //Resultados
        char segundos = 's';
        System.out.println("Tamanho do conjunto: " + tamanho);
        System.out.println(" 	                 Tempos obtidos pelos algoritmos");
        System.out.println("Algoritmo     |  Quase Ordenado  |     Desordenado   | Ordem decrescente");
        System.out.printf("QuickSort     |     %.6f%s    |      %.6f%s    |	   %.6f%s%n",quickQuaseOrdenado,segundos, quickDesordenado,segundos,quickDecresente, segundos);
        System.out.printf("ShellSort     |     %.6f%s    |      %.6f%s    |	   %.6f%s%n", shellQuaseOrdenado,segundos,shellDesordenado,segundos,shellDecrescente, segundos);
        System.out.printf("HeapSort      |     %.6f%s    |      %.6f%s    |	   %.6f%s%n", heapQuaseOrdenado,segundos,heapDesordenado,segundos,heapDecrescente, segundos);
        System.out.printf("MergeSort     |     %.6f%s    |      %.6f%s    |	   %.6f%s%n", mergeQuaseOrdenado,segundos,mergeDesordanada,segundos,mergeDecrescente, segundos);
        System.out.printf("SelectionSort |     %.6f%s    |      %.6f%s    |	   %.6f%s%n",selectionQuaseOrdenado,segundos,selectionDesordenado,segundos,selectionDecrescente, segundos);
        System.out.printf("InsertionSort |     %.6f%s    |      %.6f%s    |	   %.6f%s%n",insertionQuaseOrdenado,segundos,insertionDesordenado,segundos,insertionDecrescente, segundos);

        input.close();
    }

}