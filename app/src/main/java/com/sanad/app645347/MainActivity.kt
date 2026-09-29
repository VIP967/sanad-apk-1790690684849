package com.sanad.app645347

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sanad.app645347.databinding.ActivityMainKtBinding // Assumed viewBinding setup mapped via standard convention or standard layout inflation

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigation)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, HomeFragment())
                .commit()
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_quran -> QuranFragment()
                R.id.nav_worship -> WorshipFragment()
                R.id.nav_qibla -> QiblaFragment()
                R.id.nav_more -> MoreFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, selectedFragment)
                .commit()
            true
        }
    }
}

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = TextView(requireContext())
        view.text = "مرحباً بك في نسكي — رفيقك في عبادتك\nالصفحة الرئيسية"
        view.textSize = 20f
        view.gravity = android.view.Gravity.CENTER
        return view
    }
}

class QuranFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = TextView(requireContext())
        view.text = "القرآن الكريم"
        view.textSize = 20f
        view.gravity = android.view.Gravity.CENTER
        return view
    }
}

class WorshipFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = TextView(requireContext())
        view.text = "العبادات والأذكار"
        view.textSize = 20f
        view.gravity = android.view.Gravity.CENTER
        return view
    }
}

class QiblaFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = TextView(requireContext())
        view.text = "اتجاه القبلة"
        view.textSize = 20f
        view.gravity = android.view.Gravity.CENTER
        return view
    }
}

class MoreFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = TextView(requireContext())
        view.text = "المزيد من الخدمات (الحج، التقويم، الإحصائيات، الإعدادات)"
        view.textSize = 20f
        view.gravity = android.view.Gravity.CENTER
        return view
    }
}