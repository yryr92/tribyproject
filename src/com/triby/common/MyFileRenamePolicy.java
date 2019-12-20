package com.triby.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		
		// 변경명 > 파일 업로드된 시간(년월일시분초)+0~100000 사이의 랜덤값(5자리 랜덤값)
		
		// 원본명 aaa.png > 변경명 2019092521330192017.png
		
		// 현재 시간을 long형으로 받음
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		// 5자리 랜덤 숫자 발생
		int ranNum = (int) (Math.random()*100000);
		
		// 확장자명 가져오기
		
		// 원본 파알명
		String name = originFile.getName(); // > "aaa.png"
		
		// 확장자만 추출해서 담아줄 변수
		String ext = "";
		
		int dot = name.lastIndexOf("."); // 3
		
		if(dot != -1) { // 파일이 존재할 경우
			// .을 포함해서 확장자 추출 후 ext에 담기
			ext = name.substring(dot); // ".png"
		}
		
		// 최종적으로 수정할 파일명
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext;
		
		// 원본파일을 변경된 파일명으로 생성 후 반환
		
		File newFile = new File(originFile.getParent(), fileName);
		
		
		return newFile;
		
	}
	
	

}
