package mx.ryo.xoloit.utils.image.maker;

import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

import com.google.zxing.WriterException;

class QRMakerTest {

	@Test
	void testGenerarQRCode() {
		Image imgQr;
		try {
			imgQr = new QRMaker().generarQRCode("Hola mundo");
			BufferedImage bi = (BufferedImage) imgQr;
			File outputfile = new File("/swtools/Temp/saved.png");

			ImageIO.write(bi, "png", outputfile);
			assertNotNull(imgQr);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
