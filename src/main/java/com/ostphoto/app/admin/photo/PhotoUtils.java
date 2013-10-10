package com.ostphoto.app.admin.photo;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;


public class PhotoUtils {
	
	
	enum PhotoSize {
	      
		  ORIGINAL,  M(160, 160), S(80, 80);

		  private int w;
		  private int h;
				  
			PhotoSize() {
			}

			PhotoSize(int w, int h) {
				this.w = w;
				this.setH(h);
			}

			public int getW() {
				return w;
			}

			public void setW(int w) {
				this.w = w;
			}

			public int getH() {
				return h;
			}

			public void setH(int h) {
				this.h = h;
			}
		  
		}
	
	public static BufferedImage getImage(File file, PhotoSize size) {
		BufferedImage bsrc, bdest;
		try {
		     bsrc = ImageIO.read(file);
			int  curW, curH, finalH,  finalW;
		    bsrc = ImageIO.read(file);
		    curW = bsrc.getWidth();
		    curH = bsrc.getHeight();		    
			if(curW > curH) {
				finalW = size.getW();
				finalH = (int)(curH/(curW/finalW));
			} else {
				finalH = size.getH();
				finalW = (int)(curW/(curH/finalH));
			} 	    
			bdest = new BufferedImage(finalW, finalH, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bdest.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance( (double)finalW
					/ bsrc.getWidth(), (double) finalH / bsrc.getHeight());
			g.drawRenderedImage(bsrc, at);
			// add the scaled image

	            
			return bdest;
		} catch (Exception e) {
			return null;
		}
	}


}
