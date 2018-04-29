package com.yy.rest.sign_verify;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2018/4/29 at 上午10:27
 */
@Slf4j
@Component
public class LocaleUtils {
    //请求终端
    private final static String SPIDER = "spider";
    private final static String ANDROID = "android";
    private final static String IPHONE = "iphone";
    private final static String IOS = "ios";

    //请求头
    private final static String USER_AGENT = "User-Agent";

    //语言
    private final static String[] ENGLISH = {"en", "en-us", "en_us"};
    private final static String[] CHINA = {"zh-cn", "zh_cn"};
    private final static String[] CHINA_TW = {"tw", "zh-tw", "zh_tw"};

    private static LocaleResolver localeResolver;
    private static MessageSource messageSource;

    @Autowired
    public LocaleUtils(final LocaleResolver localeResolver, final MessageSource messageSource) {
        LocaleUtils.localeResolver = localeResolver;
        LocaleUtils.messageSource = messageSource;
    }

    /**
     * 根据当前request对象中的locale(Header的Accept属性)初始化系统国际化语言区域环境
     *
     * @param request  当前请求对象
     * @param response 当前响应对象
     */
    public static void setInitLocale(final HttpServletRequest request, final HttpServletResponse response) {
        final Locale locale = request.getLocale();
        if (localeResolver instanceof CookieLocaleResolver) {
            final CookieLocaleResolver cookieLocaleResolver = (CookieLocaleResolver) localeResolver;
            final Cookie cookie = WebUtils.getCookie(request, cookieLocaleResolver.getCookieName());
            if (cookie == null) {
                setLocale(locale.toLanguageTag(), request, response);
                log.info("CookieLocaleResolver locale from user request,country:{},lang:{}",
                        locale.getCountry(), locale.toLanguageTag());
            }
            return;
        }
        if (localeResolver instanceof SessionLocaleResolver) {
            final Locale sessionLocale = (Locale) WebUtils.getRequiredSessionAttribute(
                    request, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
            if (sessionLocale == null) {
                setLocale(locale.toLanguageTag(), request, response);
                log.info("SessionLocaleResolver locale from user request,country:{},lang:{}",
                        locale.getCountry(), locale.toLanguageTag());
            }
        }
    }

    /**
     * 设置国际化语言区域环境
     *
     * @param lang     国际化语言名称
     * @param request  当前请求对象
     * @param response 当前响应对象
     */
    public static void setLocale(String lang, final HttpServletRequest request, final HttpServletResponse response) {
        lang = StringUtils.defaultIfEmpty(lang, Locale.CHINA.toLanguageTag()).toLowerCase();
        if (StringUtils.containsAny(lang, ENGLISH)) {
            localeResolver.setLocale(request, response, Locale.US);
        } else if (StringUtils.containsAny(lang, CHINA_TW)) {
            localeResolver.setLocale(request, response, Locale.TRADITIONAL_CHINESE);
        } else {
            localeResolver.setLocale(request, response, Locale.CHINA);
        }
    }

    /**
     * 设置国际化语言区域环境
     * 自动判断多请求端(web,android,ios,spider)
     *
     * @param request
     * @param response
     */
    public static void setLocale(final HttpServletRequest request, final HttpServletResponse response) {
        final String userAgent = StringUtils.defaultIfBlank(
                request.getHeader(USER_AGENT), StringUtils.EMPTY).toLowerCase();

        if (StringUtils.containsAny(userAgent, SPIDER, ANDROID, IOS, IPHONE)) {
            setLocale(userAgent, request, response);
        } else {
            setInitLocale(request, response);
        }
    }

    /**
     * @param code 对应messages配置的key.
     * @return String
     */
    public static String getMessage(final String code) {
        return getMessage(code, null);
    }

    /**
     * @param code 对应messages配置的key.
     * @param args 数组参数.
     * @return String
     */
    public static String getMessage(final String code, final Object[] args) {
        return getMessage(code, args, "");
    }

    /**
     * @param code           对应messages配置的key.
     * @param args           数组参数.
     * @param defaultMessage 没有设置key的时候的默认值.
     * @return String
     */
    public static String getMessage(final String code, final Object[] args, final String defaultMessage) {
        final Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, defaultMessage, locale);
    }
}
