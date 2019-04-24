package meliejercicio1grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SitesServiceSpec extends Specification {

    SitesService sitesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Sites(...).save(flush: true, failOnError: true)
        //new Sites(...).save(flush: true, failOnError: true)
        //Sites sites = new Sites(...).save(flush: true, failOnError: true)
        //new Sites(...).save(flush: true, failOnError: true)
        //new Sites(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sites.id
    }

    void "test get"() {
        setupData()

        expect:
        sitesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Sites> sitesList = sitesService.list(max: 2, offset: 2)

        then:
        sitesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sitesService.count() == 5
    }

    void "test delete"() {
        Long sitesId = setupData()

        expect:
        sitesService.count() == 5

        when:
        sitesService.delete(sitesId)
        sessionFactory.currentSession.flush()

        then:
        sitesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Sites sites = new Sites()
        sitesService.save(sites)

        then:
        sites.id != null
    }
}
