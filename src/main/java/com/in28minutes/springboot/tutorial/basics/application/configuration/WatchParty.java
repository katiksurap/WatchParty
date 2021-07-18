package com.in28minutes.springboot.tutorial.basics.application.configuration;

import java.io.Serializable;

public class WatchParty implements Serializable {

	    private String userName;
	    private String channelUrl;
	    private boolean isLive;
	    private String liveVideoUrl;

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getChannelUrl() {
	        return channelUrl;
	    }

	    public void setChannelUrl(String channelUrl) {
	        this.channelUrl = channelUrl;
	    }

	    public boolean isLive() {
	        return isLive;
	    }

	    public void setLive(boolean live) {
	        isLive = live;
	    }

	    public String getLiveVideoUrl() {
	        return liveVideoUrl;
	    }

	    public void setLiveVideoUrl(String liveVideoUrl) {
	        this.liveVideoUrl = liveVideoUrl;
	    }
}