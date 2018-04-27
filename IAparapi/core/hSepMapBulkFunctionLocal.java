package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/10/10.
 */
public class hSepMapBulkFunctionLocal extends Kernel {

	HJavaBean  thisOut;
	HJavaBean  thisIn;

	public void run() {
		int gid = getGlobalId();
		mapGPUBulk(thisOut, thisIn);
	}

	//public abstract Object map(Object p);
	public void mapGPUBulk(HJavaBean out, HJavaBean in)
	{
		return ;
	};


	public void mapCPUBulk(HJavaBean out, HJavaBean in)
	{
		return ;
	};
}
