package com.youfan.search.base;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.youfan.utils.ReadProperties;

import java.util.ArrayList;
import java.util.List;

public class BaseMongo {
    protected static MongoClient mongoClient ;
		
		static {
			List<ServerAddress> addresses = new ArrayList<ServerAddress>();
			String[] addressList = ReadProperties.getKey("mongoaddr","youfansearch.properties").split(",");
			String[] portList = ReadProperties.getKey("mongoport","youfansearch.properties").split(",");
			for (int i = 0; i < addressList.length; i++) {
				ServerAddress address = new ServerAddress(addressList[i], Integer.parseInt(portList[i]));
				addresses.add(address);
				
			}
			mongoClient = new MongoClient(addresses);
		}
	
}
