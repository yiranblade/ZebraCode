package com.creatshare.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.creatshare.dao.userDao;
import com.creatshare.model.user;
import com.creatshare.util.CollectionGenerator;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryOperators;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * @author 作者:yiranblade E-mail:
 * @date 创建时间：2016年5月22日 下午6:19:21
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
@Repository
public class userDaoimpl implements userDao {

    private MongoCollection<Document> collection;

    public boolean Adduser(user user) {
        // TODO Auto-generated method stub

        if (user != null) {
            collection = CollectionGenerator.getCollection();
            Document document = new Document("ID", user.getCookieid()).append("content", user.getContent());
            System.out.println(user.getCookieid() + user.getContent());
            collection.insertOne(document);
            System.out.println("Hello world!");
            CollectionGenerator.CloseMongoClient();
            return true;
        } else {
            return false;
        }

    }

    public boolean Deleteuser(user user) {
        // TODO Auto-generated method stub
        if (user != null) {
            collection = CollectionGenerator.getCollection();
            DeleteResult result=collection.deleteOne(Filters.eq("_id", new ObjectId(user.getId())));// 删除对应的user
            CollectionGenerator.CloseMongoClient();
            if(result.getDeletedCount()==1){
            return true;}
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean Updateuser(user user) {
        // TODO Auto-generated method stub
        if (user != null) {
            collection = CollectionGenerator.getCollection();
            UpdateResult result=collection.updateOne(Filters.eq("_id", new ObjectId(user.getId())),
                    new Document("$set", new Document("content", user.getContent())));
            CollectionGenerator.CloseMongoClient();
            if(result.getMatchedCount()==1){
                return true;
            }else{
            return false;
            }
        } else {
            return false;
        }
    }

    public List<user> valitecoding(String checking) {
        // TODO Auto-generated method stub
        if (checking != null) {
            collection = CollectionGenerator.getCollection();
            BasicDBObject queryObject = new BasicDBObject().append(QueryOperators.OR,
                    new BasicDBObject[] {new BasicDBObject("ID", checking) });
            FindIterable<Document> find = collection.find(queryObject);
            List<user> user = new ArrayList<user>();
            MongoCursor<Document> mongoCursor = find.iterator();

            while (mongoCursor.hasNext()) {
                user use = new user();
                Document document = new Document();
                document = mongoCursor.next();
                use.setContent(document.getString("content"));
                use.setId(document.getObjectId("_id").toString());
                use.setCookieid(document.getString("ID"));
                user.add(use);

            }
            CollectionGenerator.CloseMongoClient();
            System.out.println("this is a returbn");
            return user;
                

        }
        return null;
    }

}
