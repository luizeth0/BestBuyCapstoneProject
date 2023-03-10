package com.capstoneproject.bestbuy.view.ui

import android.Manifest
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.capstoneproject.bestbuy.databinding.FragmentMapsBinding
import com.capstoneproject.bestbuy.model.domain.StoreDomain
import com.capstoneproject.bestbuy.utils.UIState
import com.capstoneproject.bestbuy.utils.ViewType
import com.capstoneproject.bestbuy.view.adapter.BestBuyAdapter
import com.capstoneproject.bestbuy.viewmodel.BestBuyViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var maps: GoogleMap
    private lateinit var mapView: MapView

    private var listLocation = ArrayList<LatLng>()
    private var listNameStore = ArrayList<String>()


    private val binding by lazy {
        FragmentMapsBinding.inflate(layoutInflater)
    }

    private val storeAdapter by lazy {
        BestBuyAdapter {

            Log.d(TAG, "Item: $it")

        }
    }

    private val bestBuyViewModel by lazy {
        ViewModelProvider(requireActivity())[BestBuyViewModel::class.java]
    }

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocationServices.getFusedLocationProviderClient(requireActivity()).also {
            fusedLocationClient = it
        }





    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mapView = binding.maps
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        binding.rvStores.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2
            )
            adapter = storeAdapter
        }



        return binding.root
    }

    private fun getPermission(){
        if ((ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) )  {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION_PERMISSION)
            return getPermission()
        } else {
            fusedLocationClient.lastLocation
                .addOnSuccessListener {
                    it?.let {
                        maps.isMyLocationEnabled = true
                        bestBuyViewModel.coordinates = LatLng(it.latitude,it.longitude)
                        getLocation(it)

                    }
                }

        }
    }

    private fun getLocation(loc: Location) {
        val latitude = loc.latitude
        val longitude = loc.longitude
        Log.d(TAG, "Location is: $latitude + $longitude")
        bestBuyViewModel.getStores()
        maps.clear()
        maps.mapType = GoogleMap.MAP_TYPE_NORMAL
        maps.uiSettings.isZoomControlsEnabled = true
        maps.addMarker(MarkerOptions().position(LatLng(latitude,longitude)).title("You're here!🙋🏻‍♂️"))
        maps.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    latitude,
                    longitude
                ), 8.0f
            )
        )
        getStores()

        listLocation.forEach{
            //maps.addMarker(MarkerOptions().position(LatLng(it.latitude,it.longitude)))
            Log.d(TAG, "ubicacionesasdf: $it")
        }
    }

    private fun getStores() {
        bestBuyViewModel.stores.observe(viewLifecycleOwner) { state ->
            val viewTypeList: MutableList<ViewType> = mutableListOf()
            when(state) {
                is UIState.LOADING -> {}
                is UIState.SUCCESS<List<StoreDomain>> -> {
                    state.response.forEach {
                        viewTypeList.add(ViewType.STORE(it))
                        listLocation.add(LatLng(it.lat,it.lng))
                        Log.d(TAG, "ubicaciones: $listLocation")
                        listNameStore.add(it.name)
                        maps.addMarker(MarkerOptions().position(LatLng(it.lat, it.lng)).title("${it.name} 🏪"))

                    }
                    Log.d(TAG, "getStoresFrag: $state")
                    storeAdapter.updateItems(viewTypeList)
                }
                is UIState.ERROR -> {
                    state.error.localizedMessage?.let {
                        throw Exception("Error: $state")
                    }
                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        maps = googleMap
        getPermission()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}