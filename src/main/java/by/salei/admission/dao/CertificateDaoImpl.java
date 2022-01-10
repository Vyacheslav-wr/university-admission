package by.salei.admission.dao;

import by.salei.admission.dao.api.CertificateDao;
import by.salei.admission.entity.Certificate;
import org.springframework.stereotype.Repository;

@Repository
public class CertificateDaoImpl extends AbstractDao<Certificate> implements CertificateDao {
    @Override
    protected Class<Certificate> getEntityClass() {
        return Certificate.class;
    }
}
