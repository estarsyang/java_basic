public class Homework04 {
    public static void main(String[] args) {
        /**
         * output following result by using one line.
         * name age score level hobby
         * jack 20 80.9 A play basketball
         */

        String name = "jack";
        int age = 20;
        double score = 80.9;
        char level = 'A';
        String hobby = "play basketball";

        System.out.println("name\tage\tscore\tlevel\thobby\n" +
                name + "\t" + age + "\t" + score+ "\t" + level + "\t" + hobby);
    }
}
