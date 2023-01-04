package si.rsvo.izdelki.services.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import org.eclipse.microprofile.metrics.annotation.Timed;
import si.rsvo.izdelki.lib.izdelkiMetadata;
import si.rsvo.izdelki.models.converters.izdelkiMetadataConverter;
import si.rsvo.izdelki.models.entities.izdelkiMetadataEntity;


@RequestScoped
public class izdelkiMetadataBean {

    private Logger log = Logger.getLogger(izdelkiMetadataBean.class.getName());

    @Inject
    private EntityManager em;

    public List<izdelkiMetadata> getizdelkiMetadata() {

        TypedQuery<izdelkiMetadataEntity> query = em.createNamedQuery(
                "izdelkiMetadataEntity.getAll", izdelkiMetadataEntity.class);

        List<izdelkiMetadataEntity> resultList = query.getResultList();

        return resultList.stream().map(izdelkiMetadataConverter::toDto).collect(Collectors.toList());

    }

    public izdelkiMetadata getIzdelekById(Integer id) {

        izdelkiMetadataEntity izdelkiMetadataEntity = em.find(izdelkiMetadataEntity.class, id);

        if (izdelkiMetadataEntity == null) {
            throw new NotFoundException();
        }

        izdelkiMetadata izdelek = izdelkiMetadataConverter.toDto(izdelkiMetadataEntity);

        return izdelek;
    }


    @Timed
    public List<izdelkiMetadata> getNazivByNaziv(String naziv) {

        TypedQuery<izdelkiMetadataEntity> query = em.createNamedQuery(
                "izdelkiMetadataEntity.getByNaziv", izdelkiMetadataEntity.class);

        query.setParameter("izdelekNaziv", naziv);

        List<izdelkiMetadataEntity> resultList = query.getResultList();

        System.out.println("resultList: ");
        for(izdelkiMetadataEntity t : resultList) {
            System.out.println(t.getId());
            System.out.println(t.getNaziv());
            System.out.println(t.getCena());
            System.out.println(t.getTrgovina());
            System.out.println(t.getOcena());
            System.out.println(t.getTip());
        }

        return resultList.stream().map(izdelkiMetadataConverter::toDto).collect(Collectors.toList());

    }

    @Timed
    public List<izdelkiMetadata> getTrgovinaByTrgovina(String trgovina) {

        TypedQuery<izdelkiMetadataEntity> query = em.createNamedQuery(
                "izdelkiMetadataEntity.getByTrgovina", izdelkiMetadataEntity.class);

        query.setParameter("izdelekTrgovina", trgovina);

        List<izdelkiMetadataEntity> resultList = query.getResultList();

        System.out.println("resultList: ");
        for(izdelkiMetadataEntity up : resultList) {
            System.out.println(up.getId());
            System.out.println(up.getNaziv());
            System.out.println(up.getCena());
            System.out.println(up.getTrgovina());
            System.out.println(up.getOcena());
            System.out.println(up.getTip());
        }

        return resultList.stream().map(izdelkiMetadataConverter::toDto).collect(Collectors.toList());

    }

    @Timed
    public List<izdelkiMetadata> getTipByTip(String tip) {

        TypedQuery<izdelkiMetadataEntity> query = em.createNamedQuery(
                "izdelkiMetadataEntity.getByTip", izdelkiMetadataEntity.class);

        query.setParameter("izdelekTip", tip);

        List<izdelkiMetadataEntity> resultList = query.getResultList();

        System.out.println("resultList: ");
        for(izdelkiMetadataEntity cm : resultList) {
            System.out.println(cm.getId());
            System.out.println(cm.getNaziv());
            System.out.println(cm.getCena());
            System.out.println(cm.getTrgovina());
            System.out.println(cm.getOcena());
            System.out.println(cm.getTip());
        }

        return resultList.stream().map(izdelkiMetadataConverter::toDto).collect(Collectors.toList());

    }


    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}
