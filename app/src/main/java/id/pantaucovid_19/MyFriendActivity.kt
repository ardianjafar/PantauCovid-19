package id.pantaucovid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import id.pantaucovid_19.notesapp.MyFriendModel
import kotlinx.android.synthetic.main.activity_my_friend.*

class MyFriendActivity : AppCompatActivity() {
    private var Nama: EditText? = null
    private var Email: EditText? = null
    private var Telp: EditText? = null
    private var Alamat: EditText? = null
    lateinit var ref: DatabaseReference
    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_friend)


        Nama = findViewById<EditText>(R.id.nama)
                Email = findViewById<EditText>(R.id.email)
                Telp = findViewById<EditText>(R.id.telp)
                Alamat = findViewById(R.id.alamat)
                ref = FirebaseDatabase.getInstance().getReference()
                auth = FirebaseAuth.getInstance()

                simpan.setOnClickListener {
                prosesSave()
        }
    }


        fun prosesSave() {
            val getNama: String = Nama?.getText().toString()
            val getEmail: String = Email?.getText().toString()
            val getTelp: String = Telp?.getText().toString()
            val getAlamat: String = Alamat?.getText().toString()
            val getUserID: String = auth?.getCurrentUser()?.getUid().toString()

            if (getNama.isEmpty() && getNama.isEmpty() && getTelp.isEmpty() && getAlamat.isEmpty()) {
                //Jika kosong, maka akan menampilkan pesan singkat berikut ini.
                Toast.makeText(this@MyFriendActivity,"Data tidak boleh ada yang kosong", Toast.LENGTH_SHORT).show()
            } else {
                val teman = MyFriendModel(getNama, getEmail, getTelp, getAlamat,getUserID)
                //struktur databasenya adalah: ID >> Teman >> Key >> Data           ref.child(getUserID).child("Teman").push().setValue(teman).addOnCompleteListener {
                Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }