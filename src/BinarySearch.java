public class BinarySearch {
    // Metoda de căutare binară
    // Returnează indexul elementului căutat dacă este găsit, altfel returnează -1
    static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Dacă elementul este în mijloc
            if (array[mid] == target) {
                return mid;
            }

            // Dacă elementul este mai mic, ignorăm partea dreaptă
            if (array[mid] < target) {
                left = mid + 1;
            }
            // Dacă elementul este mai mare, ignorăm partea stângă
            else {
                right = mid - 1;
            }
        }

        // Elementul nu a fost găsit
        return -1;
    }

    // Metoda de testare a căutării binare
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 10, 40};
        int target = 10;
        int result = search(array, target);

        if (result == -1) {
            System.out.println("Elementul nu a fost găsit în array.");
        } else {
            System.out.println("Elementul a fost găsit la indexul " + result);
        }

        // Apelează clasa Main
        Main.main(args);
        Test.main(args);
    }
}
