package com.example.classwork

import com.google.gson.Gson
import org.hamcrest.core.Is.`is`
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class SharedPrefManagerTest {

    var sharedPref=HashMap<String,String>()
    var gson=Gson()
    @Before
    fun setUp(){
        sharedPref["camera"] = "video_camera"
        sharedPref["picture"] = "something"


    }

    @Test
    fun clearData_shouldClearData() {
        //WHEN
        var sharedPredObj=SharedPrefManager(sharedPref)
        var isCleared=sharedPredObj.clearData()

        //THEN
        assertThat(isCleared,`is`(sharedPref.clear()))
    }

    @Test
    fun saveData_acceptUserAndKey_returnArrayList() {
        var result=ArrayList<String>()
        var key="cameral"
        var prefs=SharedPrefManager(sharedPref)
        var user=User("king","izundu","emeka","dev","080604","blablabla")
        var jsonUser=prefs.gson.toJson(user)
        result.add(jsonUser)
        sharedPref[key]=jsonUser

        assertThat(prefs.saveData(user,key),`is`(result))


    }

    @Test
    fun keepData() {
        var prefs=SharedPrefManager(sharedPref)
        var user=User("king","izundu","emeka","dev","080604","blablabla")
        var key="camera"

        var jsonUser=prefs.gson.toJson(user,User::class.java)
        sharedPref[key]=jsonUser
    }

    @Test
    fun getUserData_() {
        var prefs=SharedPrefManager(sharedPref)
        var word=""
        var wordJson=prefs.gson.toJson(word)
        var jsonUser=prefs.gson.fromJson(word,User::class.java)
        assertThat(prefs.getUserData(word),`is`(jsonUser))
    }

    @Test
    fun checkUser_keyIsString_returnGetUserDataWithEmptyParameter() {
        var prefs=SharedPrefManager(sharedPref)
        var key="camera"
        var emptyUser=""
        var jsonUser=prefs.gson.fromJson(emptyUser,User::class.java)

        assertThat(prefs.checkUser(key),`is`(jsonUser))
    }

    @Test
    fun clearByKey_shouldClearHashMapByKey() {
        var prefs=SharedPrefManager(sharedPref)
        assertEquals(prefs.clearByKey("camera"),true)
    }

    @Test
    fun getSharedPrefs() {

    }

    @Test
    fun getGson() {

    }

}