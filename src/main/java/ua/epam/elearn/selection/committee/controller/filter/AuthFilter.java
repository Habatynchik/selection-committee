package ua.epam.elearn.selection.committee.controller.filter;

import ua.epam.elearn.selection.committee.controller.FrontControllerServlet;
import ua.epam.elearn.selection.committee.controller.path.UrlPath;
import ua.epam.elearn.selection.committee.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.epam.elearn.selection.committee.controller.path.UrlPath.*;

public class AuthFilter implements Filter {

    private static final String ROLE_ATTRIBUTE = "role";
    private static final String USER_ID_ATTRIBUTE = "userId";

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        final String URI = request.getRequestURI();

        if (session.getAttribute(ROLE_ATTRIBUTE) == null) {
            session.setAttribute(ROLE_ATTRIBUTE, Role.GUEST.toString());
        }

        Role role = Role.valueOf(session.getAttribute(ROLE_ATTRIBUTE).toString());

        /*
        if (!getUriPath().contains(URI)) {
            response.sendError(404);
            return;
        }
*/
/*
        if (!checkResources(URI) && !checkAccess(URI, role)) {
            if (role.equals(Role.GUEST)) {
                response.sendRedirect(LOGIN);
                return;
            }
            response.sendError(403);
            return;
        }
*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean checkAccess(String uri, Role role) {
        switch (role) {
            case CLIENT:
                return checkClientAccess(uri);
            case ADMIN:
                return checkAdminAccess(uri);
            default:
                return checkGuestAccess(uri);
        }
    }

    private boolean checkGuestAccess(String uri) {
        return checkCommonAccess(uri) || uri.equals(LOGIN);
    }

    private boolean checkAdminAccess(String uri) {
        return checkCommonAccess(uri) || uri.equals(LOGOUT) || uri.equals(SUBJECTS) || uri.equals(ADD_FACULTY);
    }

    private boolean checkClientAccess(String uri) {
        return checkCommonAccess(uri) || uri.equals(LOGOUT);
    }

    private boolean checkCommonAccess(String uri) {
        return uri.equals(REGISTRATION) || uri.equals(HOME) || uri.equals(FACULTIES);
    }

    private boolean checkResources(String uri) {
        return uri.equals(STATIC_RESOURCES);
    }

    @Override
    public void destroy() {
    }


    private List<String> getUriPath() {
        List<String> pathList = new ArrayList<>();

        Field[] allFields = UrlPath.class.getDeclaredFields();

        SampleClass sampleObject = new SampleClass();
        sampleObject.setSampleField("data");


        Arrays.stream(allFields).forEach(e -> {
            try {
                pathList.add((String) e.get(sampleObject));
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        });
        return pathList;
    }

    @CustomAnnotation(name = "SampleClass", value = "Sample Class Annotation")
    class SampleClass {

        @CustomAnnotation(name = "sampleClassField", value = "Sample Field Annotation")
        public String sampleField;

        public String getSampleField() {
            return sampleField;
        }

        public void setSampleField(String sampleField) {
            this.sampleField = sampleField;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface CustomAnnotation {
        public String name();

        public String value();
    }
}
