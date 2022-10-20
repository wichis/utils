package mx.ryo.puntoycoma.standalone.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.concurrent.TimeUnit;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobStorageException;
import com.azure.storage.blob.specialized.BlockBlobClient;

import mx.edumex.dti.utils.exception.devel.FailedProcessException;
import mx.edumex.dti.utils.exception.negocio.ProcessingException;

public class AzureConnector {
	private String tmpFolder;
	private BlobContainerClient containerClient;
	private static final String MSG_ERROR = "ER0009IMS;No se pudo obtener correctamente el archivo.[DEVINFO]Algo paso con el proceso en AZURE con el archivo <%1$s>";

	public AzureConnector(String cadenaConnection, String nameContainer, String tmpFolder) {
		super();
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(cadenaConnection)
				.buildClient();
		containerClient = blobServiceClient.getBlobContainerClient(nameContainer);
		this.tmpFolder = tmpFolder;
	}

	/**
	 * Tal vez funcione despues
	 * 
	 * @param docAdjuntar
	 */
	@Deprecated
	public void cargar(DocumentoAdjunto docAdjuntar) {
		BlockBlobClient blockBlobClient = containerClient.getBlobClient("promo2022/ims.png").getBlockBlobClient();
		try (ByteArrayInputStream dataStream = new ByteArrayInputStream(docAdjuntar.getAdjunto())) {
			blockBlobClient.upload(dataStream, docAdjuntar.getAdjunto().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Subir archivos al storage de Azure.
	 * * Solo se subiran archivos a la nuebe cuando estos no existan en la misma.
	 * @param pathAzureArchivo
	 * @param adjunto
	 * @throws ProcessingException
	 */
	public void cargar(String pathAzureArchivo, byte[] adjunto) throws ProcessingException {
		BlockBlobClient blockBlobClient = containerClient.getBlobClient(pathAzureArchivo).getBlockBlobClient();
		if(!blockBlobClient.exists()) {			
			try (ByteArrayInputStream dataStream = new ByteArrayInputStream(adjunto)) {
				blockBlobClient.upload(dataStream, adjunto.length);
			} catch (IOException e) {
				throw new ProcessingException(String.format(AzureConnector.MSG_ERROR, pathAzureArchivo));
			}
		}

	}

	public InputStream descargar(String pathAzureArchivo) throws FailedProcessException, InterruptedException {
		try {
			BlobClient blobClient = containerClient.getBlobClient(pathAzureArchivo);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			blobClient.download(outputStream);
			TimeUnit.SECONDS.sleep(5);
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (BlobStorageException | UncheckedIOException | NullPointerException e) {
			String msg = String.format(AzureConnector.MSG_ERROR, pathAzureArchivo);
			throw new FailedProcessException(msg);
		}
	}
	
	public boolean existe(String pathAzureArchivo) {
		BlobClient blobClient = containerClient.getBlobClient(pathAzureArchivo);
		return blobClient.exists();
	}
	
//	public InputStream descargar(String pathAzureArchivo) throws ProcessingException, InterruptedException {
//		try {
//			BlobClient blobClient = containerClient.getBlobClient(pathAzureArchivo);
//			blobClient.downloadToFile(pathAzureArchivo);
//			TimeUnit.SECONDS.sleep(3);
//			return new ByteArrayInputStream(outputStream.toByteArray());
//		} catch (BlobStorageException | UncheckedIOException | NullPointerException e) {
//			String msg = String.format("AZURE: No se logro la comunicacion. Problemas para descargar el archivo. <%1$s>", pathAzureArchivo);
//			throw new ProcessingException(msg);
//		}
//	}
}
