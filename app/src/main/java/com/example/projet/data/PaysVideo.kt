package com.example.projet.data


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.projet.data.Pays

@Entity(tableName = "PaysVideo",
    foreignKeys = [ForeignKey(
        entity = Pays::class,
        parentColumns = arrayOf("codePays"),
        childColumns = arrayOf("codePays"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class PaysVideo (@PrimaryKey val idPaysVideo: String,
                      val title : String,
                      val codePays : String) {}