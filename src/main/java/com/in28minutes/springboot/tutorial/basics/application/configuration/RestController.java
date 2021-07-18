package com.in28minutes.springboot.tutorial.basics.application.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	DataSourceService dataSourceService;
	
	@RequestMapping("/getData")
	public ArrayList<WatchParty> getData(){
		ArrayList<WatchParty> data = dataSourceService.getBaseData();
		  for(WatchParty wpd : data){
			  wpd.setLiveVideoUrl(dataSourceService.loadFinalUrl(wpd.getChannelUrl()));
		  }
		return data;
	}
}
