package com.example.groceryguru_derrick

import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment



class AddNewTask : BottomSheetDialogFragment() {

    private var TAG = "ActionBottomDialog"
    private lateinit var newTaskText : EditText
    private lateinit var newTaskSaveButton : Button
    var isUpdate = false

    companion object {
        fun newInstance(): AddNewTask {
            return AddNewTask()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DialogStyle)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.new_task, container, false)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newTaskText = view.findViewById(R.id.newTaskText)
        newTaskSaveButton = view.findViewById(R.id.newTaskButton)


        val bundle : Bundle? = arguments
        if(bundle != null)
        {
            isUpdate = true
            val task = bundle.get("task")
            newTaskText.text = task as Editable?
            //changes the color of the button if the text is there
            if(task?.length!! > 0)
            {
                newTaskSaveButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
            }
        }
        newTaskText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Do something before the text is changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Do something when the text is changing
                //if the string is empty
                if(s.toString() == "")
                {
                    newTaskSaveButton.isEnabled = false
                    newTaskSaveButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.gray))
                }
                else
                {
                    newTaskSaveButton.isEnabled = true
                    newTaskSaveButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // Do something after the text has changed
            }
        })
        //defining listener for our save button
        newTaskSaveButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View){
                val text = newTaskText.text.toString()
                if(isUpdate) {
                    //Todo: Use firebase to update the task that's already there
                }
                else{
                    //else make a new task
                    val task = ToDoModel()
                    task.task = text
                    task.status = 0
                }
                dismiss()
            }
        })
    }



    override fun onDismiss(dialog: DialogInterface) {
        val activity : FragmentActivity? = activity
        if (activity is DialogCloseListener) {
            (activity as DialogCloseListener).handleDialogClose(dialog)
        }
    }
}