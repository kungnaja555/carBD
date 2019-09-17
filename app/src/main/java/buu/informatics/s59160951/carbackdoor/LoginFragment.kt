package buu.informatics.s59160951.carbackdoor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160951.carbackdoor.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.apply {
            this.alertLogin = 0;
            invalidateAll()
            loginbutton.setOnClickListener {
                clicklogin(it)
            }
        }
        return binding.root
    }

    private fun clicklogin(view: View){
        binding.apply {
            var user = userEdit.text.toString()
            var pass = passEdit.text.toString()
            if(user == "admin" && pass == "1234"){
                view.findNavController().navigate(R.id.action_loginFragment_to_carparkFragment)
            }else{
                this.alertLogin = 1;
                invalidateAll()
            }

        }
    }

}
