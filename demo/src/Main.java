public class Main {
    public static void main(String[] args) {

        int [] arrInt = {3,1,4,6,8,2,5};
        for (int i = 1; i < arrInt.length; i++){
            int temp = arrInt[i];
            int k;
            for(k = i - 1; k >=0 && arrInt[k] > temp; k--){
                arrInt[k+1] = arrInt[k];
            }
           arrInt[k+1] = temp;
        }
        for (int i = 0; i < arrInt.length; i++) {

            System.out.println(arrInt[i]);
        }
    }
}