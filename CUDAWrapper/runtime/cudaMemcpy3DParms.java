package CUDAWrapper.runtime;

/**
 * Java port of cudaMemcpy3DParms.<br />
 * <br />
 * Most comments are taken from the CUDA reference manual.<br />
 * <br />
 * @see CUDAWrapper#cudaMemcpy3D
 */
public class cudaMemcpy3DParms
{
    /**
     * The source array.
     */
    public cudaArray srcArray = new cudaArray();

    /**
     * The srcPos and dstPos fields are optional offsets into the source and destination objects and are defined in
     * units of each object's elements. The element for a host or device pointer is assumed to be unsigned char.
     * For CUDA arrays, positions must be in the range [0, 2048) for any dimension.
     */
    public cudaPos srcPos = new cudaPos();

    /**
     * The source pointer.
     */
    public cudaPitchedPtr srcPtr = new cudaPitchedPtr();


    /**
     * The destination array.
     */
    public cudaArray dstArray = new cudaArray();

    /**
     * The srcPos and dstPos fields are optional offsets into the source and destination objects and are defined in
     * units of each object's elements. The element for a host or device pointer is assumed to be unsigned char.
     * For CUDA arrays, positions must be in the range [0, 2048) for any dimension.
     */
    public cudaPos dstPos = new cudaPos();

    /**
     * The destination pointer.
     */
    public cudaPitchedPtr dstPtr = new cudaPitchedPtr();

    /**
     * The extent field defines the dimensions of the transferred area in elements. If a CUDA array is participating
     * in the copy the extent is defined in terms of that array's elements. If no CUDA array is participating in the
     * copy then the extents are defined in elements of unsigned char.
     */
    public cudaExtent extent = new cudaExtent();

    /**
     * The kind field defines the direction of the copy. It must be one of the cudaMemcpyKind values.
     *
     * @see cudaMemcpyKind
     */
    public int kind;

    /**
     * Returns a String representation of this object.
     *
     * @return A String representation of this object.
     */
    @Override
    public String toString()
    {
        return "cudaMemcpy3DParms["+createString(",")+"]";
    }

    /**
     * Creates and returns a formatted (aligned, multi-line) String
     * representation of this object
     *
     * @return A formatted String representation of this object
     */
    public String toFormattedString()
    {
        return "Parameters for cudaMemcopy3D:\n    "+createString("\n    ");
    }

    /**
     * Creates and returns a string representation of this object,
     * using the given separator for the fields
     *
     * @return A String representation of this object
     */
    private String createString(String f)
    {
        return
            "srcArray="+srcArray+f+
            "srcPos="+srcPos+f+
            "srcPtr="+srcPtr+f+
            "dstArray="+dstArray+f+
            "dstPos="+dstPos+f+
            "dstPtr="+dstPtr+f+
            "extent="+extent+f+
            "kind="+cudaMemcpyKind.stringFor(kind);
    }



}
