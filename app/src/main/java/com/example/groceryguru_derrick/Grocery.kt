package com.example.groceryguru_derrick


import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Grocery.newInstance] factory method to
 * create an instance of this fragment.
 */
class Grocery : Fragment(), DialogCloseListener {

    private lateinit var tasksRecyclerView: RecyclerView
    private var tasksAdapter: ToDoAdapter =ToDoAdapter(MainActivity())
    var taskList = ArrayList<ToDoModel>()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.grocery_manager_layout, container, false)

        tasksRecyclerView = view.findViewById(R.id.GroceryListRecyclerView)
        tasksRecyclerView.layoutManager = LinearLayoutManager(MainActivity())
        tasksAdapter = ToDoAdapter(MainActivity())
        tasksRecyclerView.adapter = tasksAdapter


        /*this are the example task to check the

        val task = ToDoModel()
        task.task = "This is a example task"
        task.status = 0
        task.id = 1
        taskList.add(task)
        val othertask = ToDoModel()
        othertask.task = "This is a other example task"
        othertask.status = 1
        othertask.id = 2
        taskList.add(othertask)
        tasksAdapter.setTasks(taskList)
         */
        return view
    }
    /*fun addToList(Status: Int, Task: String){

        val task = ToDoModel()
        task.task = Task
        task.status = Status
        taskList.add(task)
        tasksAdapter.setTasks(taskList)
        tasksAdapter.notifyDataSetChanged()
    }
     */

    override fun handleDialogClose(dialog : DialogInterface){
        //Todo: get all the tasks from firebase
        //Todo: reverse the list by doing Collections.reverse(taskList)
        tasksAdapter.setTasks(taskList)
        tasksAdapter.notifyDataSetChanged()
    }

    class ToDoAdapter(private var activity: MainActivity) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {
        private var todoList: List<ToDoModel>? = null
        fun toDoAdapter(activity: MainActivity) {
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
        fun setTasks(list :List<ToDoModel>){
            this.todoList = list
        }
        fun editItem(position: Int){
            var itemToEdit : ToDoModel? = todoList?.get(position)
            val bundle = Bundle()
            bundle.putInt("id", itemToEdit!!.id)
            bundle.putString("task",itemToEdit.task)
            val fragment = AddNewTask()
            fragment.arguments = bundle
            fragment.show(activity.supportFragmentManager,"ActionBottomDialog")
        }
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var task: CheckBox = itemView.findViewById(R.id.todoCheckBox)
        }
    }




    
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment grocery.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Grocery().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

