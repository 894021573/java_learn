package common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ht.blog.common.help.result.AuthCodeMsg;
import common.util.result.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil
{
    public static void printJson(HttpServletResponse response,Object object) throws IOException
    {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.print(mapper.writeValueAsString(object));
        writer.close();
        response.flushBuffer();
    }
}
