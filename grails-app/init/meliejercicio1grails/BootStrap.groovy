package meliejercicio1grails
import grails.util.Environment
class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            // insert Development environment specific code here
            def site= new Sites(name:"MLA").save()
        } else
        if (Environment.current == Environment.TEST) {
            // insert Test environment specific code here
        } else
        if (Environment.current == Environment.PRODUCTION) {
            // insert Production environment specific code here
        }
    }
    def destroy = {
    }
}
