package viettel.vtcc.reputa.orm.api.define;

import javax.management.timer.Timer;

public class Constant {
    public static final String VIEWER_USERNAME = "Reputa@Business@Orm@Viettel@VTCC";
    public static final String VIEWER_PASSWORD = "Reputa@181112!_!oRm";
    public static final String SDF_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static String RESET_PASSWORD_HTML_FORMAT;
    public static final long EXPIRATION_TIME = 14 * Timer.ONE_DAY;
    public static final String USERNAME_USERID_DELIMITER = ";";
    public static final String SIGN_UP_URL = "/users/sign-up";

    public static final class OrmUserInfo {
        public static final class JsonField {
            public static final String USER_ID = "user_id";
            public static final String USERNAME = "username";
            public static final String DISPLAY_NAME = "display_name";
            public static final String PASSWORD = "password";
            public static final String REMEMBER_TOKEN = "remember_token";
            public static final String STATUS = "status";
            public static final String PHONE = "phone";
            public static final String EMAIL = "email";
            public static final String ADDRESS = "address";
            public static final String AVATAR = "avatar";
            public static final String EXPIRED_AT = "expired_at";
            public static final String CREATED_AT = "created_at";
            public static final String UPDATED_AT = "updated_at";
            public static final String ORGANIZATIONS = "organizations";
            public static final String USER_TOPIC = "user_topic";
            public static final String USER_SUBTOPIC = "user_subtopic";
            public static final String ROLES = "roles";
            public static final String PERMISSION = "permission";
            public static final String MAIN_ORGANIZATION_ID = "main_organization_id";
            public static final String TOKEN_EXPIRED_AT = "token_expired_at";
            public static final String CURRENT_ORGANIZATION_ID = "current_organization_id";
        }
    }

    public static final class Jwt {
        public static final String SECRET_KEY = "thangnd36@reputa(1994)";
        public static final String TOKEN_PREFIX = "Bearer ";
        public static final String HEADER_STRING = "Authorization";
    }

    public static final class MailConfiguration {
        public static final String MAIL_USERNAME = "tuanpm34@viettel.com.vn";
    }

    public static final class OrmOrganizationInfo {
        public static final class JsonField {
            public static final String ORGANIZATION_ID = "organization_id";
            public static final String NAME = "name";
            public static final String DISPLAY_NAME = "display_name";
            public static final String DESCRIPTION = "description";
            public static final String ADDRESS = "address";
            public static final String CREATED_AT = "created_at";
            public static final String UPDATED_AT = "updated_at";
            public static final String TOPIC = "topic";
            public static final String IMAGE = "image";
            public static final String SEARCH_TYPE = "search_type";
        }
    }

}
