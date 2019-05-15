package com.langsin.ServletDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUpLoad
 */
@WebServlet("/FileUpLoad")
@MultipartConfig
public class FileUpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String filename = part.getSubmittedFileName();
			filename = UUID.randomUUID()+filename;
			System.out.println(filename);
			File file = new File(request.getSession().getServletContext().getRealPath("/").substring(0, 32)+"image", filename);
			part.write(file.getAbsolutePath());
		}
		
		
//		Part part = request.getPart("img");
//        String disposition = part.getHeader("Content-Disposition");
//        String suffix = disposition.substring(disposition.lastIndexOf("."),disposition.length()-1);
//          //随机的生存一个32的字符串
//        String filename = UUID.randomUUID()+suffix;
//          //获取上传的文件名
//        InputStream is = part.getInputStream();
//        //动态获取服务器的路径
//        String serverpath = request.getServletContext().getRealPath("upload");
//        FileOutputStream fos = new FileOutputStream(serverpath+"/"+filename);
//        byte[] bty = new byte[1024];
//        int length =0;
//        while((length=is.read(bty))!=-1){
//            fos.write(bty,0,length);
//        }
//        fos.close();
//        is.close();
		
//		 request.setCharacterEncoding("UTF-8");
//	        Part part = request.getPart("img");
//	        String inputName=part.getName();
//	        InputStream input=part.getInputStream();
//	        //想要保存的目标文件的目录下
//	       String tagDir = request.getSession().getServletContext().getRealPath("/").substring(0, 32);
//	       tagDir = tagDir+"image";
//	       System.out.println(tagDir);
//	        //避免文件名重复使用uuid来避免,产生一个随机的uuid字符
//	        String realFileName=UUID.randomUUID().toString();
//	        OutputStream output=new FileOutputStream(new File(tagDir,realFileName));
//	        int len=0;
//	        byte[] buff=new byte[1024*8];
//	         
//	        while ((len = input.read(buff)) > -1) {
//	            output.write(buff, 0, len);
//	        }
//	 
//	        input.close();
//	        output.close();
//	        response.setCharacterEncoding("utf-8");
//	        response.getWriter().print("upload success!!");


	}

//	private String createName(String filename) {
//		// TODO Auto-generated method stub
//        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()) + "_" + filename;
//	}

//	private File createDir(ServletContext servletContext) {
//		// TODO Auto-generated method stub
//	    String p1 = ontext.getRealPath("/files");
//        File file = new File(p1, new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        return file;
//
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
