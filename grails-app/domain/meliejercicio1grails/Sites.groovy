package meliejercicio1grails

class Sites {
    String name;
    static hasMany = [category:Category]
    static constraints = {
    }
}
