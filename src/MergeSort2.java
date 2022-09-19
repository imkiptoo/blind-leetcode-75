public class MergeSort2 {
    public static void main(String[] args){
        int[] A = {2, 3, 1, 5, 1, 6, 1, 7, 8, 3, 1, 4, 6, 3, 9, 8, 3, 2};
        int lA = A.length;

        MergeSort2 ms2 = new MergeSort2();
        ms2.mergeSort(A, 0,  lA - 1, false);
        printArray(A);
    }

    static void printArray(int[] A){
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i]+" ");
        }
    }

    void mergeSort(int[] A, int p, int r, boolean asc){
        if(p < r){
            int q = (p + r) / 2;
            mergeSort(A, p, q, asc);
            mergeSort(A, q+1, r, asc);
            merge(A, p, q, r, asc);
        }
    }

    void merge(int[] A, int p, int q, int r, boolean asc){
        int n1 = q+1 - p;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] M = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = A[i];
        }

        for(int j = 0; j < n2; j++){
            M[j] = A[j];
        }

        int i = 0;
        int j = 0;
        int k = p;

        while(i < n1 && j < n2){
            if(asc == L[i] <= M[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = M[j];
                j++;
            }
        }

        while(i < n1){
            A[k] = L[i];
            i++;
            k++;
        }

        while(i < n1){
            A[k] = M[i];
            j++;
            k++;
        }
    }
}
