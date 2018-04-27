package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/10/10.
 */
public class hSepReduceFunctionLocal extends Kernel {

	HJavaBean[] thisOut;
	HJavaBean[] thisIn;
	;

	public void run() {
		int gid = getGlobalId();

		thisOut[gid] = reduceGPU(thisIn[gid]);
	}

	//public abstract Object map(Object p);
	public HJavaBean  reduceGPU(HJavaBean in)
	{
		return new HJavaBean();
	};

	public HJavaBean  reduceCPU(HJavaBean in)
	{
		return new HJavaBean();
	};

}
