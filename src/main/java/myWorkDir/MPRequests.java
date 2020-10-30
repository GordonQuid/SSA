package myWorkDir;

import ru.alfabank.tests.core.helpers.PropertyLoader;

public class MPRequests {


    public enum MpapiRequests {
        GetRequestToken("/mpapi/GetRequestToken"),
        GetCard("mpapi/GetCard");


        String url;
        MpapiRequests(String url) {
            this.url = url;
        }

        public static String getURL(MpapiRequests method) {
            return (PropertyLoader.getPropertyOrValue("server_url") + method.url);
        }


    }
}
