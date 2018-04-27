package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;

public abstract class hUniMapFunctionLocal extends Kernel{
	HJavaBean[] thisOut;
	HJavaBean[] thisIn;

	//Byte[] thisInBuffer;
	//Byte[] thisOutBuffer;

	public void run() {
		int gid = getGlobalId();
		//thisOut[gid] = (OUT)thisFunction.map(thisIn[gid]);
		//thisFunction.map(thisIn[gid]);

		thisOut[gid] = map(thisIn[gid]);
	}

	//public abstract Object map(Object p);
	public HJavaBean  map(HJavaBean in)
	{
		return new HJavaBean();
	};
}
