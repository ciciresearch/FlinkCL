package com.amd.aparapi.sample;

import com.amd.aparapi.core.HJavaBean;
import com.amd.aparapi.core.hUniMapBulkFunctionLocal;
import com.amd.aparapi.core.FieldAnn;

/**
 * Created by cc on 2018/1/1.
 */
public class PointAddFunctionSoA extends hUniMapBulkFunctionLocal{

	TestHJavaBean[] thisIn;
	TestHJavaBean[] thisOut;

	//TestHJavaBean[] broadcast_$local$ = new TestHJavaBean[10];
	public void mapBulk(TestHJavaBean[] in, TestHJavaBean[] out, int gid) {

		//int gid = getGlobalId();
		//out[0].x[gid] = 5;
		out[0].x[gid] = in[0].x[gid]+in[0].y[gid];
		return;
	}

	public static final class TestHJavaBean extends HJavaBean
	{
		@FieldAnn (order = 0, array = true , length = 1024)
		public int x[];

		@FieldAnn (order = 1 , array = true , length = 1024)
		public int y[];
	}
}
