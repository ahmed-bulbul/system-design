package com.systemdesign.lowlevel.observer.example1;

public class Channel24 implements Channel{

    private String news;

    @Override
    public void notifyAllSubscriber(Object news) {
        this.setNews((String)news);
    }

    public String getNews() {
        System.out.println("Channel 24: ");
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    

}
