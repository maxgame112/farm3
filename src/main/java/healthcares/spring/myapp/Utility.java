package healthcares.spring.myapp;
import java.util.*;
public class Utility
{
	public static String filter(String input)
	{
		StringBuffer temp = new StringBuffer();
		char c;
		// ��Ǩ�ͺ�����Ũҡ�Թ�ص���е���ѡ��
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
		// �Ѵʵ�ԧ�����辺���� \n ���ǹ�����������ͺ�硵� st
		StringTokenizer st = new StringTokenizer(input,"\n");
		// ��ʵ�ԧ�����ह�ҵ�ʹ����� <br> ���������ͺ�硵� temp
		while(st.hasMoreTokens()) 
			temp.append(st.nextToken()+"<br>");
		return (temp.toString());
	}
}


		
