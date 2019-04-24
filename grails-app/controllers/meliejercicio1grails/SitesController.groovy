package meliejercicio1grails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SitesController {

    SitesService sitesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sitesService.list(params), model:[sitesCount: sitesService.count()]
    }

    def show(Long id) {
        respond sitesService.get(id)
    }

    def create() {
        respond new Sites(params)
    }

    def save(Sites sites) {
        if (sites == null) {
            notFound()
            return
        }

        try {
            sitesService.save(sites)
        } catch (ValidationException e) {
            respond sites.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sites.label', default: 'Sites'), sites.id])
                redirect sites
            }
            '*' { respond sites, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sitesService.get(id)
    }

    def update(Sites sites) {
        if (sites == null) {
            notFound()
            return
        }

        try {
            sitesService.save(sites)
        } catch (ValidationException e) {
            respond sites.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sites.label', default: 'Sites'), sites.id])
                redirect sites
            }
            '*'{ respond sites, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sitesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sites.label', default: 'Sites'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sites.label', default: 'Sites'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
