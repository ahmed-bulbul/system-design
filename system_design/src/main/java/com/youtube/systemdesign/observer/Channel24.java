package com.youtube.systemdesign.observer;

public class Channel24 implements Channel{

    private String news;

    @Override
    public void notifyAllSubscriber(Object o) {
        setNews((String)o);
    }

    public String getNews() {
        System.out.print("From Channel 24 : ");
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    

}
