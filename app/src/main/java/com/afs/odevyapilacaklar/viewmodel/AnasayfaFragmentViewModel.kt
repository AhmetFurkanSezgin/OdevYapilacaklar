package com.afs.odevyapilacaklar.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.afs.odevyapilacaklar.entity.Yapilacaklar
import com.afs.odevyapilacaklar.repo.YapilacaklarRepository

class AnasayfaFragmentViewModel(application: Application): AndroidViewModel(application) {

    var yapilacaklarListesi = MutableLiveData <List<Yapilacaklar>>()
    val yrepo = YapilacaklarRepository(application)

    init {
        isleriYukle()
        yapilacaklarListesi = yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        yrepo.isAra(aramaKelimesi)
    }
    fun sil(is_id:Int){
        yrepo.isSil(is_id)
    }
    fun isleriYukle(){

        yrepo.tumIsleriAl()
    }
}