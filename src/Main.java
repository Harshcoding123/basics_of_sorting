public class Main {
    public static void swap(int a[],int i,int j){
        int temp= a[i];
        a[i]= a[j];
        a[j]= temp;
    }
    public static void count_sort(int a[]){
        int max= Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max) max= a[i];
        }
        int freq[]= new int[max+1];
        for(int i=0;i<a.length;i++){
            freq[a[i]]++;
        }
        for(int i=1;i<freq.length;i++){
            freq[i]= freq[i]+freq[i-1];
        }
        int ans[] =new int[a.length];
        for(int i=a.length-1;i>=0;i--){
            int p=freq[a[i]];
            if(p>0){
                ans[p-1]= a[i];
                freq[a[i]]--;
            }
        }
        print(ans);
    }
    public static int partition(int a[],int st,int end){
        int pi=0;int count=0;
        for(int i=st+1;i<=end;i++){
            if(a[i]<=a[st]) count++;
        }
        pi= st+count;
        swap(a,st,pi);
        int i=st;int j=end;
        while(i<pi&&j>pi){
            if(a[i]>a[pi]&&a[j]<a[pi]) {
                swap(a,i,j);
                i++;j--;
            } else {
                if (a[i] < a[pi]) i++;
                if (a[j] > a[pi]) j--;
            }
        }
        return pi;
    }
    public static void Quick_sort(int a[],int st,int end){
        if(st>=end) return;
        int pi= partition(a,st,end);
        Quick_sort(a,st,pi-1);
        Quick_sort(a,pi+1,end);
    }
    public static void merge(int []a,int l,int mid,int r){

        int []ans= new int [r-l];
        int n1 =mid-l+1;int n2= r-mid;int idx=0;
        int i=0;int j=mid+1;
        while(i<=mid&&j<=r){
            if(a[i]<a[j]){
                ans[idx++] =a[i++];
            }else{
                ans[idx++] =a[j++];
            }
        }
        while(i<=mid){
            ans[idx++] =a[i++];
        }
        while(j<=r){
            ans[idx++] =a[j++];
        }
        idx=0;
        for(int k=l;k<=r;k++){
            a[i]= ans[idx];
        }
    }
    public static void merge_sort(int a[],int l,int r){
        if(l==r) return;
        int mid= (l+r)/2;
        merge_sort(a,l,mid);
        merge_sort(a,mid+1,r);
        merge(a,l,mid,r);

    }
    public static void bubble_sort(int a[]){
        int n =a.length;

        for(int i=0;i<n-1;i++){
            boolean flag= true;
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    flag =false;
                    int temp= a[j];
                    a[j] =a[j+1];
                    a[j+1] =temp;
                }
            }
            if(flag) return;
        }
    }
    public static void selectionsort(int a[]){

        int n= a.length;
        for(int i=0;i<n-1;i++){
            int min= Integer.MAX_VALUE;
            int idx= 0;
            for(int j=i;j<n;j++){
                if(a[j]<min){
                    min= a[j];
                    idx= j;
                }
            }
            int temp =a[i];
            a[i]=a[idx];
            a[idx]= temp;

        }
    }
    public static void insertion_sort(int a[]){
        int n= a.length;
        for(int i=0;i<a.length;i++){
            int j=i;
            while(j>0&&a[j]<a[j-1]){
                    int temp= a[j];
                    a[j]= a[j-1];
                    a[j-1] =temp;
                    j--;
            }
        }
    }
    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int a[]= {4,3,1,5,3,1,3,5};
//        bubble_sort(a);
//        selectionsort(a);
//        insertion_sort(a);
//        merge_sort(a,0,a.length-1);

//        print(a);
//        Quick_sort(a,0,a.length-1);
        print(a);
        count_sort(a);

    }
}