package com.example.lesson4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lesson4.entities.Task
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ItemDiffUtilCallback(private val oldList: List<Task>, private val newList: List<Task>): DiffUtil.Callback(){
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}

class NumbersAdapter(private val list: MutableList<Task>): Adapter<ViewHolder>() {

    fun updateItems(newList: List<Task>){
        val diff = DiffUtil.calculateDiff(ItemDiffUtilCallback(list, newList))

        list.clear()
        list.addAll(newList)

        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TaskerViewType.DATA.ordinal ->{
                DateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false))
            }
            TaskerViewType.TASK.ordinal -> {
                TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
            }
            else -> {
                throw Exception("unknown type")
            }
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int) =
//        if (position%5==0) {
//            TaskerViewType.DATA.ordinal
//        } else
            TaskerViewType.TASK.ordinal

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is DateViewHolder -> {
                holder.bind(list[position] as LocalDateTime)
            }
            is TaskViewHolder -> {
                holder.bind(list[position] as Task)
            }
        }
    }
}

enum class TaskerViewType{
    DATA, //0
    TASK, //1
}

class DateViewHolder(view: View): ViewHolder(view) {
    private val dateTv: TextView = itemView.findViewById(R.id.date)

    fun bind(date: LocalDateTime){
        dateTv.text = date.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }
}

class TaskViewHolder(view: View): ViewHolder(view) {
    private val taskDescTv: TextView = itemView.findViewById(R.id.desc)

    fun bind(task: Task){
        taskDescTv.text = task.taskDescription
    }
}