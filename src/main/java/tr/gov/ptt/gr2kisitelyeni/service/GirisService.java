package tr.gov.ptt.gr2kisitelyeni.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2kisitelyeni.entity.Giris;
import tr.gov.ptt.gr2kisitelyeni.facade.GirisFacade;

@Stateless
public class GirisService {
   @EJB
   private GirisFacade girisFacade;
   
   public boolean girisKontrol(Giris p_giris){
    
       boolean sonuc = girisFacade.girisKontrol(p_giris);
       return sonuc;
   }
   
    
}
