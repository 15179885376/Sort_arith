/**
 * @author Zzy
 * @create 2019  03  14:20
 * @desc
 **/

/*
 *  归并排序实现
 * */
public class merge_sort {
    public static void main(String[] args) {
            int a[]={1,223,12,5,6,3};
        One_group_low2up(a);
            for(int i=0;i<a.length;i++)
            {
                System.out.println(a[i]);
            }
    }
    // 自上至下归并
    // 合并 两个子序列的数组
    public static void merge(int a[], int left, int mid, int right) {
        int temp[] = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;   //定义一个临时索引
        //  合并两个子数组到临时数组中：通过比较取小值到temp[k++]中；
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 合并子数组中的剩余元素
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= right) {
            temp[k++] = a[j++];
        }
        //将排序后的数组temp复制到原数组中
        for (int z = 0; z < k; z++) {
            a[z + left] = temp[z];
        }
        //释放temp;
        temp = null;
    }

    public static void One_group(int a[], int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //递归分解，合并子数组
        One_group(a, left, mid);
        One_group(a, mid + 1, right);
        //合并
        merge(a, left, mid, right);
    }

    //自下至上归并排序
//    对数组a做若干次合并：数组a的总长度为len，将它分为若干个长度为gap的子数组； 将"每2个相邻的子数组" 进行合并排序。
//     len -- 数组的长度
//     gap -- 子数组的长度
    public static void merge_low2up(int a[],int len,int gap ){
             int i=0;
             int twolen=2 * gap;
             //将每两个相邻的数组合并
             for(i=0;i+2*gap-1<len;i+=2*gap){
                 merge(a,i,i+gap-1,i+2*gap-1);
                 //如果有落单的数组另外合并
                 if(i+gap-1<len-1){
                     merge(a,i,i+gap-1,len-1);
                 }
             }
    }
    public static void One_group_low2up(int a[]){
         if(a==null)
             return;
         for ( int i=1;i<a.length;i*=2){
             merge_low2up(a,a.length,i);
         }

    }
}
