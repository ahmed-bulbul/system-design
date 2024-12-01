package com.youtube.systemdesign.observer;

public class JamunaTv implements Channel {

    private String news;

    @Override
    public void notifyAllSubscriber(Object o) {
        setNews((String)o);
    }

    public String getNews() {
        System.out.print("From Jamuna TV : ");
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }


}
