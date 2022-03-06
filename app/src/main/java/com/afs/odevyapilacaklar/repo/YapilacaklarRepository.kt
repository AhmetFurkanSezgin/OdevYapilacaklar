package com.afs.odevyapilacaklar.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.afs.odevyapilacaklar.entity.Yapilacaklar
import com.afs.odevyapilacaklar.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarRepository(var application: Application) {
    var yapilacaklarListesi:MutableLiveData<List<Yapilacaklar>>
    var vt:Veritabani
    init {
        yapilacaklarListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacaklar>>{
        return yapilacaklarListesi
    }

    fun isKayit (yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
val yeniIs = Yapilacaklar(0,yapilacak_is)
            vt.yapilacaklarDao().isEkle(yeniIs)
        }
    }

    fun isGuncelle(is_id:Int,is_yapilacak:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Yapilacaklar(is_id,is_yapilacak)
            vt.yapilacaklarDao().isGuncelle(guncellenenIs)
        }
    }
    fun isAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {

            yapilacaklarListesi.value=vt.yapilacaklarDao().isArama(aramaKelimesi)
        }

    }
    fun isSil(is_id:Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenIs = Yapilacaklar(is_id, "")
            vt.yapilacaklarDao().isSil(silinenIs)
            tumIsleriAl ()

        }
    }
    fun tumIsleriAl (){
        val job = CoroutineScope(Dispatchers.Main).launch {

            yapilacaklarListesi.value=vt.yapilacaklarDao().tumYapilacaklar()
        }
    }
}