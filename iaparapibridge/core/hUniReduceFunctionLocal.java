package iaparapibridge.core;

import iaparapi.Kernel;

/**
 * Created by cc on 2017/10/30.
 */
public class hUniReduceFunctionLocal extends Kernel {

	HJavaBean[] thisOut;
	HJavaBean[] thisIn;

	public void run() {
		int gid = getGlobalId();

		thisOut[gid] = reduce(thisIn[gid]);
	}

	//public abstract Object map(Object p);
	public HJavaBean  reduce(HJavaBean in)
	{
		return new HJavaBean();
	};

}
