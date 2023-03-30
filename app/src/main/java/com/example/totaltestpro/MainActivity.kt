package com.example.totaltestpro

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.totaltestpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.ivCallActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    //오버플로우 버튼을 클릭하면 오버플로우 메뉴를 보여준다.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menu?.add(0, 0, 0, "메뉴1")
//        menu?.add(0, 1, 0, "메뉴2")
//        menu?.add(0, 2, 0, "메뉴3")
        menuInflater.inflate(R.menu.user_menu,menu)
        val searchMenuItem = menu?.findItem(R.id.menu_search)
        val searchView = searchMenuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            // 검색창에 검색글을 입력하고 엔터를 칠 때 콜백함수
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext,"${query}",Toast.LENGTH_SHORT).show()
                return true
            }
            // 검색창에 검색을 입력할 때마다 콜백발생
            override fun onQueryTextChange(newText: String?): Boolean {
//                Log.e("MainActivity","${newText}")
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

    // 오버플로우메뉴 클릭 콜백함수
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> Toast.makeText(applicationContext, "${item.title}클릭", Toast.LENGTH_SHORT).show()
            R.id.menu2 -> Toast.makeText(applicationContext, "${item.title}클릭", Toast.LENGTH_SHORT).show()
            R.id.menu3 -> Toast.makeText(applicationContext, "${item.title}클릭", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(applicationContext, "잘못클릭함", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}