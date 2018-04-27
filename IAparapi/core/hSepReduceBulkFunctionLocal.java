package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/10/6.
 */
public class hSepReduceBulkFunctionLocal extends Kernel {


	HJavaBean  thisOut;
	HJavaBean  thisIn;

	public void run() {
		int gid = getGlobalId();
		reduceGPUBulk(thisOut, thisIn);
	}

	//public abstract Object map(Object p);
	public void reduceGPUBulk(HJavaBean out, HJavaBean in)
	{
		return ;
	};


	public void reduceCPUBulk(HJavaBean out, HJavaBean in)
	{
		return ;
	};

}
