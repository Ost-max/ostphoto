package com.ostphoto.app.admin.photo;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class PhotoUtils {
	
	
	enum PhotoSize {
	      
		  ORIGINAL,  M(160, 160), S(120, 120);

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
		BufferedImage bsrc;
		try {
		     bsrc = ImageIO.read(file);
		     int type =  bsrc.getType() == 0? BufferedImage.TYPE_INT_ARGB : bsrc.getType();
			int  curW, curH, finalH,  finalW;
		    bsrc = ImageIO.read(file);
		    curW = bsrc.getWidth();
		    curH = bsrc.getHeight();		    
			if(curW > curH) {
				finalH = size.getH();
				finalW = (int)(curW/(curH/finalH));
			} else {
				finalW = size.getW();
				finalH = (int)(curH/(curW/finalW));		
			} 	    
			
			BufferedImage resizedImage = new BufferedImage(finalW, finalH, type);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(bsrc, 0, 0, finalW, finalH, null);
			g.dispose();	
			g.setComposite(AlphaComposite.Src);
		 
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING,
			RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		 
//			bdest = new BufferedImage(finalW, finalH, BufferedImage.TYPE_INT_RGB);
//			Graphics2D g = bdest.createGraphics();
//			AffineTransform at = AffineTransform.getScaleInstance( (double)finalW
//					/ bsrc.getWidth(), (double) finalH / bsrc.getHeight());
//			g.drawRenderedImage(bsrc, at);
//			// add the scaled image	            
			return resizedImage;
		} catch (Exception e) {
			return null;
		}
	}


}
