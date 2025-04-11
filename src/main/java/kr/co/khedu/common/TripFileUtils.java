package kr.co.khedu.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 * 
 * @author sjsj1
 * Servers의 Serve modules without publishing을 체크해줘야한다
 * 		=> 톰캣이 실행 중일 때는 변경사항 저장이 안되므로 꼭 서버를 종료하고 체크해야한다
 * 		=> 체크해주지 않으면 server path로 되어 있는 기본 경로에 저장하므로 꼭 변경해줘야한다
 */

public class TripFileUtils {
	private String uploadPath;
	private ServletContext app;
	
	public static TripFileUtils create(ServletContext app) {
		TripFileUtils tripFileUtils = new TripFileUtils();
		tripFileUtils.setApp(app);
		tripFileUtils.setUploadPath(app.getRealPath("/assets/resources/upload/"));
		
		return tripFileUtils;
	}
	private void setApp(ServletContext app) {
		this.app = app;
	}
	
	private void setUploadPath(String realPath) {
		this.uploadPath = realPath;
	}

	// 파일 저장 메서드
	public void saveFile(Part part, String subFolder, String fileName) {
		// File.separator : \를 의미
		// System.out.println("Utils fileName: " + fileName);
		// System.out.println("Utils subFolder: " + subFolder);
		
		String realPath = this.uploadPath + subFolder + "/" + fileName;
		
		try (
				InputStream fis = part.getInputStream();
				OutputStream fos = new FileOutputStream(realPath);
		) {
			byte[] buffer = new byte[1024];
			int len = 0;
			
			while((len = fis.read(buffer, 0, 1024)) != -1) fos.write(buffer, 0, len);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// /resources/upload/ 하위 폴더 생성
	public String createFilePath() {
		LocalDateTime date = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String[] paths = formatter.format(date).split("-");
		
		String result = paths[0] + "/" + paths[1] + "/" + paths[2];
		
		createFolders(result);
		
		return result;
	}
	
	// 폴더 생성 메서드
	private void createFolders(String paths) {
		File folders = new File(uploadPath, paths);
		
		if(!folders.exists()) folders.mkdirs();
	}
	
	// 파일 명 변경 메서드
	public static String changeFileName(Part p) {
		String originFileName = p.getSubmittedFileName();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		
		String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		int randomValue = (int)(Math.random() * 99999999) + 1;
		
		String changeFileName = "trip-log_" + currentDate + "_" + randomValue + ext;
		
		return changeFileName;
	}
}
