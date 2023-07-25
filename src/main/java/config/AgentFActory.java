package config;

public class AgentFActory {
    public static void create(Agents agents){
        switch (agents){
            case ANDROIDEN -> createAndroid();
            case UkraineLang -> createlang();
        }
    }

    private static void createlang() {
        ConfiguretionWebDriver.server.addRequestFilter((request, contents, messageInfo) -> {
          //  request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");

//            request.headers().add("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv)" +
//                    "AppleWebKit/537.36 (KHTML, like Gecko)" +
//                    "Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
            request.headers().add("Accept-Language", "uk");
            request.headers().add("Content-Language", "uk_UK");

            request.headers().remove("Referer");
            return null;
        });
    }

    private static void createAndroid() {
        ConfiguretionWebDriver.server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");

            request.headers().add("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv)" +
                    "AppleWebKit/537.36 (KHTML, like Gecko)" +
                    "Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
            request.headers().add("Accept-Language", "en");
            request.headers().add("Content-Language", "en_EN");

            request.headers().remove("Referer");
            return null;
        });
    }
}
