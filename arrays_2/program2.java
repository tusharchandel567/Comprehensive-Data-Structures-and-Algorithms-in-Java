//Program to find the smallest and largest number in an arry 
public class program2 {
    public static void main(String[] args){
        int [] arr = {2,3,4,5,6,7,8,9};
        int small,large;
        small = large = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<small)
                small = arr[i];
            if(arr[i]>large)
                small = arr[i];
        }
        System.out.println("smallest = "+small+"-largest"+ large);
    }
}
