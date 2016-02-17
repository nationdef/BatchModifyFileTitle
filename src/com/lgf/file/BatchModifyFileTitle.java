package com.lgf.file;

import java.io.File;

public class BatchModifyFileTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFile("D://file/");
		
	}

	
	private static void getFile(String path){
		File file = new File(path);
		File[] fileArray =  file.listFiles();
		for(int i=0; i<fileArray.length; i++){
			if(fileArray[i].isFile()){
				
				String fileName = fileArray[i].getName();
				System.out.println(fileName);
				String newFileNameStr = newFileName(fileName);
				fileArray[i].renameTo(new File(path+newFileNameStr));
			}
		}
	}
	
	/**
	 * 新名字
	 * @param name
	 * @return
	 */
	private static String newFileName(String name){
		String newFileName = "";
		
		
		//后缀名
		String suffixName = name.substring(name.lastIndexOf("."), name.length());
		//前缀名
		String prefixNmae =  name.substring(name.indexOf("_")+1, name.indexOf("{"));
		newFileName = prefixNmae+suffixName;
		System.out.println(newFileName);
		return newFileName;
	}
}