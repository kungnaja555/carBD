package buu.informatics.s59160951.carbackdoor

data class Car(
    val id:Int,
    var name:String="",
    var idcar:String="",
    var brand:String="",
    var empty:Boolean=true){

    fun delete(){
        name = "";
        idcar = "";
        brand = "";
        empty = true;
    }
}