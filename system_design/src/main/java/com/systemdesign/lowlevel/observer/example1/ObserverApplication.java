package com.systemdesign.lowlevel.observer.example1;

public class ObserverApplication {

    public static void main(String[] args) {

        // news agency is the publisher
        NewsAgency newsAgency = new NewsAgency();

        // channels are the subscribers
        Channel24 channel24 = new Channel24();
        Channel71 channel71 = new Channel71();


        // add channels to news agency
        newsAgency.subscribe(channel24);
        newsAgency.subscribe(channel71);


        // update the news
        newsAgency.uploadNews("New news");
        newsAgency.uploadNews("Breaking news" );
        newsAgency.uploadNews("Breaking news : Sheikh hasina flew to India" );


        //subscribers get the news
        System.out.println(channel24.getNews());
        System.out.println(channel71.getNews());

    }

}
