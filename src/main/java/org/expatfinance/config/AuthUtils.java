package org.expatfinance.config;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {

    private AuthUtils() {}

    /**
     * Returns the Firebase UID of the authenticated user.
     * Call this at the start of every service method that touches user data.
     */
    public static String getCurrentUserId() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("No authenticated user in SecurityContext");
        }
        return (String) authentication.getPrincipal();
    }
}