package com.example.groceryguru_derrick


import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Grocery : Fragment(), DialogCloseListener {

    private lateinit var tasksRecyclerView: RecyclerView
    var tasksAdapter: ToDoAdapter =ToDoAdapter(this)
    private val taskList = ArrayList<ToDoModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.grocery_manager_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasksRecyclerView = view.findViewById(R.id.GroceryListRecyclerView)
        tasksAdapter = ToDoAdapter(this)
        tasksRecyclerView.adapter = tasksAdapter
        tasksRecyclerView.layoutManager = LinearLayoutManager(MainActivity())
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(tasksRecyclerView)
        /*this are the example task to check the
        */
        val task = ToDoModel()
        task.task = "Steak"
        task.status = 0
        task.id = 1
        taskList.add(task)
        val othertask = ToDoModel()
        othertask.task = "Eggs"
        othertask.status = 1
        othertask.id = 2
        taskList.add(othertask)
        tasksAdapter.setTasks(taskList)
    }



    fun addData(newModelData: ToDoModel, position: Int) {
        taskList.add(position, newModelData)
        tasksAdapter.notifyDataSetChanged()
    }
    override fun handleDialogClose(dialog : DialogInterface){
        val temp = AddNewTask.othertask
        taskList.add(temp)
        taskList.reverse()
        tasksAdapter.setTasks(taskList)
        tasksAdapter.notifyDataSetChanged()

    }
    private val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        // Implement your desired behavior for item swiping or dragging
        // Override the necessary methods within the callback object
        // This is an anonymous object that extends ItemTouchHelper.SimpleCallback
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            taskList.removeAt(viewHolder.adapterPosition)
            tasksAdapter.notifyDataSetChanged()
        }
    }
}
class ToDoAdapter(private var activity: Grocery) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {
    private var todoList: ArrayList<ToDoModel>? = null
    fun toDoAdapter(activity: Grocery) {
        this.activity = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = todoList?.get(position)
        holder.task.text = item?.task
        holder.task.isChecked = toBoolean(item?.status)
    }
    override fun getItemCount(): Int {
        return todoList?.size ?: 0
    }

    private fun toBoolean(n: Int?): Boolean {
        return n != 0
    }
    fun setTasks(list :ArrayList<ToDoModel>){
        this.todoList = list
    }
    fun editItem(position: Int){
        val itemToEdit : ToDoModel? = todoList?.get(position)
        val bundle = Bundle()
        bundle.putInt("id", itemToEdit!!.id)
        bundle.putString("task",itemToEdit.task)
        val fragment = AddNewTask()
        fragment.arguments = bundle
        fragment.show(activity.childFragmentManager,AddNewTask.TAG)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var task: CheckBox = itemView.findViewById(R.id.todoCheckBox)
    }

}

