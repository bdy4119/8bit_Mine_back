package mul.cam.a.util;

import java.util.Date;

public class FileUtil {
	
	// myfile.txt(filename)  ->  3354654621.txt(newfilename)
	public static String getNewFileName(String filename) {
		String newfilename = "";
		String fpost = "";	// fpost는 .txt와 같은 확장자명이 저장될 변수
		
		if(filename.indexOf('.') >= 0) {	// 파일 이름에 파일 확장자명이 있는 경우
			fpost = filename.substring(filename.indexOf('.'));	// .부터 확장자명 끝까지만 잘라(.txt 처럼)
			newfilename = new Date().getTime() + fpost;			// 65465132165 + .txt
		} else {	// 파일 확장자명이 없는 경우
			newfilename = new Date().getTime() + ".back";		// 65465132165 + .back
		}
		
		return newfilename;
	}

}
