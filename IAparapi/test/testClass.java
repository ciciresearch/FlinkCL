package com.amd.aparapi.test;

/**
 * Created by cc on 2017/11/5.
 */
import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;


public class testClass {

	public static class PointAddKernel extends Kernel
	{
		final int size = 512;
		final Point[] a = new Point[size];
		final Point[] b = new Point[size];
		final Point[] c = new Point[size];

		public void run() {
			int gid = getGlobalId();

			c[gid].x = a[gid].x + b[gid].x;
			c[gid].y = a[gid].y + b[gid].y;
		}
	}

	public static final class  Point{
		int x;
		int y;
	}

	public static void main(String[] _args)
	{
		Range range = Range.create(512);

		PointAddKernel kernel = new PointAddKernel();
		kernel.execute(range);

		kernel.dispose();
	}
}

