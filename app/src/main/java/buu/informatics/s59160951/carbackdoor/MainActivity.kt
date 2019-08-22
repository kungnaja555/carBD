package buu.informatics.s59160951.carbackdoor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160951.carbackdoor.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import android.app.AlertDialog
import android.content.DialogInterface

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val carInfo = Array(3){CarInfo()}
    private var ind = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            updateBt.setOnClickListener {
                updateDataCar(it)
            }
            deleteBt.setOnClickListener{
                deleteDataCar(it)
            }
            carPark1.setOnClickListener {
                ind = 0
                this.carInfo = this@MainActivity.carInfo[ind]
            }
            carPark2.setOnClickListener {
                ind = 1
                this.carInfo = this@MainActivity.carInfo[ind]
            }
            carPark3.setOnClickListener {
                ind = 2
                this.carInfo = this@MainActivity.carInfo[ind]
            }
        }
    }

    private fun updateDataCar(view: View) {
        binding.apply {
            var idCarTxt = idCar.text.toString()
            var brandTxt = brand.text.toString()
            var nameTxt = name.text.toString()
            if(idCarTxt != "" && brandTxt != "" && nameTxt != ""){
                this@MainActivity.carInfo[ind]?.idCar = idCarTxt
                this@MainActivity.carInfo[ind]?.brand = brandTxt
                this@MainActivity.carInfo[ind]?.name = nameTxt
                when(ind){
                    0 -> carPark1.text = idCarTxt
                    1 -> carPark2.text = idCarTxt
                    2 -> carPark3.text = idCarTxt
                }
                invalidateAll()
            }else{
               showAlert()
            }
        }
    }

    private fun showAlert(){
        val dialogBuilder = AlertDialog.Builder(this@MainActivity)
        dialogBuilder.setMessage("กรุณากรอกข้อมูลให้ครบถ้วน")
            .setCancelable(false)
            .setPositiveButton("ตกลง", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            .setNegativeButton("ยกเลิก", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("เกิดข้อผิดพลาด")
        alert.show()
    }

    private fun deleteDataCar(view: View){
        binding.apply {
            this@MainActivity.carInfo[ind]?.idCar = ""
            this@MainActivity.carInfo[ind]?.brand = ""
            this@MainActivity.carInfo[ind]?.name = ""
            when(ind){
                0 -> carPark1.text = "ว่าง"
                1 -> carPark2.text = "ว่าง"
                2 -> carPark3.text = "ว่าง"
            }
            invalidateAll()
        }
    }



}

