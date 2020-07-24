package com.example.projet.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "pays")
data class Pays(
            var abr : String,
            var nom:String,
            var capital:String,
            var description:String,
            var surface:Long,
            var population:Long,
            var historique:List<Historique>,
            var ressources:List<Ressources>,
            var drapeau: Int,
            var images:List<Int>,
            var hymne:Int
            ) :Serializable{
    @PrimaryKey(autoGenerate = true)
    var id:Int=0

}