public class Algoritmos {

    //Métodos utilizados ao decorrer das ordenações
    private void inverte(int[] lista, int nova, int anterior) { // Inverte o array a partir de um índice auxiliar
        int aux = lista[nova];
        lista[nova] = lista[anterior];
        lista[anterior] = aux;
    }

    private int particiona(int[] lista, int inferior, int superior) { // Particiona o array em superior e inferior a partir de um pivo para as comparações do QuickSort
        int inf = inferior + 1;
        int sup = superior;
        int pivo = lista[inferior];
        while(inf <= sup) {
            if(lista[inf] < pivo) {
                inf++;
            }
            else if(lista[sup] > pivo) {
                sup--;
            }
            else if(inf <= sup) {
                trocar(lista, inf, sup);
                inf++;
                sup--;
            }
        }
        trocar(lista, inferior, sup);
        return sup;
    }

    private void trocar(int[] lista2, int inf, int sup) { // Troca de posição as dias partições de um array
        int auxiliar = lista2[inf];
        lista2[inf] = lista2[sup];
        lista2[sup] = auxiliar;
    }

    //QuickSort -- Ordena a partir da comparação sequencial dos elementos de cada partição,
    //mas antes disso particiona o array em dois a partir do primeiro elemento que for menor que o inicial da comparação
    public void quickSort(int[] lista, int inferior, int superior) {
        int pivo;
        if(inferior < superior) {
            pivo = particiona(lista, inferior, superior);
            quickSort(lista, inferior, pivo - 1);
            quickSort(lista, pivo + 1, superior);
        }
    }

    //InsertionSort -- Ordena sempre comparando o elemento com seu antecessor
    public void insertionSort(int[] lista) {
        for(int i = 1; i < lista.length; i++) {
            int elemento = lista[i];
            int inicio = i - 1;
            while( inicio >= 0 && lista[inicio] > elemento) {
                lista[inicio + 1] = lista[inicio];
                inicio--;
            }
            lista[inicio + 1] = elemento;
        }
    }

    //SelectionSort -- Ordena comparando em sequência cada elemento com cada outro elemento em outra posição deslocando-o para a posição corretamente ordenada
    public void selectionSort(int[] lista, int position) {
        while(position < lista.length) {
            int menor = position;
            for(int i = position; i < lista.length; i++) {
                if(i == 0) {
                    menor = i;
                }
                else if(lista[i] < lista[menor]){
                    menor = i;
                }
            }
            inverte(lista, position, menor);
            position++;
        }
    }

    //ShellSort -- Funciona comparando os elementos da mesma maneira que o InsertionSort, porém agora de dois elementos simetricamente distantes
    public void shellSort(int[] lista) {
        int incremento = lista.length / 2;
        while (incremento > 0) {
            for (int i = incremento; i < lista.length; i++) {
                int position = i;
                int nunber = lista[i];
                while (position >= incremento && lista[position - incremento] > nunber) {
                    lista[position] = lista[position - incremento];
                    position = position - incremento;
                }
                lista[position] = nunber;
            }
            if (incremento == 2) {
                incremento = 1;
            } else {
                incremento *= 2;
            }
        }
    }

    // HeapSort --
    public void heapSort(int[] lista) {
        int n = lista.length;
        ordenaHeap(lista, n);
        for (int i = n - 1; i > 0; i--) {
            inverte(lista, 0, i);
            int j = 0, indice;
            do {
                indice = (2 * j + 1);
                if (indice < (i - 1) && lista[indice] < lista[indice + 1])
                    indice++;
                if (indice < i && lista[j] < lista[indice])
                    inverte(lista, j, indice);
                j = indice;
            } while (indice < i);
        }
    }
    private void ordenaHeap(int[] lista, int tamanho) {
        for (int i = 1; i < tamanho; i++) {
            if (lista[i] > lista[(i - 1) / 2]) {
                int filhoMaior = i;
                while (lista[filhoMaior] > lista[(filhoMaior - 1) / 2]) {
                    inverte(lista, filhoMaior, (filhoMaior - 1) / 2);
                    filhoMaior = (filhoMaior - 1) / 2;
                }
            }
        }
    }

    //MergeSort -- Se utiliza da divisão em pares para comparar subconjuntos do array aumentando o número de arrays porém diminuindo a quantidade de comparações necessárias
    public void mergeSort(int[] lista, int inicio, int fim) {
        if(fim - inicio > 1) {
            int meio = (int)(fim + inicio) / 2;
            mergeSort(lista, inicio, meio);
            mergeSort(lista, meio, fim);
            merge(lista, inicio, meio, fim);
        }
    }
    private void merge(int[] lista, int inicio, int meio, int fim) {
        int[] esquerda = new int[meio - inicio];
        int[] direita = new int[fim - meio];
        int topoEsquerda = 0;
        int topoDireita = 0;

        //Criando o array da esquerda
        int cont = 0;
        for(int i = inicio; i < meio; i++) {
            esquerda[cont] = lista[i];
            cont++;
        }

        //Criando o array da direita
        int count = 0;
        for(int j = meio; j < fim; j++) {
            direita[count] = lista[j];
            count++;
        }
        for(int posicao = inicio; posicao < fim; posicao++) {
            if(topoEsquerda >= esquerda.length) {
                lista[posicao] = direita[topoDireita];
                topoDireita++;
            }
            else if(topoDireita >= direita.length) {
                lista[posicao] = esquerda[topoEsquerda];
                topoEsquerda++;
            }
            else if(esquerda[topoEsquerda] < direita[topoDireita]) {
                lista[posicao] = esquerda[topoEsquerda];
                topoEsquerda++;
            }
            else {
                lista[posicao] = direita[topoDireita];
                topoDireita++;
            }
        }
    }
}
