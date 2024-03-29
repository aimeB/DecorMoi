package com.decormoi.app.security;

/**
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    public static final String ADMIN = "ROLE_ADMIN";

    public static final String USER = "ROLE_USER";

    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    public static final String AGENT = "ROLE_AGENT";

    public static final String VISITOR = "ROLE_VISITOR";

    private AuthoritiesConstants() {

    }

}
