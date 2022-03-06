package com.afs.odevyapilacaklar.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklar")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name= "is_id") @NotNull var is_id:Int,
                   @ColumnInfo(name= "is_yapilacak") @NotNull var is_yapilacak:String) : Serializable {
}