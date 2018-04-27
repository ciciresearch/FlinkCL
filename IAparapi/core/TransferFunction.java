package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

/**
 * Created by cc on 2017/10/30.
 */
public class TransferFunction extends Kernel {

	byte[] outBuffer;
	byte[] inBuffer;

	public void run() {
		int gid = getGlobalId();
		outBuffer[gid] = 1;
		inBuffer[gid] = 0;
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


}
