package org.ocandroid.navigationdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import kotlinx.android.synthetic.main.fragment_item_details.view.*

class ItemDetailsFragment : Fragment() {

    private val args: ItemDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_details, container, false)
        view.item_number.text = args.itemId
        return view
    }
}
