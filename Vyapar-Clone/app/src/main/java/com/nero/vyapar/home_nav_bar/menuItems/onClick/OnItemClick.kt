package com.nero.vyapar.home_nav_bar.menuItems.onClick

import com.nero.vyapar.local.entity.ItemsEntity

interface OnItemClick {

    fun onClickShare(itemsEntity: ItemsEntity)
    fun onEditClick(itemsEntity: ItemsEntity)
}