package mul.cam.a;

import org.springframework.http.MediaType;

import jakarta.servlet.ServletContext;

public class MediaTypeUtils {

	public static MediaType getMediaTypeForFileName(ServletContext servletContext, String filename) {
		
		String mimeType = servletContext.getMimeType(filename);
		
		MediaType mediaType = MediaType.parseMediaType(mimeType);
		
		return mediaType;
		
	}
}
