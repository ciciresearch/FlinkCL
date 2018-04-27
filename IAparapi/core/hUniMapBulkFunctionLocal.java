package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/3/30.
 */
public class hUniMapBulkFunctionLocal  extends Kernel {

	HJavaBean  thisOut;
	HJavaBean  thisIn;

	public void run() {
		int gid = getGlobalId();
		//thisOut[gid] = (OUT)thisFunction.map(thisIn[gid]);
		//thisFunction.map(thisIn[gid]);
		mapBulk(thisOut, thisIn, gid);
	}

	//public abstract Object map(Object p);
	public void mapBulk(HJavaBean out, HJavaBean in, int gid)
	{
		return ;
	};

}
