public class PascalTriangle {
    public static void main(String[] args) {
        /*
            output 10 level result:
            1
            1 1
            1 2 1
            1 3 3 1
            1 4 6 4 1
            ...
         */
        int level = 10;
        int arr[][] = new int[level][];

        for (int i = 0;i < arr.length;i++) {
            arr[i] = new int[i + 1];

            for (int j = 0;j < arr[i].length;j++){
                if (j == 0 || j == arr[i].length - 1){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        // output
        for (int i = 0;i < arr.length;i++) {
            for (int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
