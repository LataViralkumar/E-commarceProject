package com.ecommerce.fileUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
//	public static String upload_dir = "E:\\ecommerce\\target\\classes\\static\\image";
	public final String upload_dir = new ClassPathResource("static/image/").getFile().getAbsolutePath();

	public FileUploadHelper() throws IOException{

	}
	
	public boolean fileUpload_img(MultipartFile multipartFile) {
		boolean f = false;
		try {
			
//			InputStream is  = multipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
// 			
//				System.out.println(t);
//			FileOutputStream fos = new FileOutputStream(upload_dir + "\\"+multipartFile.getOriginalFilename() );
//			fos.write(data);
//			fos.flush();
			
			Files.copy(multipartFile.getInputStream(), Paths.get(upload_dir + "\\"+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			f=true;

			
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
}
