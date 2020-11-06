package mx.ryo.xoloit.utils.image.maker;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRMaker {
	
	public static void main(String[] args) {
		Image imgQr;
		try {
			imgQr = QRMaker.generarQRCode("Hola mundo", 250);
			BufferedImage bi = (BufferedImage) imgQr;
			File outputfile = new File("/swtools/Temp/saved.png");

			ImageIO.write(bi, "png", outputfile);
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
	/**
	 * 
	 * @param encodeTxt
	 * @param size
	 * @return
	 * @throws IOException
	 * @throws WriterException
	 * @throws IllegalArgumentException El {@code encodeTxt} no debe ser blanco. {@link StringUtils#isNotBlank(CharSequence)} 
	 */
	public static final Image generarQRCode(String encodeTxt, int size) throws IOException, WriterException, IllegalArgumentException {
		if (StringUtils.isNotBlank(encodeTxt)) {
			// Configuracion del QR
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			hintMap.put(EncodeHintType.MARGIN, 0);

			// Generación del QR
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(encodeTxt, BarcodeFormat.QR_CODE, size, size, hintMap);
			return MatrixToImageWriter.toBufferedImage(byteMatrix);
		} else {
			throw new IllegalArgumentException(String.format("El valor=<%1$s> es invalido.", String.valueOf(encodeTxt)));
		}
	}
}
