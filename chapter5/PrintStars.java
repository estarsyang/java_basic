public class PrintStars {
    public static void main(String[] args) {
        /**
         * print a empty triangle
         *     *
         *    * *
         *   *   *
         *  *     *
         * *********
         */
        // 1. print a rectangle
        /**
         * *********
         * *********
         * *********
         * *********
         * *********
         */
//        for (int i = 1;i <= 5;i++) {
//            System.out.println("*********");
//        }

        // 2. print half of triangle
        /**
         * *        level 1 1 stars
         * **       level 2 2 stars
         * ***      level 3 3 stars
         * ****     level 4 4 stars
         * *****    level 5 5 stars
         */
//        // above output shows a pattern, number of stars in each level is equal to the number of layer.
//        for (int i = 1;i <= 5;i++) { // level
//            for (int j = 1;j<=i;j++) { // number of start in each level.
//                System.out.print("*");
//            }
//            System.out.println(""); // each level enter next line
//        }

        // 3. print a solid triangle
        /**
         *      *       level 1, 1 stars, 4 spaces
         *     ***      level 2, 3 stars, 3 spaces
         *    *****     level 3, 5 stars, 2 spaces
         *   *******    level 4, 7 stars, 1 spaces
         *  *********   level 5, 9 stars, 0 spaces
         */
        /* above output shows a pattern, number of stars in each level is
        equal to the number of layer times 2 and then minus 1. stars = level * 2 -1;
        and the number of spaces is equal to the total level minus level, like spaces = totalLevel - level.
         */
//        for (int i = 1; i<= 5;i++){
//
//            // print spaces
//            for (int k = 1; k <= 5 - i;k++) {
//                System.out.print(" ");
//            }
//
//            // print stars
//            for (int j = 1; j <= 2*i - 1;j++) {
//                System.out.print("*");
//            }
//            System.out.println("");
//        }

        // 4. print empty triangle
        /**
         *      *       level 1, 1 stars, 4 spaces, the first star and the last star.
         *     * *      level 2, 2 stars, 3 spaces, the first star and the last star.
         *    *   *     level 3, 2 stars, 2 spaces, the first star and the last star.
         *   *     *    level 4, 2 stars, 1 spaces, the first star and the last star.
         *  *********   level 5, 9 stars, 0 spaces, all stars.
         */

        int totalLevel = 3;
        for (int i = 1; i<= totalLevel;i++){

            // print spaces
            for (int k = 1; k <= totalLevel - i;k++) {
                System.out.print(" ");
            }

            // print stars
            for (int j = 1; j <= 2 * i - 1;j++) {
                if (j == 1 || j == 2 * i -1 || i == totalLevel) { // first star, last star and final level.
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }

    }
}
