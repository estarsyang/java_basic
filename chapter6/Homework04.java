public class Homework04 {
    public static void main(String[] args) {
        /*
        a sort int array, when you add an int into this array, keep this array sort. For example,
        10, 12, 45, 90. add 23 and then output is 10,12,23,45,90
         */
        // find the insertIndex by comparing each item in this array.
        // copy item of arr into newArr(method 1)
        // if index < insertIndex, arr[i] is assigned to newArr[i]
        // if index == insertIndex, insertNum is assigned to newArr[i]
        // if index > newArr[i], arr[i -1] is assigned to newArr[i];

        int[] arr = {10,12,45,90};
        int[] newArr = new int[arr.length + 1];
        int insertNum = 23;
        int insertIndex = 0;

        for (int i = 0;i < arr.length;i++){

            if (arr[i] >= insertNum) {
                insertIndex = i;
                break;
            }
        }
        /*
        // method 1
        for (int j = 0; j < newArr.length;j++) {
            if (j < insertIndex) {
                newArr[j] = arr[j];
            } else if (j == insertIndex) {
                newArr[j] = insertNum;
            } else {
                newArr[j] = arr[j - 1];
            }
        }
        */

        // copy item of arr into newArr by using ignore(method 2)
        // define i(index in newArr), j(index in arr).
        // if i is not equal to insertIndex, i and j add 1, and arr[j] is assigned to newArr[i]
        // if i is equal to insertIndex, insertNum is assigned to newArr[i], i++, j ignore.



        // method 2, ignore method
        for (int i = 0, j = 0; i < newArr.length; i++){
            if (i != insertIndex) {
                newArr[i] = arr[j];
                j++;
            } else {
                newArr[i] = insertNum;
            }
        }


        // output
        for (int i = 0;i < newArr.length;i++){
            System.out.print(newArr[i] +"\t");
        }
    }
}
