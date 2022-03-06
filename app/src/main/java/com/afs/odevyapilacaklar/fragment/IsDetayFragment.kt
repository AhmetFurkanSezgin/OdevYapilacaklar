package com.afs.odevyapilacaklar.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.afs.odevyapilacaklar.R
import com.afs.odevyapilacaklar.databinding.FragmentIsDetayBinding
import com.afs.odevyapilacaklar.viewmodel.IsDetayFragmentViewModel
import com.afs.odevyapilacaklar.viewmodel.IsDetayVMF


class IsDetayFragment : Fragment() {

private lateinit var tasarim:FragmentIsDetayBinding
private lateinit var viewModel:IsDetayFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_is_detay, container, false)
          tasarim.isDetayFragment = this
        tasarim.isDetayToolbarBaslik = "Yapılacak İş Detay"

        val bundle:IsDetayFragmentArgs by navArgs()
        val gelenIs = bundle.isler

        tasarim.isNesnesi = gelenIs

        return tasarim.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : IsDetayFragmentViewModel by viewModels(){
            IsDetayVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }
    fun buttonGuncelleTikla(is_id:Int,is_yapilacak:String){
        viewModel.guncelle(is_id,is_yapilacak)

    }
}