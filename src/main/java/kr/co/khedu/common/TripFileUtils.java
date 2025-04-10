package kr.co.khedu.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class TripFileUtils {
	public static String saveFile(Part p, HttpSession session, String path) {
		String originFileName = p.getSubmittedFileName();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		
		String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String dateFolder = new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		int randomValue = (int)(Math.random() * 99999999) + 1;
		
		String changeFileName = "trip-log_" + currentDate + "_" + randomValue + ext;
		
		// String savePath = session.getServletContext().getRealPath(path);
		// => 이렇게 하니 이클립스의 .metadata 자손 중 tmp0 자손으로 임시공간에 파일이 저장됨..
		// 		그래서 저장은 되지만 출력이 어려움
		String rootPath = session.getServletContext().getRealPath(path);
        String savePath = rootPath + File.separator + dateFolder;

        File folder = new File(savePath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File f = new File(savePath, changeFileName);

        try {
            p.write(f.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("originFileName: " + originFileName);
        System.out.println("savePath: " + savePath);
        System.out.println("changeFileName: " + changeFileName);
        System.out.println("전체경로: " + f.getAbsolutePath());

        // 실제 DB에 저장될 경로를 반환: "/resources/upload/날짜/파일명"
        return path + dateFolder + "/" + changeFileName;
	}
}
