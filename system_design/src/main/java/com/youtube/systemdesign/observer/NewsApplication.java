package com.youtube.systemdesign.observer;

public class NewsApplication {

    public static void main(String[] args) {

        // publisher 
        NewsAgency newsAgency = new NewsAgency();


        // subscriber 
        Channel24 channel24 = new Channel24();
        JamunaTv jamunaTv = new JamunaTv();

        // subcribed to news agency 
        newsAgency.subscribe(channel24);
        newsAgency.subscribe(jamunaTv);

        //unsubscribe jamuna 
      //  newsAgency.unsubscribe(jamunaTv);

        //publish news
        newsAgency.uploadNews("Bangladesh won th series in 3-0");
        newsAgency.uploadNews("Another news");

        // Get the nes
        System.out.println(channel24.getNews());
        System.out.println(jamunaTv.getNews());

        
    }

}
