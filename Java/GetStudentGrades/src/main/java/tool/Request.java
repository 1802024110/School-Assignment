package tool;

import java.util.Map;

public interface Request {
    public String get(String url);
    public String post(String url);
    public void setHeader(Map<String,String> header);
    public void setBody(Map<String,String> body);
}
