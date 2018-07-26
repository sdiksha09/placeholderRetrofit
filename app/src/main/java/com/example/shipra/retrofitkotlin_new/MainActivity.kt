package com.example.shipra.retrofitkotlin_new

import android.appwidget.AppWidgetProviderInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.shipra.retrofitkotlin_new.Retrofit.API
import com.example.shipra.retrofitkotlin_new.Retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.supercharge.shimmerlayout.ShimmerLayout
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import com.example.shipra.retrofitkotlin_new.model.model
import com.example.shipra.retrofitkotlin_new.adapter.MyAdapter

class MainActivity : AppCompatActivity() {

    lateinit var api: API
    var compositeDisposable=CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit: Retrofit = RetrofitClient.instance
        api = retrofit.create(API::class.java)


        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData() {
        shimmerLauout.startShimmerAnimation()
        compositeDisposable.add(api.data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{photos->displayData(photos)})


    }

    private fun displayData(photos: List<model>?) {

        val adapter = MyAdapter(this,photos!!)
        recycler_view.adapter=adapter
        shimmerLauout.stopShimmerAnimation()
        shimmerLauout.visibility= View.GONE


    }

    override  fun onStop(){
        compositeDisposable.clear()
        super.onStop()
    }


}