package com.example.lesson4

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson4.entities.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Arrays
import java.util.Date
import java.util.UUID
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object {
        var listTasks: MutableList<Task> = MutableList(25) {
//            if(it%5==0){
//                current = current.plusDays(1)
//                current
//            } else {
                Task(System.nanoTime(), "Подготовиться к собесу", false)
//            }
        }
    }

    private lateinit var adapter: NumbersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.list)

        adapter = NumbersAdapter(listTasks)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        findViewById<Button>(R.id.swap_last).setOnClickListener {
            val newList = ArrayList(listTasks)
            val previous = listTasks[listTasks.size-2]
            listTasks[listTasks.size-2] = listTasks.last()
            listTasks[listTasks.lastIndex] = previous

            adapter.updateItems(newList)
        }

        findViewById<Button>(R.id.incrementLast).setOnClickListener {
            val newList = ArrayList(listTasks)
            newList.add(Task(System.nanoTime(), "Убрать говнокод"))
            adapter.updateItems(newList)
        }
    }
}