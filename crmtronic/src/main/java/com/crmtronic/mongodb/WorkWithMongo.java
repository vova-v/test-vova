package com.crmtronic.mongodb;


import java.awt.List;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class WorkWithMongo {
	
	MongoClient mongoClient = new MongoClient( "crmtronic-staging.cloudapp.net" , 27017 );
	private DB db = mongoClient.getDB("crmtronic_ui");
	private DBCollection table;
	private DBCollection table2;
	
	public Object getCategoryName(){
		DBCollection listCategory = db.getCollection("categories");
		BasicDBObject query = new BasicDBObject();
		query.put("ownerId", getOwnerId());
		//for(DBObject test:listCategory.find(query)){
			
		//}
		return listCategory.findOne(query).get("name");
	}
	
	public Object getCategory(){
		DBCollection listCategory = db.getCollection("categories");
		BasicDBObject query = new BasicDBObject();
		query.put("ownerId", getOwnerId());
		//for(DBObject test:listCategory.find(query)){
			
		//}
		return listCategory.findOne(query).get("category");
	}
	
	public Object getCategoryForDelete(){
		Object rezult = null;
		DBCollection listCategory = db.getCollection("categories");
		BasicDBObject query = new BasicDBObject();
		query.put("ownerId", getOwnerId());
		DBCursor categoryName = listCategory.find(query);
		while (categoryName.hasNext()) { 
			DBObject object = categoryName.next();
			if(object.get("name").toString().contains("AvtoTestCategories")){
				BasicDBObject query2 = new BasicDBObject();
				query.put("name", object.get("name"));
				
				rezult = listCategory.findOne(query).get("category");
				break;
			}
         }
		return rezult;
	}
	
	public Object getOwnerId(){
		DBCollection listCategory = db.getCollection("users");
		BasicDBObject query = new BasicDBObject();
		query.put("info.subdomain", "staging");
		//for(DBObject test:listCategory.find(query)){
			
		//}
		return listCategory.findOne(query).get("ownerId");
	}

	 public void printCollections() {
	        for (String coll : db.getCollectionNames()) {
	            System.out.println(coll);
	        }
	 }
	
	
	public void getDBS(){
		/*
		db = mongoClient.getDB("crmtronic_ui");
		
		table = db.getCollection("users");
		
		Set<String> colls = db.getCollectionNames();
		for (String s : colls) {
		    //System.out.println(s);
		}
		
		DBObject myDoc = table.findOne();
		System.out.println(myDoc);
		
		DBCursor cur = table.find();
		while(cur.hasNext()) {
		    //System.out.println(cur.next());
		}
		
		BasicDBObject query = new BasicDBObject();
		query.put("ownerId", "BJTGK9LxC56WupiXT");
		cur = table.find(query);
		while(cur.hasNext()) {
		    System.out.println(cur.getCursorId());
		}
		
		
		table2 = db.getCollection("categories");
		BasicDBObject query1 = new BasicDBObject();
		query1.put("ownerId", "nvQJFMuPPo9HFzquC");
		DBObject tt = table2.findOne(query1);
		Object ttt = table2.findOne(query1).get("category");
		System.out.println(tt);
		System.out.println(ttt);
		*/
		System.out.println(getCategoryName());
		printCollections();
	}
	
}
