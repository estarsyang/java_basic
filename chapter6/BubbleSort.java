public class BubbleSort {

    public static void main(String[] args) {
        // sort the int array  24,69,80,57,13 by using BubbleSort.

        int[] arr ={24,69,80,57,13};
        int temp = 0;

        /**
         * First sort: move max number to last index.
         * 1. 1st time compare: [24,69,80,57,13] , 24 < 69, don't swap
         * 2. 2nd time compare: [24,69,80,57,13], 69 < 80, don't swap
         * 3. 3th time compare: [24,69,80,57,13], 80 > 57, swap. [24,69,57,80,13]
         * 4. 4th time compare: [24,69,57,80,13], 80 > 13, swap. [24,69,57,13,80], after this step, max number move to
         * last index.
         *
         */

        for (int j = 0; j < 4;j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("Result after first time sort:");
        for (int j = 0; j < arr.length;j++) {
            System.out.print(arr[j] + "\t");
        }




        /**
         * Second sort: move second max number to last second  index.
         * 1. 1st time compare: [24,69,57,13,80] , 24 < 69, don't swap
         * 2. 2nd time compare: [24,69,57,13,80], 69 > 57, swap. [24,57,69,13,80]
         * 3. 3th time compare: [24,57,69,13,80], 69 > 13, swap. [24,57,13,69,80], done.
         */

        for (int j = 0; j < 3;j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("\nResult after second time sort:");
        for (int j = 0; j < arr.length;j++) {
            System.out.print(arr[j] + "\t");
        }


        /**
         * Third sort: move third max number to last three  index.
         * 1. 1st time compare: [24,57,13,69,80], 24 < 57, don't swap
         * 2. 2nd time compare: [24,57,13,69,80], 57 > 13, swap. [24,13,57,69,80]
         */

        for (int j = 0; j < 2;j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("\nResult after third time sort:");
        for (int j = 0; j < arr.length;j++) {
            System.out.print(arr[j] + "\t");
        }

        /**
         * Fourth sort: move third max number to last four  index.
         * 1. 1st time compare: [24,13,57,69,80], 24 < 13, swap. [13,24,57,69,80], done.
         */

        for (int j = 0; j < 1;j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("\nResult after fourth time sort:");
        for (int j = 0; j < arr.length;j++) {
            System.out.print(arr[j] + "\t");
        }

        System.out.println("\n===============================");

        // !importation. Since arr is sort by ascending, so we need to create a new array name arr1, the content is equal
        // to arr.

        int[] arr1 ={24,69,80,57,13};


        // Base on above code, combine and optimize it. it has 4 times, and each time has a loop. it can be know that,
        // it is a nesting loop. So,


        // the length of array is 5, and this sort also need 4 times, so i < length of array.
        int len = arr1.length;
        for (int i = 1; i < len;i++) { // i represent the sorting time

            /**
             * each time how many iteration. and length of array is 5.
             * 1st time, 4 iterations, the number of iterations is equal to length of array minus the sorting time. 4 = 5 -1.
             * 2nd time, 3 iterations, 3 = 5 - 2;
             * 3rd time, 2 iterations, 2 = 5 - 3;
             * 4th time, 1 iterations. 1 = 5 - 4;
             */
            // Since the number of iterations in this sorting time is length of array minus the sorting time
            // so, j < (length - i)
            for (int j = 0; j < (len - 1);j++) {
                if (arr1[j] > arr1[j + 1]) {
                    temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
            System.out.println("\nResult after " + i + " time sort:");
            for (int j = 0; j < arr1.length;j++) {
                System.out.print(arr1[j] + "\t");
            }
        }

    }

}
