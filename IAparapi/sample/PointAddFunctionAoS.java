package com.amd.aparapi.sample;

import com.amd.aparapi.core.FieldAnn;
import com.amd.aparapi.core.HJavaBean;
import com.amd.aparapi.core.hUniMapFunctionLocal;

/**
 * Created by cc on 2017/11/3.
 */
public class PointAddFunctionAoS extends hUniMapFunctionLocal{
	TestHJavaBean[] thisIn;
	TestHJavaBean[] thisOut;

	//TestHJavaBean[] broadcast_$local$ = new TestHJavaBean[10];
	public TestHJavaBean map(TestHJavaBean in) {
		TestHJavaBean out= new TestHJavaBean();
		out.x = in.x+3;
		out.y = in.y+3;

		return out;
	}

	public static final class TestHJavaBean extends HJavaBean
	{
		@FieldAnn(order = 0, array = false)
		public int x;

		@FieldAnn (order = 1 , array = false)
		public int y;
	}
}
