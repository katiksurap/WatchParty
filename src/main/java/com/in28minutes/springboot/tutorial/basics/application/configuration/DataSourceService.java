package com.in28minutes.springboot.tutorial.basics.application.configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DataSourceService {
	
	org.slf4j.Logger LOG = LoggerFactory.getLogger(DataSourceService.class);
	
	public ArrayList<WatchParty> getBaseData() {

        try {
            // TODO: handle loggedInUser authentication
            ArrayList<WatchParty> lst = new ArrayList<>();
            WatchParty channelData = new WatchParty();
            channelData.setUserName("KatikPlays");
            channelData.setChannelUrl("https://www.youtube.com/channel/UCznI5JXUuznaGJkPTpnIORQ");
            channelData.setLive(false);
            lst.add(channelData);
            channelData = new WatchParty();
            channelData.setUserName("Meezan");
            channelData.setChannelUrl("https://www.youtube.com/channel/UC0Q6YKuLIXoqGddAFmBa7LA");
            channelData.setLive(false);
            lst.add(channelData);
            channelData = new WatchParty();
            channelData.setUserName("SNV");
            channelData.setChannelUrl("https://www.youtube.com/channel/UC94CIqiCFHzx-2btEbbOy_w");
            channelData.setLive(false);
            lst.add(channelData);
            channelData = new WatchParty();
            channelData.setUserName("SriCharan98");
            channelData.setChannelUrl("https://www.youtube.com/channel/UCPL7PoiG4HPg5dZmXan0NQg");
            channelData.setLive(false);
            lst.add(channelData);
            channelData = new WatchParty();
            channelData.setUserName("Akhee");channelData.setChannelUrl("https://www.youtube.com/channel/UCexhllz5mKg8zQxchITVg6w");
            channelData.setLive(false);
            lst.add(channelData);
            channelData = new WatchParty();
            channelData.setUserName("Joy");
            channelData.setChannelUrl("https://www.youtube.com/channel/UCUcVU2gNVPsVxX_Ihkmueaw");
            channelData.setLive(false);
            lst.add(channelData);
            return lst;
        } catch (Exception e) {
            return null;
        }
    }
	
	public String loadFinalUrl(String urlToLoad) {
        String dataUrl = null;
        try {
            URL oracle = new URL(urlToLoad);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
                //"https://i.ytimg.com/vi/Ac993M2VimM/hqdefault_live
            StringBuilder inputLine = new StringBuilder();
            String inputLines;

            while ((inputLines = in.readLine()) != null) {
                inputLine.append(inputLines);
            }
            //Log.i("finaldata",inputLine.toString());
            if (inputLine.toString().contains("default_live")) {
            	//LOG.info("Yes", "default_live");
                int iend = inputLine.toString().indexOf("default_live"); //this finds the first occurrence of "."
                String subString = "";
                if (iend != -1) {
                    subString = inputLine.toString().substring(0, iend); //this will give abc
                }
                String start = subString.substring(subString.length() - 20);
                if (start.contains("vi")) {
                //	LOG.info("Yes final", dataUrl);
                    dataUrl = start.split("vi/")[1].replaceAll("/hq", "");
                  //  Log.i("Yes final", dataUrl);
                }
            } else {
            	LOG.info("No", urlToLoad +" default_live");
            }
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataUrl;
    }

}
