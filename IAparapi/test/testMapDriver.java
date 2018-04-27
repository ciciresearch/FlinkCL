package com.amd.aparapi.test;

import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;
import com.amd.aparapi.core.HJavaBean;
import com.amd.aparapi.FlinkCLbridge.hUniMapDriver;
import com.amd.aparapi.internal.kernel.AparapiBridgeCompile;

/**
 * Created by cc on 2017/11/8.
 */
public class testMapDriver {

	public static void main(String[] _args)
	{
		Range range = Range.create(512);

		TestUniMapDriver kernel = new TestUniMapDriver();
        byte[] in = new byte[512*8];
		byte[] out = new byte[512*8];
		byte[] share = new byte[512*8];

		//kernel.setFunction(new TestUniMapFunction());
		//kernel.setIn(in);
		//kernel.setOut(out);
		//kernel.execute(range);

		AparapiBridgeCompile writeCLUtils = new AparapiBridgeCompile();
		writeCLUtils.setKernel(kernel);
		String CLString = writeCLUtils.writeCL();
		System.out.println(CLString);

		kernel.dispose();


		//start transfer and execute
		TransferKernel transferKernel = new TransferKernel();
		transferKernel.setCLString(CLString);
		transferKernel.setInputBuffer(in);
		transferKernel.setOutputBuffer(out);
		transferKernel.setShareBuffer(share);
		transferKernel.execute(range);
		transferKernel.dispose();
	}

	public static final class TransferKernel extends Kernel
	{
		byte[] inBuffer;
		byte[] outBuffer;
		byte[] sharedBuffer_$local$;
		public void run() {
			int gid = getGlobalId();
			sharedBuffer_$local$[gid] = sharedBuffer_$local$[gid+1];
			outBuffer[gid] = inBuffer[gid];
		}

		public byte[] getOutputBuffer() {
			return outBuffer;
		}

		public void setOutputBuffer(byte[] _outputBuffer) {
			this.outBuffer = _outputBuffer;
		}

		public void setInputBuffer(byte[] _inputBuffer) {
			this.inBuffer = _inputBuffer;
		}

		public void setShareBuffer(byte[] _shareBuffer) {
			this.sharedBuffer_$local$ = _shareBuffer;
		}
	}

	public static final class TestUniMapDriver extends hUniMapDriver{

		final byte[] buffer_$local$ = new byte[512*8];
		TestHJavaBean[] thisIn;
		TestHJavaBean[] thisOut;
		byte[] inBuffer;
		byte[] outBuffer;

		//TestHJavaBean[] broadcast_$local$ = new TestHJavaBean[10];
		public TestHJavaBean map(TestHJavaBean in) {
			buffer_$local$[0] = 1;
			TestHJavaBean out= new TestHJavaBean();
			out.x = in.x+3;
			out.y = in.y+3;

			//broadcast_$local$[0].x = 10;
			return out;
		}
	}

	public static final class TestHJavaBean extends HJavaBean
	{
		long x;
		long y;

		public  TestHJavaBean()
		{
			return;
		}
	}
}
