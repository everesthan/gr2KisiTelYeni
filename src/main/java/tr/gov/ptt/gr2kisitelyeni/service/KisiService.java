package tr.gov.ptt.gr2kisitelyeni.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2kisitelyeni.entity.Kisi;
import tr.gov.ptt.gr2kisitelyeni.facade.KisiFacade;

@Stateless
public class KisiService {
    @EJB
    private KisiFacade kisiFacade;
    
    public void kisiEkle(Kisi p_kisi){
       
        kisiFacade.create(p_kisi);
        
    
    }
}
