//Program to reverse the elements of an array. 
 class program3 {
    public static void main(String[] args){
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int i,j,temp;
        System.out.println("the array is ");
        for(i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for(i=0,j=arr.length-1;i<j;i++,j--){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println("afer reverse the array id : ");
        for(i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
}
