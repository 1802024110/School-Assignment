package tool;

import java.util.Map;

public interface Request {
    String get(String url);

    String post(String url);

    void setHeader(Map<String, String> header);

    void setBody(Map<String, String> body);
}
