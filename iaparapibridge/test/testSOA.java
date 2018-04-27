package iaparapibridge.test;

import iaparapi.Kernel;
import iaparapi.Range;

/**
 * Created by cc on 2017/11/6.
 */
public class testSOA {

	public static class PointAddKernel extends Kernel
	{
		final int size = 512;
		final PointSOA a = new PointSOA();
		final PointSOA b = new PointSOA();
		final PointSOA c = new PointSOA();

		public void run() {
			int gid = getGlobalId();

			c.x[gid] = a.x[gid] + b.x[gid];
			c.y[gid] = a.y[gid] + b.y[gid];
		}
	}

	public static final class  PointSOA{

		public int[] x = new int[512];
		public int[] y = new int[512];
	}

	public static void main(String[] _args)
	{
		Range range = Range.create(512);

		PointAddKernel kernel = new PointAddKernel();
		kernel.execute(range);

		kernel.dispose();
	}
}
