package tr.gov.ptt.gr2kisitelyeni.bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import tr.gov.ptt.gr2kisitelyeni.entity.Giris;
import tr.gov.ptt.gr2kisitelyeni.service.GirisService;

@ManagedBean
@RequestScoped
public class GirisBean {
    private Giris giris;
    
    @EJB
    private GirisService girisService;
    
    public GirisBean() {
       giris = new Giris();
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    public String girisKontrol(){
       boolean sonuc = girisService.girisKontrol(giris);
        if (sonuc) {
            FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Giriş başarılı","Giriş başarılı"));
            FacesContext.getCurrentInstance().getExternalContext()
                    .getFlash().setKeepMessages(true);
            return "menu.xhtml?faces-redirect=true"  ;
        } else {
             FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Kullanıcı adı ya da sifre yanlış!","Kullanıcı adı ya da sifre yanlış!"));
            FacesContext.getCurrentInstance().getExternalContext()
                    .getFlash().setKeepMessages(true);
            
            return "giris.xhtml?faces-redirect=true"  ;
        }
         
        
    }
    
}
