/**
 * @author Zzy
 * @create 2019  02  12:47
 * @desc
 **/
public class Insert_dort {
    public static void main(String[] args) {
        int a[] = {3, 12, 32, 1, 3};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int[] a) {
        int n = a.length;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = a[i];
            while (i >= 1 && temp < a[i - 1]) {
                a[i]=a[i-1];
                i--;
            }
            a[i] = temp;
        }
    }
}
