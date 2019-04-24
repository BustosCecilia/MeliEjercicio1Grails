package meliejercicio1grails

class Category {
    String name;
    static hasMany = [item:Item]
    static belongsTo = [site:Sites]
    static constraints = {
    }
}
