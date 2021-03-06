package com.afs.odevyapilacaklar.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.afs.odevyapilacaklar.databinding.CardTasarimBinding
import com.afs.odevyapilacaklar.entity.Yapilacaklar
import com.afs.odevyapilacaklar.fragment.AnasayfaFragmentDirections
import com.afs.odevyapilacaklar.viewmodel.AnasayfaFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext:Context,var yapilacaklarListesi:List<Yapilacaklar>,var viewModel:AnasayfaFragmentViewModel) :
    RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu (tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
         val yapilacak =yapilacaklarListesi.get(position)
         val t = holder.tasarim

        t.yapilacakNesnesi = yapilacak
        t.satirCard.setOnClickListener {

            val gecis = AnasayfaFragmentDirections.isDetayGecis(isler = yapilacak )
            Navigation.findNavController(it).navigate(gecis)

        }
        t.imageViewSilResim.setOnClickListener {
            Snackbar.make(it,"${yapilacak.is_yapilacak} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){ viewModel.sil(yapilacak.is_id) }.show()

        }
    }

    override fun getItemCount(): Int {
       return  yapilacaklarListesi.size
    }

}