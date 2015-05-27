
package tr.gov.ptt.gr2kisitelyeni.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JSFUtil {
    
    public static void mesajekle(String mesaj){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    mesaj, mesaj));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
}
