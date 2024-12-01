package com.youtube.systemdesign.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    private String news;
    List<Channel> channels = new ArrayList<>();

    public void subscribe(Channel channel){
        this.channels.add(channel);
    } 
    
    public void unsubscribe(Channel channel){
        this.channels.remove(channel);
    }

    public void uploadNews(String news){
        this.news = news;
        for(Channel channel : this.channels){
            channel.notifyAllSubscriber(news);
        }

    }




}
