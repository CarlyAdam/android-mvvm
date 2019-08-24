package com.carlyadam.kotlin.ui

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
import com.carlyadam.kotlin.data.api.model.PersonPojo
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.carlyadam.kotlin.ui.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity()  {

    private lateinit var personViewModel: PersonViewModel
    private val personList = ArrayList<PersonPojo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataStore.displayToast()
        personViewModel = ViewModelProviders.of(this, personViewModelFactory).get(PersonViewModel::class.java)
        bindUI()

    }
    private fun bindUI() = Coroutines.main {
         personViewModel!!.getPerson().observe(this, Observer {
             personList.addAll(it)
             initRecyclerView()
        })

    }


    private fun initRecyclerView() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = RecyclerAdapter(personList, this)
    }


}
