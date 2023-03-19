package com.satriaadhipradana.data.repository

import com.satriaadhipradana.shared.model.ProfileModel
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.UUID.randomUUID

@RealmClass
open class ProfileRealm: RealmObject() {
    
    @PrimaryKey
    private var id: String = randomUUID().toString()
    private var firstname: String = ""
    private var lastname: String = ""
    private var email: String = ""
    private var balance: Int = 0
    private var avatar: String? = null
    
    private fun map() = ProfileModel(
        id, ("$firstname $lastname"),
        email, balance, avatar
    )
    
    fun findProfile(
        name: String,
        @Suppress("unused_parameter")
        password: String,
    ): ProfileModel? {
        val realm = Realm.getDefaultInstance()
        
        val profile =
            realm.where(this::class.java)
                .equalTo("firstname", name)
                .findFirst()
                ?.map()
        
        realm.close()
        return profile
    }
    
    fun updatePhoto(
        path: String,
        username: String?,
    ) {
        val realm = Realm.getDefaultInstance()
        
        realm.executeTransactionAsync {
            it.where(this::class.java)
                .equalTo("firstname", username)
                .findFirst()
                ?.avatar = path
        }
        
        realm.close()
    }
    
    fun register(
        firstname: String,
        lastname: String,
        email: String,
        password: String,
    ): ProfileModel? {
        val realm = Realm.getDefaultInstance()
        
        realm.where(this::class.java)
            .equalTo("firstname", firstname)
            .findFirst()
            ?.let { realm.close(); return null }
            ?: run {
                
                realm.beginTransaction()
                
                val profile = realm
                    .createObject(
                        this::class.java,
                        randomUUID().toString()
                    )
                
                profile.firstname = firstname
                profile.lastname = lastname
                profile.balance = 0
                profile.email = email
                profile.avatar = null
                
                realm.commitTransaction()
                realm.close()
                
                return findProfile(firstname, password)
            }
    }
}