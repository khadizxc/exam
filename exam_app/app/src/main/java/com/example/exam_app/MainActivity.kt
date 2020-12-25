package com.example.exam_app

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main5.*


class MainActivity : AppCompatActivity() {
    private lateinit var authentication: FirebaseAuth
    private lateinit var emailEt: TextInputEditText
    private lateinit var passwordEt: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authentication = FirebaseAuth.getInstance()

        setContentView(R.layout.activity_main)
        val buttonAdmin = findViewById<Button>(R.id.continueAsAdmin)
        buttonAdmin.setOnClickListener {
            setContentView(R.layout.activity_main2)
            emailEt = findViewById(R.id.email)
            passwordEt = findViewById(R.id.passwordText)
            val buttonContinueAsADmin = findViewById<Button>(R.id.continueAsAdmin)
            buttonContinueAsADmin.setOnClickListener {
                var emaila: String = email.text.toString();
                var password: String = passwordText.text.toString();
                if (TextUtils.isEmpty(emaila) || TextUtils.isEmpty(password)) {
                    Toast.makeText(
                            this@MainActivity,
                            "Please fill all the fields",
                            Toast.LENGTH_LONG
                    )
                            .show()
                }
                authentication.signInWithEmailAndPassword(emaila, password)
                        .addOnCompleteListener(this, OnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Logged In", Toast.LENGTH_LONG)
                                        .show()
                                setContentView(R.layout.activity_main6)
                                val buttonStaff = findViewById<Button>(R.id.numberStaff)
                                buttonStaff.setOnClickListener {
                                    setContentView(R.layout.activity_main7)
                                }
                            } else {
                                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                            }
                        })

            }
        }
        val buttonStaff = findViewById<Button>(R.id.continueAsStaff)
        buttonStaff.setOnClickListener {
            setContentView(R.layout.activity_main3)
            val buttonRooms = findViewById<Button>(R.id.continueAsStaff2)
            buttonRooms.setOnClickListener {
                var email2s: String = email3Text.text.toString();
                var password2s: String = passwordText2.text.toString();
                if (TextUtils.isEmpty(email2s) || TextUtils.isEmpty(password2s)) {
                    Toast.makeText(
                            this@MainActivity,
                            "Please fill all the fields",
                            Toast.LENGTH_LONG
                    )
                            .show()
                }

                authentication.signInWithEmailAndPassword(email2s, password2s)
                        .addOnCompleteListener(this, OnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Logged In", Toast.LENGTH_LONG)
                                        .show()
                                setContentView(R.layout.activity_main9)
                            } else {
                                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                            }
                        })
            }

        }
        val buttonStudent = findViewById<Button>(R.id.continueAsStudent)
        buttonStudent.setOnClickListener {
            setContentView(R.layout.activity_main4)
            val buttonStudentLogin = findViewById<Button>(R.id.continueAsStudent2)
            buttonStudentLogin.setOnClickListener {
                var emailz: String = email4Text.text.toString();
                var passwordz: String = password4Text.text.toString();
                if (TextUtils.isEmpty(emailz) || TextUtils.isEmpty(passwordz)) {
                    Toast.makeText(
                            this@MainActivity,
                            "Please fill all the fields",
                            Toast.LENGTH_LONG
                    )
                            .show()
                }

                authentication.signInWithEmailAndPassword(emailz, passwordz)
                        .addOnCompleteListener(this, OnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Logged In", Toast.LENGTH_LONG)
                                        .show()
                                setContentView(R.layout.activity_main6)
                            } else {
                                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                            }
                        })
            }
            val registerText = findViewById<TextView>(R.id.register)
            registerText.setOnClickListener {
                setContentView(R.layout.activity_main5)
                val signUpButton = findViewById<Button>(R.id.SignUpButton)
                signUpButton.setOnClickListener {
                    var email: String = emailRegText.text.toString();
                    var password: String = passwordRegText.text.toString();
                    if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                        Toast.makeText(this, "Check all fields", Toast.LENGTH_LONG)
                                .show()
                    } else {
                        authentication.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(this, OnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Toast.makeText(this, "Success", Toast.LENGTH_LONG)
                                                .show()
                                        val intent = Intent(this, MainActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                                    }
                                })
                    }
                }

            }


        }


    }
}
