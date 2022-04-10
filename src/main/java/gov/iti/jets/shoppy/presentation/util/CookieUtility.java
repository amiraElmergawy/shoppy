package gov.iti.jets.shoppy.presentation.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;

public enum CookieUtility {
    INSTANCE;
    public Optional<Cookie> readUIDCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("UID"))
                    return Optional.of(cookie);
            }
        }
        return Optional.empty();
    }

    public void addUIDToken(Integer uid, HttpServletResponse response) {
        Cookie cookie = new Cookie("UID", uid + "");
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
    }

    public void removeUIDToken(HttpServletRequest request, HttpServletResponse response) {
        Optional<Cookie> cookie = readUIDCookie(request);
        cookie.ifPresent(cookie1 -> {
            cookie1.setMaxAge(0);
            response.addCookie(cookie1);
        });
    }
}
