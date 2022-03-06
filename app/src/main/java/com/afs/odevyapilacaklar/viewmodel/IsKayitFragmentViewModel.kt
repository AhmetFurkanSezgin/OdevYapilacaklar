package com.afs.odevyapilacaklar.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.afs.odevyapilacaklar.repo.YapilacaklarRepository

class IsKayitFragmentViewModel(application: Application) : AndroidViewModel(application) {

   val yrepo = YapilacaklarRepository(application)

    fun kayit (yapilacak_is:String){
        yrepo.isKayit(yapilacak_is)

    }
}