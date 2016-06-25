package com.creatshare.util;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class CollectionGenerator {

    private static MongoCollection<Document> collection;
    private static MongoClient mongoClient;

    public static MongoCollection<Document> getCollection() {
        try {

            // 连接到mongodb服务
            mongoClient = new MongoClient("localhost", 27017);

            // 连接数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("yiranblade");
            System.out.println("Connect to database successfully");

            // mongoDatabase.createCollection("mycol");
            collection = mongoDatabase.getCollection("mycol");
            System.out.println("集合mycol选择成功");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ":" + e.getMessage());

        }
        return collection;

    }

    public static boolean CloseMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
            return true;
        } else {
            return false;
        }
    }
}
