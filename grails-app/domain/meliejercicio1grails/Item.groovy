package meliejercicio1grails

class Item {
    String title;
    String subtitle;
    float price;
    String imagenUrl;
    static belongsTo = [category:Category]
    static constraints = {
    }
}
