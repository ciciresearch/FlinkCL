package com.amd.aparapi.core;

import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

/**
 * Created by cc on 2017/9/30.
 */
public class TransferFunction_share extends Kernel {

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
