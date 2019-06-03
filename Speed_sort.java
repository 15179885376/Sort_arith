/**
 * @author Zzy
 * @create 2019  01  11:47
 * @desc
 **/
public class Speed_sort {
    public static void main(String[] args) {
         int[]a={2,1,4,5,23,67};
         sort(a,0,a.length-1);
         for(int i=0;i<a.length;i++){
             System.out.print(a[i]+"   ");
         }
    }
    public static void sort(int a[],int left,int right){
        int i=left;
        int j=right;
        if(left>right){
            return ;
        }
        int temp=a[left];
        //找到基准值的位置
        while(i!=j){
            while(a[j]>=temp && i<j){
                j--;
            }
            while(a[i]<=temp && i<j){
                i++;
            }
            if(i<j){
                int flag=a[i];
                a[i]=a[j];
                a[j]=flag;
            }
        }
        //将基准值归位
        a[left]=a[i];
        a[i]=temp;
        sort(a,left,i-1); //递归
        sort(a,i+1,right);
    }
}
