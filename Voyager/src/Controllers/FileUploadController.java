package Controllers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


public class FileUploadController {

	protected static String processRequest(HttpServletRequest request)
	        throws ServletException, IOException {

	    // Create path components to save the file
		File testDir =  new File("C:\\temp\\resources\\images");
		if(!testDir.exists()){
			testDir.mkdirs();
		}
	    final String path = "C:\\temp\\resources\\images";
	    final Part filePart = request.getPart("image");
	    final String fileName = getFileName(filePart);

	    OutputStream out = null;
	    InputStream filecontent = null;

	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }

	    } catch (FileNotFoundException fne) {
	    	//Need to throw exception up
	    }finally{
	    	if(out != null){
	    		out.close();
	    	}
	    }

	    return fileName;
	}

	public static String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
