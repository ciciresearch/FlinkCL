package iaparapibridge.test;

import iaparapi.Range;
import iaparapibridge.FlinkCLbridge.AparapiBridge;

/**
 * Created by cc on 2017/11/22.
 */
public class testAparapiBridge {
	public static void main(String[] _args)
	{
		Range range = Range.create(512);

		AparapiBridge kernel = new AparapiBridge();
		byte[] in = new byte[512*4];
		byte[] out = new byte[512*4];

		//kernel.setFunction(new TestUniMapFunction());
		//kernel.setIn(in);4
		//kernel.setOut(out);
		kernel.setInputBuffer(in);
		kernel.setOutputBuffer(out);

		kernel.execute(range);

		kernel.dispose();
	}

}
