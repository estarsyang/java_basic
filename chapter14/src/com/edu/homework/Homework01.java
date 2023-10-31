package com.edu.homework;

import java.util.ArrayList;

/**
 * 1. Create a News class, including title, content, provide set,get methods, override toString method, only print title
 * 2. Create a constructor with one parameter, when init an object, only init title, and init two objects.
 * news 1: "abcdefghijklmn"
 * news 2: "1234567890"
 * 3. Add the two news to ArrayList, and iterate the arraylist by reverse.
 * 4. When iteration, process news title that only print top 5 word, others using ... to replace
 * 5. print
 */
public class Homework01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new News("abcdefghijklmn"));
        arrayList.add(new News("1234567890"));

        // iterate
        for (int i = arrayList.size() - 1; i >= 0; i--) {
//            System.out.println(arrayList.get(i));
            News news =(News) arrayList.get(i);
            System.out.println(processTitle(news.getTitle()));
        }
    }

    public static String processTitle(String title){
        if (title == null){
            return "";
        }
        if (title.length() > 5){
            return title.substring(0,5) + "...";
        } else {
            return title;
        }
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
