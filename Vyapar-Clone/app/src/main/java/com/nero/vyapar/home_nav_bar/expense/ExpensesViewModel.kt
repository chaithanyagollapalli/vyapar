package com.nero.vyapar.home_nav_bar.expense

import androidx.lifecycle.*
import com.nero.vyapar.local.entity.ExpenseEntity
import com.nero.vyapar.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpensesViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    private val hashMap: HashMap<String, Int> = hashMapOf()

    val hashMapList: MutableLiveData<List<CategoryModel>> = MutableLiveData()
    val totalMapList: MutableLiveData<Int> = MutableLiveData()
    fun getExpenses() {
        itemsRepository.getAllExpenses().observeForever(Observer {
            hashMap.values.clear()
            for (i in it) {
                if (hashMap.containsKey(i.cetegory)) {
                    val data = hashMap[i.cetegory]
                    hashMap.put(i.cetegory, i.totalAmount + data!!)
                } else {
                    hashMap.put(i.cetegory, i.totalAmount)
                }
            }
            convertHashmpToList()
        })
    }

    fun getExpenseItems(): LiveData<List<ExpenseEntity>> {
        return itemsRepository.getAllExpenses()
    }


    private fun convertHashmpToList() {
        val list = arrayListOf<CategoryModel>()
        var total = 0
        for (i in hashMap) {
            list.add(CategoryModel(i.key, i.value))
            total += i.value

        }
        totalMapList.postValue(total)
        hashMapList.postValue(list)
    }

}