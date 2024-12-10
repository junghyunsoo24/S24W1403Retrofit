package kr.ac.kumoh.s20191091.s24w1403retrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongViewModel : ViewModel() {
    private var songApi: SongApi
    private val _songList = MutableLiveData<List<Song>>()
    val songList: LiveData<List<Song>>
        get() = _songList

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(SongApiConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        songApi = retrofit.create(SongApi::class.java)
        fetchData()
    }

    private fun fetchData() {
        // Coroutine 사용
        viewModelScope.launch {
            try {
                val response = songApi.getSongs()//비동기로 진행
                _songList.value = response
            } catch(e: Exception) {
                Log.e("fetchData()", e.toString())
            }
        }//멀티스레드 개념과 유사?
    }
}