package myWorkDir.objects;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.Random;

public class WebFingerPrint {

    public enum WebFPStatus{
        NonValid(0),
        Valid(1),
        TrxVerified(2);

        public Integer statusValue;

        WebFPStatus(Integer statusValue) {
            this.statusValue = statusValue;
        }
    }

    private final String deviceId;
    private final String user_agent;
    private final String color_depth;
    private final String pixel_ratio;
    private final String timezone_offset;
    private final String local_storage;
    private final String canvas;
    private final String has_lied_languages;
    private final String has_lied_resolution;
    private final String has_lied_os;
    private final String has_lied_browser;
    private final String resolution;
    private final String available_resolution;
    private final String do_not_track;
    private final String navigator_platform;
    private final String js_fonts;
    private final String cpu_class;
    private final String language;
    private final String session_storage;
    private final String indexed_db;
    private final String regular_plugins;
    private final String webgl;
    private final String adblock;
    private final String hardware_concurrency;
    private final String open_database;
    private final String touch_support;

    private String FingerPrintEncode() throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString((
                (this.deviceId == null ? "" : "DeviceId=" + this.deviceId + "|||")
                        + (this.user_agent == null ? "" : "user_agent=" + this.user_agent + "|||")
                        + (this.language == null ? "" : "language=" + this.language + "|||")
                        + (this.color_depth == null ? "" : "color_depth=" + this.color_depth + "|||")
                        + (this.pixel_ratio == null ? "" : "pixel_ratio=" + this.pixel_ratio + "|||")
                        + (this.hardware_concurrency == null ? "" : "hardware_concurrency=" + this.hardware_concurrency + "|||")
                        + (this.resolution == null ? "" : "resolution=" + this.resolution + "|||")
                        + (this.available_resolution == null ? "" : "available_resolution=" + this.available_resolution + "|||")
                        + (this.timezone_offset == null ? "" : "timezone_offset=" + this.timezone_offset + "|||")
                        + (this.session_storage == null ? "" : "session_storage=" + this.session_storage + "|||")
                        + (this.local_storage == null ? "" : "local_storage=" + this.local_storage + "|||")
                        + (this.indexed_db == null ? "" : "indexed_db=" + this.indexed_db + "|||")
                        + (this.open_database == null ? "" : "open_database=" + this.open_database + "|||")
                        + (this.cpu_class == null ? "" : "cpu_class=" + this.cpu_class + "|||")
                        + (this.navigator_platform == null ? "" : "navigator_platform=" + this.navigator_platform + "|||")
                        + (this.do_not_track == null ? "" : "do_not_track=" + this.do_not_track + "|||")
                        + (this.regular_plugins == null ? "" : "regular_plugins=" + this.regular_plugins + "|||")
                        + (this.canvas == null ? "" : "canvas=" + this.canvas + "|||")
                        + (this.webgl == null ? "" : "webgl=" + this.webgl + "|||")
                        + (this.adblock == null ? "" : "adblock=" + this.adblock + "|||")
                        + (this.has_lied_languages == null ? "" : "has_lied_languages=" + this.has_lied_languages + "|||")
                        + (this.has_lied_resolution == null ? "" : "has_lied_resolution=" + this.has_lied_resolution + "|||")
                        + (this.has_lied_os == null ? "" : "has_lied_os=" + this.has_lied_os + "|||")
                        + (this.has_lied_browser == null ? "" : "has_lied_browser=" + this.has_lied_browser + "|||")
                        + (this.touch_support == null ? "" : "touch_support=" + this.touch_support + "|||")
                        + (this.js_fonts == null ? "" : "js_fonts=" + this.js_fonts)).getBytes("utf-8"));
    }

    public static class Builder {

        String deviceId = "f0eebc94-ddc7-4bf8-9f47-4f79ae21eb06";
        String user_agent = "Mozilla/8.8 (Windows NT 88.8; Win88; x88) AppleWebKit/537.36 (KHTML, like Hrecko) Chrome/61.0.3163.100 Safari/537.36";
        String language = "ru";
        String color_depth = "24";
        String pixel_ratio = "1";
        String hardware_concurrency = "4";
        String resolution = "8888,8888";
        String available_resolution = "1849,1080";
        String timezone_offset = "-180";
        String session_storage = "1";
        String local_storage = "1";
        String indexed_db = "1";
        String open_database = "1";
        String cpu_class = "unknown";
        String navigator_platform = "Win32";
        String do_not_track = "unknown";
        String regular_plugins = "916113497";
        String canvas = "1742371597";
        String webgl = "-935802847";
        String adblock = "false";
        String has_lied_languages = "false";
        String has_lied_resolution = "false";
        String has_lied_os = "true";
        String has_lied_browser = "false";
        String touch_support = "0,false,false";
        String js_fonts = "1811224444";

        public Builder() {
        }

        public Builder deviceId(String DeviceId) {
            deviceId = DeviceId;
            return this;
        }

        public Builder user_agent(String User_agent) {
            user_agent = User_agent;
            return this;
        }

        public Builder language(String Language) {
            language = Language;
            return this;
        }

        public Builder color_depth(String Color_depth) {
            color_depth = Color_depth;
            return this;
        }

        public Builder pixel_ratio(String Pixel_ratio) {
            pixel_ratio = Pixel_ratio;
            return this;
        }

        public Builder hardware_concurrency(String Hardware_concurrency) {
            hardware_concurrency = Hardware_concurrency;
            return this;
        }

        public Builder resolution(String Resolution) {
            resolution = Resolution;
            return this;
        }

        public Builder available_resolution(String Available_resolution) {
            available_resolution = Available_resolution;
            return this;
        }

        public Builder timezone_offset(String Timezone_offset) {
            timezone_offset = Timezone_offset;
            return this;
        }

        public Builder session_storage(String Session_storage) {
            session_storage = Session_storage;
            return this;
        }

        public Builder local_storage(String Local_storage) {
            local_storage = Local_storage;
            return this;
        }

        public Builder indexed_db(String Indexed_db) {
            indexed_db = Indexed_db;
            return this;
        }

        public Builder open_database(String Open_database) {
            open_database = Open_database;
            return this;
        }

        public Builder cpu_class(String Cpu_class) {
            cpu_class = Cpu_class;
            return this;
        }

        public Builder navigator_platform(String Navigator_platform) {
            navigator_platform = Navigator_platform;
            return this;
        }

        public Builder do_not_track(String Do_not_track) {
            do_not_track = Do_not_track;
            return this;
        }

        public Builder regular_plugins(String Regular_plugins) {
            regular_plugins = Regular_plugins;
            return this;
        }

        public Builder canvas(String Canvas) {
            canvas = Canvas;
            return this;
        }

        public Builder webgl(String Webgl) {
            webgl = Webgl;
            return this;
        }

        public Builder adblock(String Adblock) {
            adblock = Adblock;
            return this;
        }

        public Builder has_lied_languages(String Has_lied_languages) {
            has_lied_languages = Has_lied_languages;
            return this;
        }

        public Builder has_lied_resolution(String Has_lied_resolution) {
            has_lied_resolution = Has_lied_resolution;
            return this;
        }

        public Builder setHas_lied_os(String Has_lied_os) {
            has_lied_os = Has_lied_os;
            return this;
        }

        public Builder has_lied_browser(String Has_lied_browser) {
            has_lied_browser = Has_lied_browser;
            return this;
        }

        public Builder touch_support(String Touch_support) {
            touch_support = Touch_support;
            return this;
        }

        public Builder js_fonts(String Js_fonts) {
            js_fonts = Js_fonts;
            return this;
        }

        public WebFingerPrint build() {
            return new WebFingerPrint(this);
        }
    }

    private WebFingerPrint(WebFingerPrint.Builder builder) {
        deviceId = builder.deviceId;
        user_agent = builder.user_agent;
        language = builder.language;
        color_depth = builder.color_depth;
        pixel_ratio = builder.pixel_ratio;
        hardware_concurrency = builder.hardware_concurrency;
        resolution = builder.resolution;
        available_resolution = builder.available_resolution;
        timezone_offset = builder.timezone_offset;
        session_storage = builder.session_storage;
        local_storage = builder.local_storage;
        indexed_db = builder.indexed_db;
        open_database = builder.open_database;
        cpu_class = builder.cpu_class;
        navigator_platform = builder.navigator_platform;
        do_not_track = builder.do_not_track;
        regular_plugins = builder.regular_plugins;
        canvas = builder.canvas;
        webgl = builder.webgl;
        adblock = builder.adblock;
        has_lied_languages = builder.has_lied_languages;
        has_lied_resolution = builder.has_lied_resolution;
        has_lied_os = builder.has_lied_os;
        has_lied_browser = builder.has_lied_browser;
        touch_support = builder.touch_support;
        js_fonts = builder.js_fonts;
    }

    public static WebFingerPrint getRandomWebFingerPrint(){
        Random rnd = new Random();
        return new Builder().
                deviceId(UUID.randomUUID().toString()).
                resolution(Integer.toString(rnd.nextInt(9999) + 1) + "," + Integer.toString(rnd.nextInt(9999) + 1)).
                available_resolution(Integer.toString(rnd.nextInt(9999) + 1) + "," + Integer.toString(rnd.nextInt(9999) + 1)).
                regular_plugins(Integer.toString(rnd.nextInt(999999999) + 1)).
                canvas(Integer.toString(rnd.nextInt(1999999999) + 1)).
                webgl("-" + Integer.toString(rnd.nextInt(999999999) + 1)).
                js_fonts(Integer.toString(rnd.nextInt(1999999999) + 1)).
                build();
    }

    public static WebFingerPrint getWebFingerPrintWithoutDeviceId(){
        Random rnd = new Random();
        return new Builder().
                deviceId("").
                resolution(Integer.toString(rnd.nextInt(9999) + 1) + "," + Integer.toString(rnd.nextInt(9999) + 1)).
                available_resolution(Integer.toString(rnd.nextInt(9999) + 1) + "," + Integer.toString(rnd.nextInt(9999) + 1)).
                regular_plugins(Integer.toString(rnd.nextInt(999999999) + 1)).
                canvas(Integer.toString(rnd.nextInt(1999999999) + 1)).
                webgl("-" + Integer.toString(rnd.nextInt(999999999) + 1)).
                js_fonts(Integer.toString(rnd.nextInt(1999999999) + 1)).
                build();
    }

    public static WebFingerPrint getRandomWebFingerPrintWithAbsentParameter(String Parameter){
        Random rnd = new Random();
        return new Builder().
                deviceId("deviceId".equals(Parameter) ? null : UUID.randomUUID().toString()).
                user_agent("user_agent".equals(Parameter) ? null : "Mozilla/8.8 (Windows NT 88.8; Win88; x88) AppleWebKit/537.36 (KHTML, like Hrecko) Chrome/61.0.3163.100 Safari/537.36").
                color_depth("color_depth".equals(Parameter) ? null : "24").
                pixel_ratio("pixel_ratio".equals(Parameter) ? null : "1").
                timezone_offset("timezone_offset".equals(Parameter) ? null : "-180").
                local_storage("local_storage".equals(Parameter) ? null : "1").
                canvas("canvas".equals(Parameter) ? null : Integer.toString(rnd.nextInt(1999999999) + 1)).
                has_lied_languages("has_lied_languages".equals(Parameter) ? null : "false").
                has_lied_resolution("has_lied_resolution".equals(Parameter) ? null : "false").
                setHas_lied_os("has_lied_os".equals(Parameter) ? null : "true").
                has_lied_browser("has_lied_browser".equals(Parameter) ? null : "false").
                resolution("resolution".equals(Parameter) ? null : Integer.toString(rnd.nextInt(9999) + 1) + "," + Integer.toString(rnd.nextInt(9999) + 1)).
                available_resolution("available_resolution".equals(Parameter) ? null : Integer.toString(rnd.nextInt(9999) + 1) + "," + Integer.toString(rnd.nextInt(9999) + 1)).
                do_not_track("do_not_track".equals(Parameter) ? null : "unknown").
                navigator_platform("navigator_platform".equals(Parameter) ? null : "Win32").
                regular_plugins(Integer.toString(rnd.nextInt(999999999) + 1)).
                webgl("-" + Integer.toString(rnd.nextInt(999999999) + 1)).
                js_fonts(Integer.toString(rnd.nextInt(1999999999) + 1)).
                build();
    }

    @Override
    public String toString() {
        try {
            return FingerPrintEncode();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Fingerprint wasn't encoded!";
        }
    }

}
