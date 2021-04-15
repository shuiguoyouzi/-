package pro.yf.bj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @desc 请求工具类
 * @author Demarcia
 * @time 2021-03-09
 */

public class RequestUtils {
	
	/**
	 * @desc 获取 json类型的 post 请求数据
	 * @author Demarcia
	 * @time 2021-03-09
	 * @param HttpServletRequest request  请求
	 * @return LinkedHashMap
	 * @throws IOException 
	 */
	public static Map<String, Object> getRequestMap(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");//设定文本的字符集编码为UTF-8
			
			InputStream stream = request.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String temp = null;
			String postData = "";

			while((temp = reader.readLine()) != null) {
				postData += temp;
			}

			if (NullUtils.isNullOrEmpty(postData))
				return null;
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(postData, LinkedHashMap.class);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
