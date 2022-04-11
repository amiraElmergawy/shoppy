package gov.iti.jets.shoppy.presentation.util;

import gov.iti.jets.shoppy.presentation.helpers.LoginViewHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public enum SessionManager {
    INSTANCE;

    public void createSession(HttpServletRequest request, LoginViewHelper loginViewHelper) {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("userRole", loginViewHelper.getRole());
        httpSession.setAttribute("userEmail", loginViewHelper.getEmail());
        httpSession.setAttribute("userId", loginViewHelper.getId());
    }
}
