package viettel.vtcc.reputa.orm.api.define;

public class ContextPath {

    public static final class Public {
        public static final String PUBLIC = "/public";
        public static final String ACCESS_DENIED = "/403";

        public static final class News {
            public static final String NEWS = "/news";
            public static final String SEARCH = "/search";
            public static final String VIEW = "/view";
        }
    }

    public static class DomainGroup {
        public static final String DOMAIN_GROUP = "/domain-group";
        public static final String ADD = "/add";
        public static final String UPDATE = "/update";
        public static final String GET_ALL = "/get-all";
        public static final String GET = "/get";
        public static final String DELETE = "/delete";
        public static final String DOMAIN = "/domain";
    }

    public static class User {
        public static final String USER = "/user";
        public static final String INFO_GET = "/get-info";
        public static final String INFO_GET_ALL = "get-all";
        public static final String USER_CHANGE_PASSWORD = "/change-password";
        public static final String USER_CHANGE_DISPLAY_NAME = "/change-display-name";
        public static final String USER_CREATE_SOURCE_REQUEST = "/create-source-request";
        public static final String USER_FORGET_PASSWORD = "/forget-password";
        public static final String USER_RESET_PASSWORD = "/reset-password";
        public static final String USER_SWITCH_ORGANIZATION = "/switch-organization";
    }

    public static class Organization {
        public static final String ORGANIZATION = "/organization";

        public static class User {
            public static final String USER = "/user";
            public static final String SEARCH = "/search";
        }
    }

    public static class Notification {
        public static final String NOTIFICATION = "/notification";
        public static final String GET = "/get";
        public static final String UPDATE_READ_AT = "/update-read-at";

        public static class Setting {
            public static final String SETTING = "/setting";
            public static final String CHANGE_FREQUENCY = "/frequency/change";
            public static final String GET = "/get";
            public static final String TOPIC_ADD = "/topic/add";
            public static final String SAVE = "/save";
            public static final String TOPIC_REMOVE = "/topic/remove";
            public static final String TOPIC_GET = "/topic/get";
        }

        public static final class Token {
            public static final String TOKEN = "/token";
            public static final String SAVE = "/save";
        }
    }

    public static class Authentication {
        public static final String AUTHENTICATION = "/authentication";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String REFRESH = "/refresh";
    }

    public static class Topic {
        public static final String TOPIC = "/topic";
        public static final String GET_TOPIC_INFO = "/get-topic-info";
        public static final String CREATE_SUB_TOPIC = "/create-sub-topic";
        public static final String DELETE_SUB_TOPICS = "/delete-sub-topic";
        public static final String GET_METADATA = "/metadata/get";
    }

    public static class SubTopic {
        public static final String SUB_TOPIC = "/sub-topic";
        public static final String ORDER = "/order";
        public static final String UPDATE = "/update";
    }

    public static class Rule {
        public static final String RULE = "/rule";
        public static final String UPDATE_USER_RULE = "/update-user-rule";
        public static final String CREATE_TOPIC_RULE = "/create-topic-rule";
        public static final String DELETE_TOPIC_RULE = "/delete-topic-rule";
    }

    public static class News {
        public static final String GET_TAGS = "/get-keywords";
        public static final String NEWS = "/news";
        public static final String SEARCH = "/search";
        public static final String PIN = "/pin";
        public static final String SEARCH_USER_PIN = "user-pin";
        public static final String UPDATE_SENTIMENT = "/update-sentiment";
        public static final String DELETE = "/delete";
        public static final String STATISTIC_SENTIMENT_BY_DAY = "/statistic-sentiment-by-day";
        public static final String STATISTIC_SENTIMENT_BY_DAYS = "/statistic-sentiment-by-days";
        public static final String STATISTIC_SOURCE_BY_DAY = "/statistic-source-by-day";
        public static final String STATISTIC_SOURCE_BY_DAYS = "/statistic-source-by-days";
        public static final String STATISTIC_SOURCE_AND_SENTIMENT_BY_DAY = "/statistic-source-and-sentiment-by-day";
        public static final String STATISTIC_SPAM = "/statistic-spam";
        public static final String STATISTIC_DOMAIN = "/statistic-domain";
        public static final String STATISTIC_REACTION = "/statistic/reaction";
        public static final String VIEW_ARTICLE_APP = "/view-article-app";
        public static final String VIEW_ARTICLE_HTML = "/view-article-html";
        public static final String VIEW_ORIGINAL_HTML = "/view-original-html";
        public static final String GET_SIMILAR = "/get-similar";
        public static final String SEARCH_DELETE = "/search-delete";
        public static final String EXPORT = "/export";
        public static final String EXPORT_ALL = "/export-all";
        public static final String DEMOGRAPHIC = "/demographic";
        public static final String REACTION = "/reaction";
        //v2
        public static final String NEWSV2 = "/news/v2";
        public static final String TAG = "/news/v2/tag";
        public static final String FLOW_UPDATE = "/flow-update";
        public static final String STATISTIC_INFO_BY_DAYS = "/statistic-info-by-days";
        public static final String TRENDING_TOPIC = "/trending-topic";
        public static final String TAG_CREATE = "/create";
        public static final String TAG_UPDATE = "/update";
        public static final String TAG_DELETE = "/delete";
        public static final String TAG_DISABLE = "/disable";
        public static final String TAG_INFO = "/info";
        public static final String TAG_USER = "/tag-user";
        public static final String TAG_MANUAL = "/manual-tag";

        public static final class Classification {
            public static final String CLASSIFICATION = "/classification";
            public static final String UPDATE = "/update";
            public static final String REMOVE = "/remove";
        }
    }

    public static class Classification {
        public static final String CLASSIFICATION = "/classification";
        public static final String HISTORY = "/history";
        public static final String SEARCH = "/search";
        public static final String GET = "/get";
    }

    public static class Source {
        public static final String SOURCE = "/source";
        public static final String GET = "/get";
        public static final String DELETE_CACHE = "/delete-cache";
    }

    public static class Suggester {
        public static final String SUGGESTER = "/suggester";
        public static final String DOMAIN = "/domain";
    }

    public static final class Report {
        public static final String REPORT = "/report";
        public static final String SEARCH = "/search";
        public static final String DOWNLOAD = "/download";
        public static final String CREATE_REQUEST = "/create-request";
    }

    public static final class FeedBack {
        public static final String FEEDBACK = "/feedback";
        public static final String SAVE = "/save";
        public static final String GET = "/get";
    }

    public static final class Mic {
        public static final String MIC = "/mic";
        public static final String STATISTIC_SENTIMENT_DOMAIN = "/domain-sentiment-statistic";
        public static final String STATISTIC_DEPOSITORY_DOMAIN = "/domain-depository-statistic";
        public static final String STATISTIC_BY_TIME = "/statistic-by-time";
        public static final String STATISTIC_BY_TIMES = "/statistic-by-times";
        public static final String SEARCH = "/search";
        public static final String DOMAIN_STATISTIC = "/domain-statistic";
        public static final String WARNING = "/warning";
        public static final String KEYWORD_GET = "/keyword/get";
        public static final String SOCIAL = "/social";
        public static final String MONITOR = "/monitor";
        public static final String COMPARE = "/compare";
        public static final String STATISTIC_AUTHOR = "/statistic-author";
        public static final String STATISTIC_CATEGORY = "/statistic-category";
    }

    public static final class Profile {
        public static final String PROFILE = "/profile";
        public static final String INFO = "/info";
    }
}
