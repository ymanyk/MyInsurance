package my.edu.tarc.myinsurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.myinsurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Show the UI
        binding = ActivityMainBinding.inflate(layoutInflater)
        //binding = UI tree
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            val age = binding.spinner.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkBoxSmoker.isChecked
            var premium = 0

            if(age == 0){ // less than 17
                premium = 60
            }
            if(age == 1 ){
                premium = 50
            }
            if(age == 2){
                premium = 90
            }
            if(age == 3 ){
                premium = 120
            }
            if(age == 4 ){
                premium = 150
            }
            if(age == 5){
                premium = 150
            }

            if(gender == binding.radioButtonMale.id){
                if(age == 1){
                    premium += 50
                }
                if(age == 2){
                    premium += 100
                }
                if(age == 3){
                    premium += 150
                }
                if(age == 4 ){
                    premium += 200
                }
                if(age == 5){
                    premium += 200
                }
            }

            if(smoker == true){
                if(age == 1){
                    premium += 100
                }
                if(age == 2){
                    premium += 150
                }
                if(age == 3){
                    premium += 200
                }
                if(age == 4 ){
                    premium += 250
                }
                if(age == 5){
                    premium += 300
                }
            }
            binding.textViewPremium.text = premium.toString()
        }

        binding.buttonReset.setOnClickListener {
            binding.textViewPremium.setText("No Value")
            binding.checkBoxSmoker.setChecked(false) //isChecked = false
            binding.radioGroupGender.clearCheck()
            binding.spinner.setSelection(0)
        }

    }
}