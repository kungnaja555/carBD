package buu.informatics.s59160951.carbackdoor


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160951.carbackdoor.databinding.FragmentCarparkBinding

/**
 * A simple [Fragment] subclass.
 */
class CarparkFragment : Fragment() {

    private lateinit var binding : FragmentCarparkBinding
    private var car0 = Car(0)
    private var car1 = Car(1)
    private var car2 = Car(2)
    private var cars = arrayOf(car0,car1,car2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_carpark, container, false)

        binding.apply {
            this.bookid = -1
            invalidateAll()
            bookbutton1.setOnClickListener {
                clickbook(it)
            }
            bookbutton2.setOnClickListener {
                clickbook(it)
            }
            bookbutton3.setOnClickListener {
                clickbook(it)
            }
            savebutton.setOnClickListener{
                clicksave(it)
            }
            deletebutton.setOnClickListener {
                clickdelete(it)
            }
            this.cars = this@CarparkFragment.cars
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun clicksave(view: View){
        binding.apply{
            this.bookid = -1;
            this.car?.empty = false;
            invalidateAll();
        }
    }

    private fun clickdelete(view: View){
        binding.apply{
            this.bookid = -1;
            this.car?.delete();
            invalidateAll();
        }
    }

    private fun clickbook(view: View){
        binding.apply {
            when (view.id) {
                R.id.bookbutton1 -> this.bookid = 0;
                R.id.bookbutton2 -> this.bookid = 1;
                R.id.bookbutton3 -> this.bookid = 2;
            }
            this.car = cars?.get(this.bookid)
            invalidateAll()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.yourinfo_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}
