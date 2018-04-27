package iaparapibridge.FlinkCLbridge;

import iaparapi.Kernel;
import iaparapibridge.core.HJavaBean;

/**
 * Created by cc on 2017/3/8.
 */
public abstract class hUniMapDriver extends Kernel{

	HJavaBean[] thisIn;
	HJavaBean[] thisOut;

	Byte[] thisInBuffer;
	Byte[] thisOutBuffer;



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
