package tr.gov.ptt.gr2kisitelyeni.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import tr.gov.ptt.gr2kisitelyeni.entity.Kisi;
import tr.gov.ptt.gr2kisitelyeni.entity.Telefon;
import tr.gov.ptt.gr2kisitelyeni.service.KisiService;
import tr.gov.ptt.gr2kisitelyeni.util.JSFUtil;

@ManagedBean
@RequestScoped
public class KisiBean {
    
    private Kisi kisi;
    @EJB
    
    private KisiService kisiService;
    private Telefon evTel ;
    private Telefon cepTel;
    private List<Kisi> kisiListe;

    public KisiBean() {
      kisi= new Kisi();
      evTel = new Telefon();
      cepTel = new Telefon();
      kisiListe = new ArrayList<Kisi>();
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Telefon getEvTel() {
        return evTel;
    }

    public void setEvTel(Telefon evTel) {
        this.evTel = evTel;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }

    public List<Kisi> getKisiListe() {
        kisiListe = kisiService.kisiListele();
        return kisiListe;
    }

    public void setKisiListe(List<Kisi> kisiListe) {
        this.kisiListe = kisiListe;
    }
    
    
    public String kisiEkle(){
        
     
        List<Telefon> telList = new ArrayList(); 
        telList.add(evTel);
        telList.add(cepTel);
        
        kisi.setTelefonList(telList);
        evTel.setKisi(kisi);
        cepTel.setKisi(kisi);
        kisiService.kisiEkle(kisi);
        
         JSFUtil.mesajekle("Kişi Eklendi.");
        return "kisiListele.xhtml?faces-redirect=true";
    }
    
    public String listele(){
         return "kisiListele.xhtml?faces-redirect=true";
    }
    
}
