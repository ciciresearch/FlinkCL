package com.amd.aparapi.FlinkCLbridge;

import com.amd.aparapi.Kernel;

/**
 * Created by cc on 2017/3/22.
 */
public class AparapiBridge extends Kernel {

	byte[] inputBuffer;
	byte[] outputBuffer;

	hUniMapDriver driver;

	public void run() {
		int gid = getGlobalId();
		//thisOut[gid] = (OUT)thisFunction.map(thisIn[gid]);
		//thisFunction.map(thisIn[gid]);
		inputBuffer[gid] = outputBuffer[gid];
	}

	public byte[] getOutputBuffer() {
		return outputBuffer;
	}
	public void setOutputBuffer(byte[] outputBuffer) {
		this.outputBuffer = outputBuffer;
	}
	public void setInputBuffer(byte[] inputBuffer) {
		this.inputBuffer = inputBuffer;
	}


}
