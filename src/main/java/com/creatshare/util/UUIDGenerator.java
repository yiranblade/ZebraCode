package com.creatshare.util;
import java.util.UUID;
/*
 * 生成数据库唯一标识ID，采用UUID
 */
public class UUIDGenerator {
	
	
	public static String getUUID(){
		String s=UUID.randomUUID().toString();
		return s.substring(0, 8)+s.substring(9,13)+s.substring(14, 18)+s.substring(19, 23)+s.substring(24);
	}
	public static String[] getUUID(int number){	//生成指定数目的UUID
		if(number<1){
			return null;
		}
		String[] ss=new String[number];
		for(int i=0;i<number;i++){
			ss[i]=getUUID();
		}
		return ss;
	}
	

}