package br.com.mm.jfrm.evt.bus;

import br.com.mm.jfrm.evt.persist.ItemInscricao;
import br.com.mm.jfrm.evt.persist.JuradoAgendamento;
import br.com.mm.jfrm.evt.persist.ParticipanteInscrito;
import br.com.mm.jfrm.evt.ws.dto.AndaduraAppDTO;
import br.com.mm.jfrm.evt.ws.dto.BayardAppDTO;
import br.com.mm.jfrm.evt.ws.dto.CampoAppDTO;
import br.com.mm.jfrm.evt.ws.dto.FiguraAppDTO;
import br.com.mm.jfrm.evt.ws.dto.MangueiraAppDTO;
import br.com.mm.jfrm.evt.ws.dto.MorfologiaAppDTO;
import br.com.mm.jfrm.evt.ws.dto.VspEsbarradaAppDTO;
import br.com.mm.jfrm.kernel.bus.BusJFRMBean;
import br.com.mm.jfrm.kernel.persist.QueryParameters;
import br.com.mm.jfrm.kernel.persist.QueryType;
import br.com.mm.jfrm.sin.ws.persist.SinAvaliacao;
import br.com.mm.jfrm.sin.ws.persist.SinEtapa;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaAnd;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaBayard;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaCampo;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaFigura;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaMang;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaMorfologia;
import br.com.mm.jfrm.sin.ws.persist.SinEtapaVSPE;
import jakarta.ejb.Stateless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class BusBuscaNotasBean<E> extends BusJFRMBean<E> implements BusBuscaNotasLocal<E> {

    @Override
    public MorfologiaAppDTO getMorfologia(ParticipanteInscrito participanteInscrito) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return MorfologiaAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaMorfologia> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream()
                        .filter(sinEtapa -> sinEtapa instanceof SinEtapaMorfologia)
                        .map(SinEtapaMorfologia.class::cast).findFirst().ifPresent(
                        etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new MorfologiaAppDTO(etapasJurado);
    }

    @Override
    public AndaduraAppDTO getAndadura(ParticipanteInscrito participanteInscrito) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return AndaduraAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaAnd> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream().filter(sinEtapa -> sinEtapa instanceof SinEtapaAnd)
                        .map(SinEtapaAnd.class::cast).findFirst().ifPresent(
                        etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new AndaduraAppDTO(etapasJurado);
    }

    @Override
    public FiguraAppDTO getFigura(ParticipanteInscrito participanteInscrito) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return FiguraAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaFigura> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream()
                        .filter(sinEtapa -> sinEtapa instanceof SinEtapaFigura)
                        .map(SinEtapaFigura.class::cast).findFirst().ifPresent(
                        etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new FiguraAppDTO(etapasJurado);
    }

    @Override
    public VspEsbarradaAppDTO getVSPE(ParticipanteInscrito participanteInscrito) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return VspEsbarradaAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaVSPE> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream().filter(sinEtapa -> sinEtapa instanceof SinEtapaVSPE)
                        .map(SinEtapaVSPE.class::cast).findFirst().ifPresent(
                        etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new VspEsbarradaAppDTO(etapasJurado);
    }

    @Override
    public MangueiraAppDTO getMangueira(ParticipanteInscrito participanteInscrito,
            SinEtapa.EtapaEnum etapaEnum) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return MangueiraAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaMang> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream()
                        .filter(sinEtapa -> sinEtapa instanceof SinEtapaMang && sinEtapa.
                        getEtapaEnum() == etapaEnum).map(SinEtapaMang.class::cast)
                        .findFirst().ifPresent(
                                etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new MangueiraAppDTO(etapasJurado);
    }

    @Override
    public CampoAppDTO getCampo(ParticipanteInscrito participanteInscrito,
            SinEtapa.EtapaEnum etapaEnum) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return CampoAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaCampo> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream()
                        .filter(sinEtapa -> sinEtapa instanceof SinEtapaCampo && sinEtapa.
                        getEtapaEnum() == etapaEnum).map(SinEtapaCampo.class::cast)
                        .findFirst().ifPresent(
                                etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new CampoAppDTO(etapasJurado);
    }

    @Override
    public BayardAppDTO getBayard(ParticipanteInscrito participanteInscrito) {
        ItemInscricao itemInscricao = findItemInscricaoByParticipante(participanteInscrito);
        if (itemInscricao == null) {
            return BayardAppDTO.falha("Item de inscrição não encontrado!");
        }
        List<SinAvaliacao> avaliacoes = getAvaliacoesByItem(itemInscricao);
        Map<JuradoAgendamento.Posicao, SinEtapaBayard> etapasJurado = new HashMap<>();
        avaliacoes.forEach(avaliacao -> {
            if (avaliacao.getJurado() != null) {
                avaliacao.getEtapas().stream()
                        .filter(sinEtapa -> sinEtapa instanceof SinEtapaBayard)
                        .map(SinEtapaBayard.class::cast).findFirst().ifPresent(
                        etapa -> etapasJurado.put(avaliacao.getJurado().getPosicao(), etapa));
            }
        });
        if (etapasJurado.isEmpty()) {
            return null;
        }
        return new BayardAppDTO(etapasJurado);
    }

    private ItemInscricao findItemInscricaoByParticipante(
            ParticipanteInscrito participanteInscrito) {
        QueryParameters qp = new QueryParameters(
                "select ii from ItemInscricao ii inner join ii.participantes p "
                + "where p.idRepli = :idRepli", QueryType.DYNAMIC,
                QueryParameters.PagingType.NOCOUNT_NORANGE);
        qp.add("idRepli", participanteInscrito.getIdRepli());
        return (ItemInscricao) this.findSingleResult(qp);
    }

    private List<SinAvaliacao> getAvaliacoesByItem(ItemInscricao itemInscricao) {
        QueryParameters qp = new QueryParameters(
                "select a from SinAvaliacao a where a.itemInscricao = :itemInscricao",
                QueryType.DYNAMIC, QueryParameters.PagingType.NOCOUNT_NORANGE);
        qp.add("itemInscricao", itemInscricao);
        return (List<SinAvaliacao>) this.find(qp).getResultList();
    }
}
