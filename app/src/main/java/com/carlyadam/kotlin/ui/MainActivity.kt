package com.carlyadam.kotlin.ui

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlyadam.kotlin.data.db.Person
import com.carlyadam.kotlin.databinding.ActivityMainBinding
import com.carlyadam.kotlin.ui.adapter.PersonAdapter
import com.carlyadam.kotlin.utilities.Coroutines
import dmax.dialog.SpotsDialog

class MainActivity : BaseActivity(), PersonAdapter.AdapterListener {

    private val personList = ArrayList<Person>()
    private var dialog: AlertDialog? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dialog = SpotsDialog.Builder().setContext(this).build()
        setData()

    }

    private fun setData() = Coroutines.main {
        dialog!!.show()
        personViewModel.getPerson().observe(this, Observer {
            personList.addAll(it)
            initRecyclerView()
            dialog!!.dismiss()
        })

    }

    private fun initRecyclerView() {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = PersonAdapter(personList, this, this)

    }

    override fun onItemTap(position: Int) {
        Toast.makeText(this, personList[position].name, Toast.LENGTH_SHORT).show()
    }


}
