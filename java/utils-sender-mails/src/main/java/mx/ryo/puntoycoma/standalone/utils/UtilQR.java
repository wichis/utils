package mx.ryo.puntoycoma.standalone.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
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

public class UtilQR {
	/**
	 * Tamano para el codigo QR.
	 */
	private int size;

	/**
	 * El tama�o de la imagen sera de 200 por default
	 */
	public UtilQR() {
		super();
		this.size = 200;
	}

	/**
	 * 
	 * @param size Tamano de la imagen.
	 */
	public UtilQR(int size) {
		super();
		this.size = size;
	}

	/**
	 * 
	 * @param encodeTxt
	 * @param size
	 * @return
	 * @throws IOException
	 * @throws WriterException
	 * @throws IllegalArgumentException El {@code encodeTxt} no debe ser blanco.
	 *                                  {@link StringUtils#isNotBlank(CharSequence)}
	 */
	public final InputStream generarQRCode(String encodeTxt)
			throws IOException, WriterException, IllegalArgumentException {
		if (StringUtils.isNotBlank(encodeTxt)) {
			// Configuracion del QR
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			hintMap.put(EncodeHintType.MARGIN, 0);

			// Generacion del QR
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(encodeTxt, BarcodeFormat.QR_CODE, this.size, this.size, hintMap);
			// ImageIO.write(MatrixToImageWriter.toBufferedImage(byteMatrix) , "png", new
			// File("c:\\tmp\\image.png"));
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(MatrixToImageWriter.toBufferedImage(byteMatrix), "png", os);
			InputStream fis = new ByteArrayInputStream(os.toByteArray());
			return fis;
		} else {
			throw new IllegalArgumentException(
					String.format("El valor=<%1$s> es invalido.", String.valueOf(encodeTxt)));
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
