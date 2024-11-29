package com.systemdesign.lowlevel.observer.example1;

public class Channel24 implements Channel{

    private String news;

    @Override
    public void notifyAllSubscriber(Object news) {
        this.setNews("From Channel 24 : "+(String)news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    

}
