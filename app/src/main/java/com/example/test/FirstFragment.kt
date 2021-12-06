package com.example.test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentFirstBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import android.content.Intent




//import android.R










/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var userID: String? =null
    private var passwordID: String? =null
    private var txv: TextView? =null

    private var mAuth: FirebaseAuth? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            userID = user.toString().trim()
            passwordID = password.toString()
            var intent =Intent()
            intent.putExtra("user",userID)
            //startActivity(intent)
            //if (mAuth != null) {
                //mAuth!!.signInWithEmailAndPassword(userID!!, passwordID!!).addOnCompleteListener{ task->
                   // if(task.isSuccessful){
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                   // }
                //}
            //}
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}