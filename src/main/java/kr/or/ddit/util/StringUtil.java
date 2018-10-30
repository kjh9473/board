package kr.or.ddit.util;


public class StringUtil {
	//
	
	/**
	* Method : getFileNameFromHeader
	* 작성자 : pc25
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 filename을 추출
	*/
	public static String getFileNameFromHeader(String contentDisposition){
		String[] array = contentDisposition.split("; ");
		String fileName = "";
		
		for(String str : array) {
			if(str.indexOf("filename=")>=0){
				System.out.println(str.substring(10,str.lastIndexOf("\"")));
				fileName = str.substring(10,str.lastIndexOf("\""));
			}
		}
		
		return fileName;
	}
	


	public static String getCookie(String cookieString, String string) {
//		String cookieString = "remember=Y; userId=brown; etc=test";
		String[] array = cookieString.split("; ");
		String cookieValue = "";

		for(String str : array){
			if(str.indexOf(string)>=0){
				cookieValue = str.substring(str.indexOf("=")+1);
			}
		}
		
		return cookieValue;
	}}
