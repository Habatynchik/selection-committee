package ua.epam.elearn.selection.committee.controller.tags;

import ua.epam.elearn.selection.committee.model.entity.Subject;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SubjectLanguageTag extends SimpleTagSupport {

    private Subject subject;

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        if (getJspContext().findAttribute("lang").equals("uk")) {
            out.write(subject.getNameUk());
        } else if (getJspContext().findAttribute("lang").equals("ru")) {
            out.write(subject.getNameRu());
        } else {
            out.write(subject.getNameEn());
        }

    }
}
