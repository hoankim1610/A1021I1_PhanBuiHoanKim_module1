package ss14_Sort.excercise.e2;

public class InsertionSortSetting {
    void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void insertionSort(int[] list) {
        int n = list.length;
        for (int i = 0; i < n; ++i)
            System.out.print(list[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {30, 56, 2, 13, 23};
        System.out.println("Fist array: ");
        insertionSort(arr);
        InsertionSortSetting ob = new InsertionSortSetting();
        ob.sort(arr);
        System.out.println("Array after sorting: ");
        insertionSort(arr);
    }
}
