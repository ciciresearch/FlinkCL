package iaparapibridge.sample;

import iaparapi.Range;
import iaparapi.internal.kernel.AparapiBridgeCompile;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import iaparapibridge.core.TransferFunction;
/**
 * Created by cc on 2017/10/30.
 */
public class PointAddLocal {


	public static void main(String[] _args)
	{
		//pointAddSoAGPU();

		pointAddAoSGPU();
	}

	public static void pointAddSoAGPU()
	{
		Range range = Range.create(1024);
		ByteBuffer inAllBuffer = ByteBuffer.allocate(1024*4*2);
		ByteBuffer inXBuffer = ByteBuffer.allocate(1024*4);
		ByteBuffer inYBuffer = ByteBuffer.allocate(1024*4);
		ByteBuffer outBuffer = ByteBuffer.allocate(1024*4);

		for(int i = 0; i < 1024; i++)
		{
			inXBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(i*4, i);
			inYBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(i*4, i);
			outBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(i*4,0);
		}

		inAllBuffer.put(inXBuffer.array(), 0, 1024*4);
		inAllBuffer.put(inYBuffer.array(), 0, 1024*4);

		PointAddFunctionSoA kernel = new PointAddFunctionSoA();
		//start to compile
		AparapiBridgeCompile writeCLUtils = new AparapiBridgeCompile();
		writeCLUtils.setKernel(kernel);

		//	setKernel(kernel);
		String CLString = writeCLUtils.writeCL();
		System.out.println(CLString);

		kernel.dispose();

		//start to transfer and execute
		TransferFunction transferKernel = new TransferFunction();
		transferKernel.setCLString(CLString);
		transferKernel.setInputBuffer(inAllBuffer.array());
		transferKernel.setOutputBuffer(outBuffer.array());
		transferKernel.execute(range);

		for(int i = 0; i < 1024; i++)
		{
			//System.out.println(inAllBuffer.order(ByteOrder.LITTLE_ENDIAN).getInt(i*4));
			System.out.println(outBuffer.order(ByteOrder.LITTLE_ENDIAN).getInt(i*4));
		}
		transferKernel.dispose();

		return;
	}

	public static void pointAddAoSGPU()
	{
		Range range = Range.create(1024);
		ByteBuffer inAllBuffer = ByteBuffer.allocate(1024*4*2);
		ByteBuffer outBuffer = ByteBuffer.allocate(1024*4);

		for(int i = 0; i < 1024; i++)
		{
			inAllBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(i*4, i);
			inAllBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt((i+1)*4, i);
			outBuffer.order(ByteOrder.LITTLE_ENDIAN).putInt(i*4,0);
		}

		PointAddFunctionAoS kernel = new PointAddFunctionAoS();
		//start to compile
		AparapiBridgeCompile writeCLUtils = new AparapiBridgeCompile();
		writeCLUtils.setKernel(kernel);

		//setKernel(kernel);
		String CLString = writeCLUtils.writeCL();
		System.out.println(CLString);

		kernel.dispose();

		//start to transfer and execute
		TransferFunction transferKernel = new TransferFunction();
		transferKernel.setCLString(CLString);
		transferKernel.setInputBuffer(inAllBuffer.array());
		transferKernel.setOutputBuffer(outBuffer.array());
		transferKernel.execute(range);

		for(int i = 0; i < 10; i++)
		{
			//System.out.println(inAllBuffer.order(ByteOrder.LITTLE_ENDIAN).getInt(i*4));
			System.out.println(outBuffer.order(ByteOrder.LITTLE_ENDIAN).getInt(i*4));
		}
		transferKernel.dispose();

		return;
	}

}
