package pro.yf.bj.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @desc 响应 工具类
 * @author Demarcia
 * @time 2021-03-09
 */
public class ResponseUtils {

	/**
	 * @desc 输出响应文本
	 * @param response
	 * @param result
	 * @throws IOException
	 */
	public static void writeResponse(HttpServletResponse response, String result){
		response.setContentType("text/plain");//设定本次响应的内容类型为纯文本
	    response.setCharacterEncoding("UTF-8");//设定文本的字符集编码为UTF-8
	    System.err.println("qwawdewf");
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.setHeader("Access-Control-Allow-Methods","*");
	    response.setHeader("Access-Control-Allow-Headers","*");
	    response.setHeader("Access-Control-Allow-Credentials","true");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(result);
			writer.flush();
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
