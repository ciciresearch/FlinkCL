package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/10/10.
 */
public class hSepMapFunctionLocal extends Kernel {
	HJavaBean[] thisOut;
	HJavaBean[] thisIn;
	;

	public void run() {
		int gid = getGlobalId();

		thisOut[gid] = mapGPU(thisIn[gid]);
	}

	//public abstract Object map(Object p);
	public HJavaBean  mapGPU(HJavaBean in)
	{
		return new HJavaBean();
	};

	public HJavaBean  mapCPU(HJavaBean in)
	{
		return new HJavaBean();
	};

}
