package com.android.mycourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MateriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MateriFragment : Fragment(R.layout.fragment_materi) {

    private var isOopExpanded = false
    private var isAndroidExpanded = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headerOop = view.findViewById<LinearLayout>(R.id.header_oop)
        val rvOop = view.findViewById<RecyclerView>(R.id.rv_materi_oop)
        val arrowOop = view.findViewById<ImageView>(R.id.arrow_oop)

        val headerAndroid = view.findViewById<LinearLayout>(R.id.header_android)
        val rvAndroid = view.findViewById<RecyclerView>(R.id.rv_materi_android)
        val arrowAndroid = view.findViewById<ImageView>(R.id.arrow_android)

        rvOop.layoutManager = LinearLayoutManager(requireContext())
        rvAndroid.layoutManager = LinearLayoutManager(requireContext())

        val listOop = listOf(
            MateriItem("Pengenalan OOP", "Konsep dasar class, object, dan encapsulation"),
            MateriItem("Inheritance", "Pewarisan sifat antar class di Kotlin"),
            MateriItem("Polymorphism", "Satu method, banyak bentuk implementasi"),
            MateriItem("Abstraction", "Menyembunyikan detail implementasi lewat abstract class/interface"),
            MateriItem("Interface", "Kontrak method yang wajib diimplementasikan oleh class"),
            MateriItem("Constructor & Object Lifecycle", "Inisialisasi objek dan siklus hidupnya di Kotlin")
        )

        val listAndroid = listOf(
            MateriItem("Layout & View", "LinearLayout, ConstraintLayout, dan komponen View dasar"),
            MateriItem("RecyclerView", "Menampilkan data dalam bentuk list dinamis"),
            MateriItem("Fragment & TabLayout", "Navigasi antar tab menggunakan ViewPager2"),
            MateriItem("Options Menu", "Membuat menu di toolbar dengan onCreateOptionsMenu"),
            MateriItem("Custom Style & Drawable", "Membuat tampilan konsisten dengan style.xml dan selector"),
            MateriItem("Activity Lifecycle", "Memahami siklus hidup Activity dari onCreate hingga onDestroy")
        )

        rvOop.adapter = MateriAdapter(listOop)
        rvAndroid.adapter = MateriAdapter(listAndroid)

        headerOop.setOnClickListener {
            isOopExpanded = !isOopExpanded
            rvOop.visibility = if (isOopExpanded) View.VISIBLE else View.GONE
            arrowOop.rotation = if (isOopExpanded) 180f else 0f
        }

        headerAndroid.setOnClickListener {
            isAndroidExpanded = !isAndroidExpanded
            rvAndroid.visibility = if (isAndroidExpanded) View.VISIBLE else View.GONE
            arrowAndroid.rotation = if (isAndroidExpanded) 180f else 0f
        }
    }
}