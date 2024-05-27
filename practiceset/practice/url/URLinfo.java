import java.net.URL;

public class URLinfo {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.example.com:/path/asd/?name=value");

            System.out.println("Full URL: " + url.toString());
            System.out.println("Host Name: " + url.getHost());
            int port = url.getPort();
            System.out.println("Port: " + (port == -1 ? url.getDefaultPort() : port));
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
