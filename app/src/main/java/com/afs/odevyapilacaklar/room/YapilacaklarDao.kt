package com.afs.odevyapilacaklar.room

import androidx.room.*
import com.afs.odevyapilacaklar.entity.Yapilacaklar


@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar() : List<Yapilacaklar>
    @Insert
    suspend fun isEkle(isler:Yapilacaklar)
    @Update
    suspend fun  isGuncelle(isler: Yapilacaklar)
    @Delete
    suspend fun  isSil(isler: Yapilacaklar)
    @Query("SELECT * FROM yapilacaklar WHERE is_yapilacak like '%'|| :aramaKelimesi ||'%'")
    suspend fun isArama(aramaKelimesi:String) : List<Yapilacaklar>
}