package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/10/6.
 */
public class hUniReduceBulkFunctionLocal extends Kernel {

	HJavaBean  thisOut;
	HJavaBean  thisIn;

	public void run() {
		int gid = getGlobalId();
		//thisOut[gid] = (OUT)thisFunction.map(thisIn[gid]);
		//thisFunction.map(thisIn[gid]);
		reduceBulk(thisOut, thisIn, gid);
	}

	//public abstract Object map(Object p);
	public void reduceBulk(HJavaBean out, HJavaBean in, int gid)
	{
		return ;
	};
}
