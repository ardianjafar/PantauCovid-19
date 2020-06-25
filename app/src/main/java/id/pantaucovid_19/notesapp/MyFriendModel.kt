package id.pantaucovid_19.notesapp

import androidx.room.Entity
import io.realm.annotations.PrimaryKey

@Entity(tableName = "my_friend")
data class MyFriendModel(
    var nama: String,
    var email: String,
    var telp: String,
    var alamat: String,
    @PrimaryKey var key: String
){
    constructor() : this("","","","",""
    )
}