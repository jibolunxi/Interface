package com.csu.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.dao.ShareDAO;
import com.csu.model.Share;
import com.google.gson.Gson;


public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShareDAO shareDAO=new ShareDAO();
		
		String page = request.getParameter("page");
		// 将数据添加到数组
		List<Share> shareList = new ArrayList<Share>();
		shareList = shareDAO.getShare();
 
		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(shareList);
 
		// 输出到界面
		System.out.println(json);
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.print(json);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
