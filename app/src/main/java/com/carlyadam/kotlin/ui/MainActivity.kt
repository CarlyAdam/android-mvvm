package com.carlyadam.kotlin.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.carlyadam.kotlin.R
import com.carlyadam.kotlin.utilities.Coroutines
import com.carlyadam.kotlin.viewmodel.PersonViewModel
import com.carlyadam.kotlin.viewmodel.PersonViewModelFactory
import androidx.core.app.NotificationCompat.getCategory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.carlyadam.kotlin.data.db.Person
import com.carlyadam.kotlin.ui.adapter.PersonAdapter
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity()  {

    private lateinit var personViewModel: PersonViewModel
    private val personList = ArrayList<Person>()
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialog = SpotsDialog.Builder().setContext(this).build()
        personViewModel = ViewModelProviders.of(this, personViewModelFactory).get(PersonViewModel::class.java)
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
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = PersonAdapter(personList, this)
    }



}
