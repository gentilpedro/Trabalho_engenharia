package br.com.mm.jfrm.evt.bus;

import br.com.mm.jfrm.evt.persist.ParticipanteInscrito;
import br.com.mm.jfrm.evt.ws.dto.AndaduraAppDTO;
import br.com.mm.jfrm.evt.ws.dto.BayardAppDTO;
import br.com.mm.jfrm.evt.ws.dto.CampoAppDTO;
import br.com.mm.jfrm.evt.ws.dto.FiguraAppDTO;
import br.com.mm.jfrm.evt.ws.dto.MangueiraAppDTO;
import br.com.mm.jfrm.evt.ws.dto.MorfologiaAppDTO;
import br.com.mm.jfrm.evt.ws.dto.VspEsbarradaAppDTO;
import br.com.mm.jfrm.kernel.bus.IBusJFRM;
import br.com.mm.jfrm.sin.ws.persist.SinEtapa;
import jakarta.ejb.Local;

@Local
public interface BusBuscaNotasLocal<E> extends IBusJFRM<E> {
    MorfologiaAppDTO getMorfologia(ParticipanteInscrito participanteInscrito);

    AndaduraAppDTO getAndadura(ParticipanteInscrito participanteInscrito);

    FiguraAppDTO getFigura(ParticipanteInscrito participanteInscrito);

    VspEsbarradaAppDTO getVSPE(ParticipanteInscrito participanteInscrito);

    MangueiraAppDTO getMangueira(ParticipanteInscrito participanteInscrito,
                                 SinEtapa.EtapaEnum etapaEnum);

    CampoAppDTO getCampo(ParticipanteInscrito participanteInscrito, SinEtapa.EtapaEnum etapaEnum);

    BayardAppDTO getBayard(ParticipanteInscrito participanteInscrito);
}
