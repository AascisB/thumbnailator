package net.coobird.thumbnailator.geometry;

import java.awt.Dimension;

/**
 * Calculates the size of an enclosed object relative to the enclosing object.
 * 
 * @author coobird
 *
 */
public class RelativeSize implements Size
{
	/**
	 * The scaling factor to use for the enclosed object.
	 */
	private final double scalingFactor;
	
	/**
	 * Instantiates an object which calculates the size of an object, using
	 * the given scaling factor.
	 * 
	 * @param scalingFactor		The scaling factor to use to determine the
	 * 							size of the enclosing object.
	 * @throws IllegalArgumentException		When the scaling factor is not within
	 * 										the range of {@code 0.0d} and
	 * 										{@code 1.0d}, inclusive.
	 */
	public RelativeSize(double scalingFactor)
	{
		super();
		if (scalingFactor < 0.0d || scalingFactor > 1.0d)
		{
			throw new IllegalArgumentException(
					"The scaling factor must be between 0.0d and 1.0d, inclusive."
			);
		}
		this.scalingFactor = scalingFactor;
	}

	public Dimension calculate(int width, int height)
	{
		int newWidth = (int)Math.round(width * scalingFactor);
		int newHeight = (int)Math.round(height * scalingFactor);
		return new Dimension(newWidth, newHeight);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RelativeSize [scalingFactor=" + scalingFactor + "]";
	}
}