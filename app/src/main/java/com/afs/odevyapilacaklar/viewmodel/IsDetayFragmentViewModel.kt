package com.afs.odevyapilacaklar.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.afs.odevyapilacaklar.repo.YapilacaklarRepository

class IsDetayFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val yrepo = YapilacaklarRepository(application)

    fun guncelle(is_id:Int,is_yapilacak:String){
        yrepo.isGuncelle(is_id,is_yapilacak)
    }
}