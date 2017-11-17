package healthcares.spring.myapp;
import java.util.*;
public class Utility
{
	public static String filter(String input)
	{
		StringBuffer temp = new StringBuffer();
		char c;
		// ตรวจสอบข้อมูลจากอินพุตทีละตัวอักษร
		for(int i=0; i<input.length(); i++)
		{
			c=input.charAt(i);
			if(c=='<') temp.append("&lt;");
			else if (c=='>') temp.append("&gt;");
			else if (c=='\'') temp.append("&#039;");
			else if (c=='"') temp.append("&quot;");
			else if (c=='&') temp.append("&amp;");
			else if (c=='\\') temp.append("&#92;");
			else temp.append(c);
		}
		return (temp.toString());
	}
	public static String newline(String input)
	{
		StringBuffer temp = new StringBuffer();
		// ตัดสตริงตามที่พบรหัส \n แล้วนำมาเก็บไว้ในอ็อบเจ็กต์ st
		StringTokenizer st = new StringTokenizer(input,"\n");
		// นำสตริงแต่ละโทเคนมาต่อด้วยแท็ก <br> แล้วเก็บในอ็อบเจ็กต์ temp
		while(st.hasMoreTokens()) 
			temp.append(st.nextToken()+"<br>");
		return (temp.toString());
	}
}


		
