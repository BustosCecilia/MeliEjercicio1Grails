package meliejercicio1grails

import grails.gorm.services.Service

@Service(Sites)
interface SitesService {

    Sites get(Serializable id)

    List<Sites> list(Map args)

    Long count()

    void delete(Serializable id)

    Sites save(Sites sites)

}