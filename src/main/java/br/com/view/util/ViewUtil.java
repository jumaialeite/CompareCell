package br.com.view.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 * @author juliana
 */
public class ViewUtil {

    public static void addMessage(UIComponent component, String message, Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context != null && context.getViewRoot() != null && context.getViewRoot().getLocale() != null) {
            if (component != null) {
                context.addMessage(component.getClientId(context), new FacesMessage(severity, message, null));
            } else {
                context.addMessage(null, new FacesMessage(severity, message, null));
            }
        } else {
            System.err.println("Contexto ou locale nulo em BeanUtil.addMessage()");
        }
    }

    public static void addErrorMessage(UIComponent component, String message) {
        addMessage(component, message, FacesMessage.SEVERITY_ERROR);
    }

    public static void addInfoMessage(UIComponent component, String message) {
        addMessage(component, message, FacesMessage.SEVERITY_INFO);
    }

    public static void addFatalMessage(UIComponent component, String message) {
        addMessage(component, message, FacesMessage.SEVERITY_FATAL);
    }

    public static void addWarnMessage(UIComponent component, String message) {
        addMessage(component, message, FacesMessage.SEVERITY_WARN);
    }

    @SuppressWarnings("rawtypes")
	public static Object getManagedBean(String beanName, Class beanClass) {
        Object bean = null;
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            bean = context.getApplication().getExpressionFactory()
                    .createValueExpression(context.getELContext(), "#{" + beanName + "}", beanClass).getValue(context.getELContext());
        }
        return bean;
    }

    public static void handleNavigation(String outcome, FacesContext localContext) {
        try {
            NavigationHandler nh = localContext.getApplication().getNavigationHandler();
            nh.handleNavigation(localContext, null, outcome);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
