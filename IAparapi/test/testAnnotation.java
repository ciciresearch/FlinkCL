package com.amd.aparapi.test;

import com.amd.aparapi.core.FieldAnn;
import com.amd.aparapi.core.HJavaBean;
import java.lang.reflect.Field;
import java.lang.annotation.*;
/**
 * Created by cc on 2017/11/3.
 */
public class testAnnotation
{
	public static void main(String[] _args)
	{
		TestAnnBean ta = new TestAnnBean();
		Field[] fields= ta.getClass().getDeclaredFields();
		Annotation[] annotations2 = ta.getClass().getAnnotations();

        for(int i = 0; i<fields.length; i++)
		{
			Annotation[] annotations = fields[i].getDeclaredAnnotations();
			if(annotations != null)
			{
				for(int j =0; j<annotations.length; j++)
				{
					int iOrder = ((FieldAnn) annotations[j]).order();
					boolean bArray = ((FieldAnn) annotations[j]).array();
					int length = ((FieldAnn) annotations[j]).length();

					System.out.println("order:" + iOrder);
					System.out.println("array:" + bArray);
					System.out.println("length:" + length);
				}
			}
		}
	}


	public static class TestAnnBean extends HJavaBean
	{
		@FieldAnn(order = 0, array = true , length = 1000)
		public  int x[];

		@FieldAnn (order = 1 , array = true , length = 1000)
		public int y[];
	}
}
